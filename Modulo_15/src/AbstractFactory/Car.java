package AbstractFactory;

public class Car {
    private String Rodas;
    private String Protas;
    private String Motor;
    private String Freio;
    private String Cambio;

    public Car(String rodas, String protas, String motor, String freio, String cambio) {
        Rodas = rodas;
        Protas = protas;
        Motor = motor;
        Freio = freio;
        Cambio = cambio;
    }

    public String getRodas() {
        return Rodas;
    }

    public void setRodas(String rodas) {
        Rodas = rodas;
    }

    public String getProtas() {
        return Protas;
    }

    public void setProtas(String protas) {
        Protas = protas;
    }

    public String getMotor() {
        return Motor;
    }

    public void setMotor(String motor) {
        Motor = motor;
    }

    public String getFreio() {
        return Freio;
    }

    public void setFreio(String freio) {
        Freio = freio;
    }

    public String getCambio() {
        return Cambio;
    }

    public void setCambio(String cambio) {
        Cambio = cambio;
    }
}
