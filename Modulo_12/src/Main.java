import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Pessoa> mas = new ArrayList<>();
        List<Pessoa> fem = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        boolean loop = true;
        do {
            System.out.println("Insira o nome e o sexo: (nome,sexo) ou digite 'sair' para encerrar: ");
            String input = sc.nextLine();

            if(input.equalsIgnoreCase("sair")) {
                loop = false;
                break;
            }

            String[] res = input.split(",");
            if (res.length == 2) {
                Pessoa pess = new Pessoa(res[0].trim(), res[1].trim());
                if(pess.getSexo().equalsIgnoreCase("masculino")) {
                    mas.add(pess);
                } else if(pess.getSexo().equalsIgnoreCase("feminino")) {
                    fem.add(pess);
                } else {
                    System.out.println("Sexo inválido. Use 'masculino' ou 'feminino'.");
                }
            } else {
                System.out.println("Entrada inválida. Certifique-se de inserir no formato 'nome,sexo'.");
            }
        } while (loop);

        System.out.println("Nomes masculinos:");
        for(Pessoa p : mas) {
            System.out.println(p.getNome());
        }

        System.out.println("Nomes femininos:");
        for(Pessoa p : fem) {
            System.out.println(p.getNome());
        }
    }
}
