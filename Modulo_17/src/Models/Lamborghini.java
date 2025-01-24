package Models;

import Models.modelos.EModelosLamborghini;

public class Lamborghini extends Carro {
    private EModelosLamborghini Modelo;

    public Lamborghini(String placa, String marca, String podencia, EModelosLamborghini modelo) {
        super(placa, marca, podencia);
        Modelo = modelo;
    }

    public EModelosLamborghini getModelo() {
        return Modelo;
    }

    public void setModelo(EModelosLamborghini modelo) {
        Modelo = modelo;
    }
}
