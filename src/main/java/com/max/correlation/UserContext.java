package com.max.correlation;

public final class UserContext {

    static final String CORRELATION_ID_HEADER = "correlation-id";

    static final String AUTHIORIZATION_HEADER = "Authorization";

    private final String correlationId;

    private final String authToken;

    UserContext(String correlationId, String authToken) {
        this.correlationId = correlationId;
        this.authToken = authToken;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public String getAuthToken() {
        return authToken;
    }

}
