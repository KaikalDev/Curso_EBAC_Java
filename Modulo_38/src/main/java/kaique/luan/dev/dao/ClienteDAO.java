package kaique.luan.dev.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import kaique.luan.dev.dao.generic.GenericDAO;
import kaique.luan.dev.dao.intefaces.IClienteDAO;
import kaique.luan.dev.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {

    public ClienteDAO() {
        super(Cliente.class);
    }

	@Override
	public List<Cliente> filtrarClientes(String query) {
		TypedQuery<Cliente> tpQuery = 
				this.entityManager.createNamedQuery("Cliente.findByNome", this.persistenteClass);
		tpQuery.setParameter("nome", "%" + query + "%");
        return tpQuery.getResultList();
	}
}