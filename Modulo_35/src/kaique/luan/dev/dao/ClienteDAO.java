package kaique.luan.dev.dao;

import kaique.luan.dev.dao.generic.GenericDAO;
import kaique.luan.dev.dao.intefaces.IClienteDAO;
import kaique.luan.dev.domain.Cliente;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {

    public ClienteDAO() {
        super(Cliente.class);
    }
}