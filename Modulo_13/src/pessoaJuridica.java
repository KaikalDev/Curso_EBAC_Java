public class pessoaJuridica extends Pessoa{
    private String cnpj;

    public pessoaJuridica(String nome, int idade, String cnpj) {
        super(nome, idade);
        this.cnpj = cnpj;
    }
}
