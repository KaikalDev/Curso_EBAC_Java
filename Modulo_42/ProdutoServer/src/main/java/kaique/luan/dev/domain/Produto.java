package kaique.luan.dev.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq")
    @SequenceGenerator(name = "produto_seq", sequenceName = "SQ_PRODUTO", allocationSize = 1)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 50)
    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @Column(name = "VALOR", nullable = false, unique = true)
    @NotNull(message = "O valor é obrigatório")
    @Positive(message = "O valor deve ser maior que zero")
    private Double valor;
}
