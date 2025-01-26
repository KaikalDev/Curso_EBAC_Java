package kaique.luan.dev.services.interfaces;

import kaique.luan.dev.domain.Cliente;
import kaique.luan.dev.exceptions.DAOException;
import kaique.luan.dev.services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

    //	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
//
    Cliente buscarPorCPF(Long cpf) throws DAOException;
//
//	void excluir(Long cpf);
//
//	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}