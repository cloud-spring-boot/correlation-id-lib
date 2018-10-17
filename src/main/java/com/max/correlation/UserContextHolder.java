package com.max.correlation;

import org.slf4j.MDC;

import static com.google.common.base.Preconditions.checkArgument;

public final class UserContextHolder {

    private static final ThreadLocal<UserContext> CONTEXT_HOLDER = new ThreadLocal<>();

    private UserContextHolder() {
    }

    public static void setUserContext(UserContext userContext) {
        checkArgument(userContext != null, "null 'userContext' passed");
        CONTEXT_HOLDER.set(userContext);
        MDC.put("correlation-id", userContext.getCorrelationId());
    }

    public static UserContext getUserContext() {
        if (CONTEXT_HOLDER.get() == null) {
            CONTEXT_HOLDER.set(new UserContext("<undefined>"));
            MDC.put("correlation-id", "<undefined>");
        }

        return CONTEXT_HOLDER.get();
    }

    public static void clear() {
        CONTEXT_HOLDER.remove();
        MDC.clear();
    }

}
