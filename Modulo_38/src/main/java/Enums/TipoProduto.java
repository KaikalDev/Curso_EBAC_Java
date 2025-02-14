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
    
    @Override
    public String toString() {
        return this.name().substring(0, 1).toUpperCase() + this.name().substring(1).toLowerCase();
    }
}
