package core.domain.model.order_aggregate;


public enum OrderStatus {
    CREATED("created"),
    ASSIGNED("assigned"),
    COMPLETED("completed");

    private final String value;

    OrderStatus(String value) {
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

