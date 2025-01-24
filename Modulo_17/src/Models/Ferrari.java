package Models;

import Models.modelos.EModelosFerrari;

public class Ferrari extends Carro{
    private EModelosFerrari Modelo;

    public Ferrari(String placa, String marca, String podencia, EModelosFerrari modelo) {
        super(placa, marca, podencia);
        Modelo = modelo;
    }

    public EModelosFerrari getModelo() {
        return Modelo;
    }

    public void setModelo(EModelosFerrari modelo) {
        Modelo = modelo;
    }
}
