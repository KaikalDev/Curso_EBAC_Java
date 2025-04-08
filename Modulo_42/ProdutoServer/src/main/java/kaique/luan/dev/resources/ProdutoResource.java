package kaique.luan.dev.resources;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import kaique.luan.dev.domain.Produto;
import kaique.luan.dev.useCase.Buscar;
import kaique.luan.dev.useCase.Cadastro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
    name = "Produtos",
    description = "Operações relacionadas aos Produtos"
)
@RestController
@RequestMapping({"/Produto"})
public class ProdutoResource {
    private final Buscar buscarProduto;
    private final Cadastro cadastrarProduto;

    @Autowired
    public ProdutoResource(Buscar buscarProduto, Cadastro cadastrarProduto) {
        this.buscarProduto = buscarProduto;
        this.cadastrarProduto = cadastrarProduto;
    }

    @PostMapping
    @Operation(
        summary = "POST"
    )
    public ResponseEntity<Produto> cadastrar(@RequestBody @Valid Produto produto) {
        return ResponseEntity.ok(this.cadastrarProduto.cadastrar(produto));
    }

    @PutMapping
    @Operation(
        summary = "PUT"
    )
    public ResponseEntity<Produto> atualizar(@RequestBody @Valid Produto produto) {
        return ResponseEntity.ok(this.cadastrarProduto.atualizar(produto));
    }

    @DeleteMapping({"/{id}"})
    @Operation(
        summary = "DELETE By ID"
    )
    public ResponseEntity<String> remover(@PathVariable("id") Long id) {
        this.cadastrarProduto.remover(id);
        return ResponseEntity.ok("Removido com sucesso");
    }

    @GetMapping
    @Operation(
        summary = "GET"
    )
    public ResponseEntity<Page<Produto>> buscar(Pageable pageable) {
        return ResponseEntity.ok(this.buscarProduto.buscar(pageable));
    }
}