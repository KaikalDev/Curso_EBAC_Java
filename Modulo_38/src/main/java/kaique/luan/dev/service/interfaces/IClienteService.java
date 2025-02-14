/**
 * 
 */
package kaique.luan.dev.service.interfaces;

import java.util.List;

import kaique.luan.dev.domain.Cliente;
import kaique.luan.dev.exceptions.DAOException;
import kaique.luan.dev.services.interfaces.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

	Cliente buscarPorCPF(Long cpf) throws DAOException;

	List<Cliente> filtrarClientes(String query);

}
