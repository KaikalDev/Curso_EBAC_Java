package kaique.luan.dev.useCase;

import jakarta.validation.Valid;
import kaique.luan.dev.domain.Produto;
import kaique.luan.dev.repository.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class Cadastro {
    private final IProdutoRepository produtoRepository;

    @Autowired
    public Cadastro(IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto cadastrar(@Valid Produto produto) {
        return (Produto)this.produtoRepository.save(produto);
    }

    public Produto atualizar(@Valid Produto produto) {
        return (Produto)this.produtoRepository.save(produto);
    }

    public void remover(Long id) {
        Produto prod = (Produto)this.produtoRepository.findById(id).orElseThrow();
        this.produtoRepository.save(prod);
    }
}