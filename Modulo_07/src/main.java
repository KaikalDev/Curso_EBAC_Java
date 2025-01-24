public class main {

    public static void main(String[] args) {
        Carro carro = new Carro();

        carro.setLigado(true);
        System.out.println("Ligando o carro");
        carro.acelerar();
        System.out.println("Acelerando o carro");
        carro.frear();
        System.out.println("Freando o carro");
    }
}
