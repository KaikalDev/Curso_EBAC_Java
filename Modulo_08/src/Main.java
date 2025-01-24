import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double somaNotas = 0;

        for (int i = 1; i <= 4; i++) {
            System.out.println("Digite a " + i + "º nota");
            somaNotas += sc.nextInt();
        }

        System.out.println("A media é " + somaNotas / 4);
    }
}