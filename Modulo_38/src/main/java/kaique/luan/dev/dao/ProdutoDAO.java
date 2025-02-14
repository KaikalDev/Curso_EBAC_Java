package kaique.luan.dev.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import kaique.luan.dev.dao.generic.GenericDAO;
import kaique.luan.dev.dao.intefaces.IProdutoDAO;
import kaique.luan.dev.domain.Produto;

public class ProdutoDAO extends GenericDAO<Produto, String> implements IProdutoDAO {

	public ProdutoDAO() {
		super(Produto.class);
	}

	@Override
	public List<Produto> filtrarProdutos(String query) {
		TypedQuery<Produto> tpQuery = 
				this.entityManager.createNamedQuery("Produto.findByNome", this.persistenteClass);
		tpQuery.setParameter("nome", "%" + query + "%");
        return tpQuery.getResultList();
	}
}