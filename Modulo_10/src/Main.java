import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double somaNotas = 0;

        for (int i = 1; i <= 4; i++) {
            System.out.println("Digite a " + i + "º nota");
            somaNotas += sc.nextInt();
        }

        double mediaNotas = somaNotas / 4;

        if (mediaNotas >= 7) {
            System.out.println("Aprovado");
        } else if (mediaNotas >= 5 && mediaNotas < 7) {
            System.out.println("Recuperação");
        } else {
            System.out.println("Reprovado");
        }
    }
}