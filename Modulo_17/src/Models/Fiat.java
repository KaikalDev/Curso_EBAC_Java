package Models;

import Models.modelos.EModelosFiat;

public class Fiat extends Carro {
    private EModelosFiat Modelo;

    public Fiat(String placa, String marca, String podencia, EModelosFiat modelo) {
        super(placa, marca, podencia);
        Modelo = modelo;
    }

    public EModelosFiat getModelo() {
        return Modelo;
    }

    public void setModelo(EModelosFiat modelo) {
        Modelo = modelo;
    }
}
