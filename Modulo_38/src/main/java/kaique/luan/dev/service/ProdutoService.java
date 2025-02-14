/**
 * 
 */
package kaique.luan.dev.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import kaique.luan.dev.dao.intefaces.IProdutoDAO;
import kaique.luan.dev.domain.Produto;
import kaique.luan.dev.services.generic.GenericService;
import kaique.luan.dev.service.interfaces.IProdutoService;

@Stateless
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {
	
	private IProdutoDAO produtoDao;

	@Inject
	public ProdutoService(IProdutoDAO produtoDao) {
		super(produtoDao);
		this.produtoDao = produtoDao;
	}

	@Override
	public List<Produto> filtrarProdutos(String query) {
		return produtoDao.filtrarProdutos(query);
	}

}

