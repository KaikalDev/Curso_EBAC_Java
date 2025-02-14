package kaique.luan.dev.dao.intefaces;

import java.util.List;

import kaique.luan.dev.dao.generic.IGenericDAO;
import kaique.luan.dev.domain.Produto;

public interface IProdutoDAO extends IGenericDAO<Produto, String> {

	List<Produto> filtrarProdutos(String query);

}