package kaique.luan.dev.dao.intefaces;

import kaique.luan.dev.dao.generic.IGenericDAO;
import kaique.luan.dev.domain.Venda;
import kaique.luan.dev.exceptions.DAOException;
import kaique.luan.dev.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {

    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

    public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
}