package com.first.spring.boot.app;

import com.first.spring.boot.app.exceptionhandler.ConstraintViolationExceptionMapper;
import com.first.spring.boot.app.logger.CustomLogger;
import com.first.spring.boot.app.exceptionhandler.ExceptionHandler;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.springframework.stereotype.Component;
import com.first.spring.boot.app.resource.UserResource;

@Component
public class JerseyConfig extends ResourceConfig
{
    public JerseyConfig()
    {
        register(UserResource.class);
        register(ConstraintViolationExceptionMapper.class);
        register(ExceptionHandler.class);
        register(CustomLogger.class);
        packages("com.first.spring.boot.app");
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
    }
}
