package core.domain.model.courier_aggregate;

public enum CourierStatus {
    FREE("free"),
    BUSY("busy");

    private final String value;

    CourierStatus(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
