package kaique.luan.dev.services;

import kaique.luan.dev.dao.intefaces.IProdutoDAO;
import kaique.luan.dev.domain.Produto;
import kaique.luan.dev.services.generic.GenericService;
import kaique.luan.dev.services.interfaces.IProdutoService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    public ProdutoService(IProdutoDAO dao) {
        super(dao);
    }

}