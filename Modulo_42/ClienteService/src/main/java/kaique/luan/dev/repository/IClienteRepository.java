/**
 * 
 */
package kaique.luan.dev.repository;

import java.util.Optional;

import kaique.luan.dev.domain.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author rodrigo.pires
 *
 */
@Repository
public interface IClienteRepository extends MongoRepository<Cliente, String>{

	Optional<Cliente> findByCpf(Long cpf);
}
