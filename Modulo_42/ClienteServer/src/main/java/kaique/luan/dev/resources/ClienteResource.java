package kaique.luan.dev.resources;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import kaique.luan.dev.domain.Cliente;
import kaique.luan.dev.useCase.Buscar;
import kaique.luan.dev.useCase.Cadastro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
        name = "Clientes",
        description = "Operações relacionadas aos clientes"
)
@RestController
@RequestMapping({"/clientes"})
public class ClienteResource {
    private final Buscar buscarCliente;
    private final Cadastro cadastroCliente;

    @Autowired
    public ClienteResource(Buscar buscarCliente, Cadastro cadastroCliente) {
        this.buscarCliente = buscarCliente;
        this.cadastroCliente = cadastroCliente;
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastar(@RequestBody @Valid Cliente cliente) {
        return ResponseEntity.ok(this.cadastroCliente.cadastrar(cliente));
    }

    @GetMapping({"isCadastrado/{id}"})
    public ResponseEntity<Boolean> isCadastrado(@PathVariable(value = "id",required = true) Long id) {
        return ResponseEntity.ok(this.buscarCliente.isCadastrado(id));
    }

    @PutMapping
    @Operation(
            summary = "PUT cliente"
    )
    public ResponseEntity<Cliente> atualizar(@RequestBody @Valid Cliente cliente) {
        return ResponseEntity.ok(this.cadastroCliente.atualizar(cliente));
    }

    @DeleteMapping({"/{id}"})
    @Operation(
            summary = "DELETE By ID"
    )
    public ResponseEntity<String> remover(@PathVariable("id") Long id) {
        this.cadastroCliente.remover(id);
        return ResponseEntity.ok("Removido com sucesso");
    }

    @GetMapping
    public ResponseEntity<Page<Cliente>> buscar(@PageableDefault(size = 10,page = 0,sort = {"id"}) Pageable pageable) {
        return ResponseEntity.ok(this.buscarCliente.buscar(pageable));
    }

    @GetMapping({"/{id}"})
    @Operation(
            summary = "GET By ID"
    )
    public ResponseEntity<Cliente> buscarPorId(@PathVariable(value = "id",required = true) Long id) {
        return ResponseEntity.ok(this.buscarCliente.buscarPorId(id));
    }

    @GetMapping({"/cpf/{cpf}"})
    @Operation(
            summary = "GET By CPF"
    )
    public ResponseEntity<Cliente> buscarPorCpf(@PathVariable(value = "cpf",required = true) String cpf) {
        return ResponseEntity.ok(this.buscarCliente.buscarPorCpf(cpf));
    }
}
