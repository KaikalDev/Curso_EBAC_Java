package Kaique.luan.dev;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        boolean loop = true;
        do {
            System.out.println("Insira o nome e o sexo: (nome,sexo) ou digite 'sair' para encerrar: ");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("sair")) {
                loop = false;
                break;
            }

            String[] res = input.split(",");
            if (res.length == 2 && (res[1].equalsIgnoreCase("masculino") || res[1].equalsIgnoreCase("feminino"))) {
                Pessoa pess = new Pessoa(res[0].trim(), res[1].trim());
                pessoas.add(pess);
            } else {
                System.out.println("Entrada inválida. Certifique-se de inserir no formato 'nome,sexo'.");
            }
        } while (loop);

        List<Pessoa> fem = FiltraFem(pessoas);

        System.out.println("Nomes femininos:");
        fem.forEach(p -> System.out.println(p.getNome()));
    }

    public static List<Pessoa> FiltraFem(List<Pessoa> pessoas) {
        return  pessoas.stream()
                    .filter(p -> p.getSexo().equalsIgnoreCase("feminino"))
                    .collect(Collectors.toList());
    }
}