package kaique.luan.dev.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_ACESSORIO")
public class Acessorio {

    @Id
    @GeneratedValue(generator = "acessorio_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "acessorio_seq", sequenceName = "SQ_ACESSORIO", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "modelo", nullable = false, length = 10, unique = true)
    private String modelo;

    @Column(name = "preco", nullable = false)
    private Double preco;

    @ManyToMany(mappedBy = "acessorio")
    private List<Carro> carrosCompativeis;

    public Acessorio() {
        this.carrosCompativeis = new ArrayList<Carro>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<Carro> getCarrosCompativeis() {
        return carrosCompativeis;
    }

    public void setCarrosCompativeis(List<Carro> carrosCompativeis) {
        this.carrosCompativeis = carrosCompativeis;
    }

    public void addCarro(Carro carro) {
        this.carrosCompativeis.add(carro);
    }
}
