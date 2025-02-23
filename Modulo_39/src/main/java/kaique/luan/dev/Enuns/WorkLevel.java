package kaique.luan.dev.Enuns;

public enum WorkLevel {
    URGENTE, IMPORTANTE, NORMAL;

    public static WorkLevel getByName(String value) {
        for (WorkLevel status : WorkLevel.values()) {
            if (status.name().equals(value)) {
                return status;
            }
        }
        return null;
    }
}
