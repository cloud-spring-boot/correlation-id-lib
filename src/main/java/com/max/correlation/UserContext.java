package com.max.correlation;

public final class UserContext {


    static final String AUTHIORIZATION_HEADER = "Authorization";

    private final String authToken;

    UserContext(String authToken) {
        this.authToken = authToken;
    }

    public String getAuthToken() {
        return authToken;
    }

}
