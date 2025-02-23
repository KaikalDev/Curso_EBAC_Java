package kaique.luan.dev.Enuns;

public enum WorkStatus {
    PENDENTE, CONCLUIDA;

    public static WorkStatus getByName(String value) {
        for (WorkStatus status : WorkStatus.values()) {
            if (status.name().equals(value)) {
                return status;
            }
        }
        return null;
    }
}
