package com.first.spring.boot.app.exceptionhandler;

import com.first.spring.boot.app.logger.CustomLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@Service
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
    @Autowired
    private CustomLogger customLogger;
    @Override
    public Response toResponse(ConstraintViolationException ex) {
        String errorMessage = ex.getConstraintViolations().stream().findFirst().orElse(null).getMessageTemplate();

        customLogger.logError(ex.getMessage());

        return Response.status(Response.Status.BAD_REQUEST)
                .entity(errorMessage)
                .build();
    }
}


