package kaique.luan.dev.services;

import kaique.luan.dev.dao.intefaces.IClienteDAO;
import kaique.luan.dev.domain.Cliente;
import kaique.luan.dev.exceptions.DAOException;
import kaique.luan.dev.exceptions.MaisDeUmRegistroException;
import kaique.luan.dev.exceptions.TableException;
import kaique.luan.dev.services.generic.GenericService;
import kaique.luan.dev.services.interfaces.IClienteService;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

    //private IClienteDAO clienteDAO;

    public ClienteService(IClienteDAO clienteDAO) {
        super(clienteDAO);
        //this.clienteDAO = clienteDAO;
    }

//	@Override
//	public Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException {
//		return clienteDAO.cadastrar(cliente);
//	}

    @Override
    public Cliente buscarPorCPF(Long cpf) throws DAOException {
        try {
            return this.dao.consultar(cpf);
        } catch (MaisDeUmRegistroException | TableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

//	@Override
//	public void excluir(Long cpf) {
//		clienteDAO.excluir(cpf);
//	}
//
//	@Override
//	public void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException{
//		clienteDAO.alterar(cliente);
//	}

}