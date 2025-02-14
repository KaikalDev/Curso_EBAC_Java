/**
 * 
 */
package kaique.luan.dev.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import Enums.EStatusVendas;
import kaique.luan.dev.dao.intefaces.IVendaDAO;
import kaique.luan.dev.domain.Venda;
import kaique.luan.dev.exceptions.DAOException;
import kaique.luan.dev.exceptions.TipoChaveNaoEncontradaException;
import kaique.luan.dev.service.interfaces.IVendaService;
import kaique.luan.dev.services.generic.GenericService;

@Stateless
public class VendaService extends GenericService<Venda, Long> implements IVendaService {

	IVendaDAO dao;
	
	@Inject
	public VendaService(IVendaDAO dao) {
		super(dao);
		this.dao = dao;
	}

	@Override
	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
		venda.setStatus(EStatusVendas.CONCLUIDA);
		dao.finalizarVenda(venda);
	}

	@Override
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
		venda.setStatus(EStatusVendas.CANCELADA);
		dao.cancelarVenda(venda);
	}

	@Override
	public Venda consultarComCollection(Long id) {
		return dao.consultarComCollection(id);
	}

	@Override
	public Venda cadastrar(Venda entity) throws TipoChaveNaoEncontradaException, DAOException {
		entity.setStatus(EStatusVendas.INICIADA);
		return super.cadastrar(entity);
	}
	
	

}
