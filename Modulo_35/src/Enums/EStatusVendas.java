package Enums;

public enum EStatusVendas {
    INICIADA, CONCLUIDA, CANCELADA;

    public static EStatusVendas getByName(String value) {
        for (EStatusVendas status : EStatusVendas.values()) {
            if (status.name().equals(value)) {
                return status;
            }
        }
        return null;
    }
}
