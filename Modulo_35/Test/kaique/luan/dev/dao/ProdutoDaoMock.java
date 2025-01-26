package kaique.luan.dev.dao;

import kaique.luan.dev.dao.intefaces.IProdutoDAO;
import kaique.luan.dev.domain.Produto;
import kaique.luan.dev.exceptions.DAOException;
import kaique.luan.dev.exceptions.MaisDeUmRegistroException;
import kaique.luan.dev.exceptions.TableException;
import kaique.luan.dev.exceptions.TipoChaveNaoEncontradaException;

import java.util.Collection;
import java.util.List;

public class ProdutoDaoMock implements IProdutoDAO {

    @Override
    public Produto cadastrar(Produto entity) throws TipoChaveNaoEncontradaException, DAOException {
        return null;
    }

    @Override
    public void excluir(Produto entity) throws DAOException {

    }

    @Override
    public Produto alterar(Produto entity) throws TipoChaveNaoEncontradaException, DAOException {
        return null;
    }

    @Override
    public Produto consultar(Long id) throws MaisDeUmRegistroException, TableException, DAOException {
        return null;
    }

    @Override
    public Collection<Produto> buscarTodos() throws DAOException {
        return List.of();
    }
}