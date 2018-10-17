package com.max.correlation;

public final class UserContext {

    static final String CORRELATION_ID_HEADER = "correlation-id";

    private final String correlationId;

    UserContext(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getCorrelationId() {
        return correlationId;
    }

}
