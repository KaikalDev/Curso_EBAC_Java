package kaique.luan.dev.useCase;

import jakarta.validation.Valid;
import kaique.luan.dev.domain.Cliente;
import kaique.luan.dev.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class Cadastro {
    private final IClienteRepository clienteRepository;

    @Autowired
    public Cadastro(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente cadastrar(@Valid Cliente cliente) {
        return (Cliente)this.clienteRepository.save(cliente);
    }

    public Cliente atualizar(@Valid Cliente cliente) {
        return (Cliente)this.clienteRepository.save(cliente);
    }

    public void remover(Long id) {
        this.clienteRepository.deleteById(id);
    }
}
