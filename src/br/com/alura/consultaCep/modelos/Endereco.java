package br.com.alura.consultaCep.modelos;

import br.com.alura.consultaCep.excecoes.BuscaInvalidaException;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

public record Endereco(String cep, String bairro, String localidade, String estado, String regiao) {
    public static Endereco buscaEndereco(String busca) throws IOException, InterruptedException {
        String endereco = "https://viacep.com.br/ws/" + URLEncoder.encode(busca, StandardCharsets.UTF_8) + "/json";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 400 || response.statusCode() == 404) {
            throw new BuscaInvalidaException("CEP inválido ou não encontrado, tente novamente.");
        }

        String json = response.body();
        System.out.println(json);

        Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
        return gson.fromJson(json, Endereco.class);
    }

    public static void salvaEnderecos(List<Endereco> enderecos) {
        try (FileWriter fileWriter = new FileWriter("enderecos.json")) {
            Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
            fileWriter.write(gson.toJson(enderecos));
            System.out.println(enderecos);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
