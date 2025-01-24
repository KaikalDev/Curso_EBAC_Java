import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("insira um numero: ");
        long num = sc.nextLong();
        System.out.println("Tipo primitivo (long): " + num);

        Long numWrapper = Long.valueOf(num);
        System.out.println("Tipo Wrapper (Long): " + numWrapper);
    }
}