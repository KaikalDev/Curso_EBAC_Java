package AbstractFactory;

public class Motorcycle {
    private String Rodas;
    private String Motor;
    private String Freio;

    public Motorcycle(String rodas, String motor, String freio) {
        Rodas = rodas;
        Motor = motor;
        Freio = freio;
    }

    public String getRodas() {
        return Rodas;
    }

    public void setRodas(String rodas) {
        Rodas = rodas;
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
}
