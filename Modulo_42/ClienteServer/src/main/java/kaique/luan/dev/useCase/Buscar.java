package kaique.luan.dev.useCase;

import java.util.Optional;
import kaique.luan.dev.domain.Cliente;
import kaique.luan.dev.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class Buscar {
    private final IClienteRepository clienteRepository;

    @Autowired
    public Buscar(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Boolean isCadastrado(Long id) {
        Optional<Cliente> cliente = this.clienteRepository.findById(id);
        return cliente.isPresent();
    }

    public Page<Cliente> buscar(Pageable pageable) {
        return this.clienteRepository.findAll(pageable);
    }

    public Cliente buscarPorId(Long id) {
        return (Cliente)this.clienteRepository.findById(id).orElseThrow();
    }

    public Cliente buscarPorCpf(String cpf) {
        return (Cliente)this.clienteRepository.findByCpf(cpf).orElseThrow();
    }
}
