package kaique.luan.dev;

import kaique.luan.dev.Enums.ETypeProduto;
import kaique.luan.dev.dao.ProdutoDAO;
import kaique.luan.dev.dao.interfaces.IProdutoDAO;
import kaique.luan.dev.domain.Produto;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ProdutoTest {

    private IProdutoDAO produtoDAO;

    public ProdutoTest() {
        produtoDAO = new ProdutoDAO();
    }

    @After
    public void EndTest() {
        produtoDAO.excluirTudo();
    }

    public Produto criarProduto(String codigo, String nome, ETypeProduto tipo, Double valor, Integer qtdEstoque) {
        Produto produto = new Produto();
        produto.setCodigo(codigo);
        produto.setNome(nome);
        produto.setTipo(tipo);
        produto.setValor(valor);
        produto.setQtdEstoque(qtdEstoque);

        return produto;
    }

    @Test
    public void cadastrarTest() {
        Produto produto = criarProduto("A1", "Queijo", ETypeProduto.FRIOS, 24.5D, 24);
        produtoDAO.cadastrar(produto);
        Produto produtoBD = produtoDAO.buscar(produto.getCodigo());
        Assert.assertNotNull(produtoBD);
        Assert.assertNotNull(produtoBD.getID());
        Assert.assertEquals(produto.getCodigo(), produtoBD.getCodigo());
    }

    @Test
    public void excluirTest() {
        Produto produto = criarProduto("A1", "Queijo", ETypeProduto.FRIOS, 24.5D, 24);
        produtoDAO.cadastrar(produto);
        produtoDAO.excluir(produto.getCodigo());
        Produto produtoBD = produtoDAO.buscar(produto.getCodigo());
        Assert.assertNull(produtoBD);
    }

    @Test
    public void AlterarTest() {
        Produto produto = criarProduto("A1", "Queijo", ETypeProduto.FRIOS, 24.5D, 24);
        produtoDAO.cadastrar(produto);

        produto.setQtdEstoque(20);
        produto.setNome("Leite");
        produtoDAO.alterar(produto);
        Produto produtoBD = produtoDAO.buscar(produto.getCodigo());

        Assert.assertEquals(produto.getQtdEstoque(), produtoBD.getQtdEstoque());
        Assert.assertEquals(produto.getNome(), produtoBD.getNome());
    }

    @Test
    public void buscarTodosTest() {
        Produto produto = criarProduto("A1", "Queijo", ETypeProduto.FRIOS, 24.5D, 24);
        Produto produto1 = criarProduto("A2", "Frango", ETypeProduto.CARNE, 50.99D, 12);
        produtoDAO.cadastrar(produto);
        produtoDAO.cadastrar(produto1);
        List<Produto> ListProdutos = produtoDAO.buscarTodos();
        Assert.assertNotNull(ListProdutos);
    }
}
