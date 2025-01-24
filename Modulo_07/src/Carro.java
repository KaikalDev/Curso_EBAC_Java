/**
 * @author Kaique
 *
 * @since origem
 *
 * @version 1.1
 *
 */

public class Carro {
    private String marca;
    private String modelo;
    private String cor;
    private String placa;
    private boolean ligado = false;
    private boolean acelerando = false;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public boolean isAcelerando() {
        return acelerando;
    }

    public void setAcelerando(boolean acelerando) {
        this.acelerando = acelerando;
    }

    public void acelerar() {
        if (this.isLigado()) {
            this.setAcelerando(true);
            System.out.println("Acelerando");
        } else {
            System.out.println("Carro desligado");
        }
    }

    public void frear() {
        if (this.isAcelerando()) {
            this.setAcelerando(false);
            System.out.println("Freando");
        } else {
            System.out.println("Carro parado");
        }
    }
}
