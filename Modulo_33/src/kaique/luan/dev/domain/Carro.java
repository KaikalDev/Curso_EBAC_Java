package kaique.luan.dev.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_CARRO")
public class Carro {

    @Id
    @GeneratedValue(generator = "carro_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "carro_seq", sequenceName = "SQ_CARRO", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "modelo", nullable = false, unique = true, length = 10)
    private String modelo;

    @Column(name = "preco", nullable = false)
    private Double preco;

    @Column(name = "KiloMetragem", nullable = false)
    private Long KiloMetragem;

    @ManyToOne
    @JoinColumn(
            name = "fk_id_marca", // Nome da coluna no banco de dados para a chave estrangeira.
            foreignKey = @ForeignKey(name = "fk_marca_carro"), // Nome da constraint no banco de dados.
            referencedColumnName = "id", // Coluna referenciada na tabela Marca.
            nullable = false // Define que essa relação é obrigatória.
    )
    private Marca marca;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "TB_CARRO_TO_ACESSORIO", // Nome da tabela intermediária.
            joinColumns = { @JoinColumn(name = "fk_id_carro") }, // Coluna que referencia Carro.
            inverseJoinColumns = { @JoinColumn(name = "fk_id_acessorio") } // Coluna que referencia Acessorio.
    )
    private List<Acessorio> acessorio;

    public Carro() {
        this.acessorio = new ArrayList<Acessorio>();
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

    public Long getKiloMetragem() {
        return KiloMetragem;
    }

    public void setKiloMetragem(Long kiloMetragem) {
        KiloMetragem = kiloMetragem;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Acessorio> getAcessorios() {
        return acessorio;
    }

    public void setAcessorios(List<Acessorio> acessorio) {
        this.acessorio = acessorio;
    }

    public void add(Acessorio acess) {
        this.acessorio.add(acess);
        acess.getCarrosCompativeis().add(this);
    }
}
