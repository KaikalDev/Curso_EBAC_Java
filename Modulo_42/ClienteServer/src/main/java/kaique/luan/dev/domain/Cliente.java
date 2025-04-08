package kaique.luan.dev.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "TB_CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
    @SequenceGenerator(name = "cliente_seq", sequenceName = "SQ_CLIENTE", allocationSize = 1)
    private Long id;

    @Column(name = "NOME", nullable = false, length = 60)
    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @Column(name = "CPF", nullable = false, unique = true, length = 14)
    @NotBlank(message = "O CPF é obrigatório")
    private String cpf;
}
