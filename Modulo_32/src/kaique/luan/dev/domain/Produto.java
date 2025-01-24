package kaique.luan.dev.domain;

import jakarta.persistence.*;
import kaique.luan.dev.Enums.ETypeProduto;
import org.checkerframework.common.value.qual.EnumVal;

import javax.annotation.processing.Generated;

@Entity
@Table(name = "TB_PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(generator = "produto_seq",  strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "produto_seq", sequenceName = "SQ_PRODUTO", initialValue = 1, allocationSize = 1)
    private Long ID;

    @Column(name = "CODIGO",length = 10 ,nullable = false, unique = true)
    private String codigo;

    @Column(name = "NOME", nullable = false, length = 50)
    private String nome;

    @Column(name = "TIPO", nullable = false)
    @Enumerated(EnumType.STRING)
    private ETypeProduto tipo;

    @Column(name = "VALOR", nullable = false)
    private Double valor;

    @Column(name = "QTD_ESTOQUE")
    private Integer qtdEstoque;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ETypeProduto getTipo() {
        return tipo;
    }

    public void setTipo(ETypeProduto tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
}
