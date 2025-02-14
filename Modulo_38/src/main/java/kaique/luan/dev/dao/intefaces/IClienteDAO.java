package kaique.luan.dev.dao.intefaces;

import java.util.List;

import kaique.luan.dev.dao.generic.IGenericDAO;
import kaique.luan.dev.domain.Cliente;

public interface IClienteDAO extends IGenericDAO<Cliente, Long> {

	List<Cliente> filtrarClientes(String query);


}