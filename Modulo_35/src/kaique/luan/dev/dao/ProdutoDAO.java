package kaique.luan.dev.dao;

import kaique.luan.dev.dao.generic.GenericDAO;
import kaique.luan.dev.dao.intefaces.IProdutoDAO;
import kaique.luan.dev.domain.Produto;

public class ProdutoDAO extends GenericDAO<Produto, Long> implements IProdutoDAO {

    public ProdutoDAO() {
        super(Produto.class);
    }
}