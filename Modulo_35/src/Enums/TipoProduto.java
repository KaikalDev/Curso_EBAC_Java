package Enums;

public enum TipoProduto {
    doces,
    carne,
    grãos,
    lacticínios;

    public static TipoProduto getByName(String value) {
        for (TipoProduto status : TipoProduto.values()) {
            if (status.name().equals(value)) {
                return status;
            }
        }
        return null;
    }
}
