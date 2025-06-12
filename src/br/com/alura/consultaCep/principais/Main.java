package br.com.alura.consultaCep.principais;

import br.com.alura.consultaCep.excecoes.BuscaInvalidaException;
import br.com.alura.consultaCep.modelos.Endereco;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
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

                Endereco enderecoLocal = Endereco.buscaEndereco(busca);
                System.out.println(enderecoLocal);
                enderecos.add(enderecoLocal);
            } catch (IOException | InterruptedException e) {
                System.out.println("Ocorreu um erro ao consultar a API.");
            } catch (BuscaInvalidaException e) {
                System.out.println(e.getMessage());
            }
        }
        Endereco.salvaEnderecos(enderecos);
    }
}
