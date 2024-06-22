package com.first.spring.boot.app.exceptionhandler;

import com.first.spring.boot.app.logger.CustomLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

@Service
public class ExceptionHandler implements ExceptionMapper<Exception> {
    @Autowired
    private CustomLogger customLogger;
    @Override
    public Response toResponse(Exception exception) {
        String errorMessage =  exception.getMessage();
        customLogger.logError(errorMessage);

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(errorMessage)
                .build();
    }
}