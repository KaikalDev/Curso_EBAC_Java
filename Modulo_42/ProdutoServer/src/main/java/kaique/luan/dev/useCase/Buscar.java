package kaique.luan.dev.useCase;

import kaique.luan.dev.domain.Produto;
import kaique.luan.dev.repository.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class Buscar {
    private final IProdutoRepository produtoRepository;

    @Autowired
    public Buscar(IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Page<Produto> buscar(Pageable pageable) {
        return this.produtoRepository.findAll(pageable);
    }
}