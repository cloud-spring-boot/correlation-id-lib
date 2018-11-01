package com.max.correlation;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Add Correlation-Id and Authorization headers to all outbound HTTP calls.
 */
@Component
public class UserContextInterceptor implements RequestInterceptor {

    private static final Logger LOG = LoggerFactory.getLogger(UserContextInterceptor.class);

    @Override
    public void apply(RequestTemplate requestTemplate) {

        if (LOG.isDebugEnabled()) {
            LOG.debug("Intercepting {} with correlation-id: {} and token: {}",
                    requestTemplate.url(),
                    UserContextHolder.getUserContext().getAuthToken()
            );
        }

        requestTemplate.
                header(UserContext.AUTHIORIZATION_HEADER, UserContextHolder.getUserContext().getAuthToken());

    }

}
