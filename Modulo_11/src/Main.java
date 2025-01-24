import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> nomes = new ArrayList<>();
        boolean loop = true;
        do {
            System.out.println("Digite um nome: (Digite N para finalizar)");
            String nome = sc.nextLine();
            if(nome.equalsIgnoreCase("n")) {
                loop = false;
            } else {
                nomes.add(nome);
            }
        }while(loop);

        Collections.sort(nomes);

        System.out.println("Nomes ordenados:");
        for (String nome : nomes) {
            System.out.println(nome);
        }
    }
}