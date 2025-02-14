/**
 * 
 */
package kaique.luan.dev.service.interfaces;

import java.util.List;

import kaique.luan.dev.domain.Produto;
import kaique.luan.dev.services.interfaces.IGenericService;

public interface IProdutoService extends IGenericService<Produto, String> {

	List<Produto> filtrarProdutos(String query);

}
