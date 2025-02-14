/**
 * 
 */
package kaique.luan.dev.services.generic;

import java.io.Serializable;
import java.util.Collection;

import kaique.luan.dev.dao.generic.IGenericDAO;
import kaique.luan.dev.domain.Persistente;
import kaique.luan.dev.exceptions.DAOException;
import kaique.luan.dev.exceptions.MaisDeUmRegistroException;
import kaique.luan.dev.exceptions.TableException;
import kaique.luan.dev.exceptions.TipoChaveNaoEncontradaException;
import kaique.luan.dev.services.interfaces.IGenericService;

public abstract class GenericService<T extends Persistente, E extends Serializable> 
	implements IGenericService<T, E> {
	
	protected IGenericDAO<T, E> dao;
	
	public GenericService(IGenericDAO<T, E> dao) {
		this.dao = dao;
	}
	

	@Override
	public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
		return this.dao.cadastrar(entity);
	}

	@Override
	public void excluir(T entity) throws DAOException {
		this.dao.excluir(entity);
	}

	@Override
	public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
		return this.dao.alterar(entity);
	}

	@Override
	public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException {
		return this.dao.consultar(valor);
	}

	@Override
	public Collection<T> buscarTodos() throws DAOException {
		return this.dao.buscarTodos();
	}
	

}
