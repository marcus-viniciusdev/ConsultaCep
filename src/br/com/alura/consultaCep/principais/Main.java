package br.com.alura.consultaCep.principais;

import br.com.alura.consultaCep.excecoes.BuscaInvalidaException;
import br.com.alura.consultaCep.modelos.Endereco;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
    public static void main(String[] args) {
        String busca = "";
        List<Endereco> enderecos = new ArrayList<>();

        System.out.println("Bem-vindo ao consultador de CEPs (digite 'Sair' para fechar o software)");
        while (!busca.equalsIgnoreCase("sair")) {
            try {
                System.out.print("Digite o CEP que deseja consultar: ");
                busca = scanner.nextLine();

                if (busca.equalsIgnoreCase("sair")) {
                    break;
                } else if (busca.isEmpty()) {
                    continue;
                }

                String endereco = "https://viacep.com.br/ws/" + URLEncoder.encode(busca, StandardCharsets.UTF_8) + "/json";
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                System.out.println(json);

                if (response.statusCode() == 400 || response.statusCode() == 404) {
                    throw new BuscaInvalidaException("CEP inválido ou não encontrado, tente novamente.");
                }

                Endereco enderecoLocal = gson.fromJson(json, Endereco.class);
                System.out.println(enderecoLocal);
                enderecos.add(enderecoLocal);
            } catch (IOException | InterruptedException e) {
                System.out.println("Ocorreu um erro ao consultar a API.");
            } catch (BuscaInvalidaException e) {
                System.out.println(e.getMessage());
            }
        }
        try (FileWriter fileWriter = new FileWriter("enderecos.json")) {
            fileWriter.write(gson.toJson(enderecos));
            System.out.println(enderecos);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
