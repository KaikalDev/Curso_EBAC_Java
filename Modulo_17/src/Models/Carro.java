package Models;

public abstract class Carro {
    private String placa;
    private String marca;
    private String podencia;

    public Carro(String placa, String marca, String podencia) {
        this.placa = placa;
        this.marca = marca;
        this.podencia = podencia;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPodencia() {
        return podencia;
    }

    public void setPodencia(String podencia) {
        this.podencia = podencia;
    }
}
