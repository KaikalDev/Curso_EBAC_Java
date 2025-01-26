package kaique.luan.dev.dao;

import kaique.luan.dev.dao.intefaces.IClienteDAO;
import kaique.luan.dev.domain.Cliente;
import kaique.luan.dev.exceptions.DAOException;
import kaique.luan.dev.exceptions.MaisDeUmRegistroException;
import kaique.luan.dev.exceptions.TableException;
import kaique.luan.dev.exceptions.TipoChaveNaoEncontradaException;

import java.util.Collection;
import java.util.List;

public class ClienteDaoMock implements IClienteDAO {


    @Override
    public Cliente cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException, DAOException {
        return null;
    }

    @Override
    public void excluir(Cliente entity) throws DAOException {

    }

    @Override
    public Cliente alterar(Cliente entity) throws TipoChaveNaoEncontradaException, DAOException {
        return null;
    }

    @Override
    public Cliente consultar(Long id) throws MaisDeUmRegistroException, TableException, DAOException {
        return null;
    }

    @Override
    public Collection<Cliente> buscarTodos() throws DAOException {
        return List.of();
    }
}