package kaique.luan.dev.dao.interfaces;

import kaique.luan.dev.domain.Produto;

import java.util.List;

public interface IProdutoDAO {
    void cadastrar(Produto produto);

    Produto buscar(String codigo);

    void excluir(String codigo);

    void excluirTudo();

    void alterar(Produto produto);

    List<Produto> buscarTodos();
}
