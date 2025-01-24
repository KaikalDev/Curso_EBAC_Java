public class Main {
    public static void main(String[] args) {
        Class<Clientes> clienteClass = Clientes.class;

        if (clienteClass.isAnnotationPresent(Tabela.class)) {
            Tabela tabela = clienteClass.getAnnotation(Tabela.class);
            System.out.println("Nome da tabela: " + tabela.nome());
        } else {
            System.out.println("A classe não possui a anotação @Tabela.");
        }
    }
}
