package kaique.luan.dev.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_MARCA")
public class Marca {

    @Id
    @GeneratedValue(generator = "marca_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "marca_seq", sequenceName = "SQ_MARCA", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "nome", nullable = false, unique = true, length = 50)
    private String nome;

    @OneToMany(mappedBy = "marca")
    private List<Carro> carros;

    public Marca() {
        this.carros = new ArrayList<Carro>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

    public void addCarro(Carro carro) {
        this.carros.add(carro);
        carro.setMarca(this);
    }
}
