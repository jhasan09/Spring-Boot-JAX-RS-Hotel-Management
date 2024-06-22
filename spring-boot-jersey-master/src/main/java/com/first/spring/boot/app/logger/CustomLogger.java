package com.first.spring.boot.app.logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomLogger {
    private static final Logger logger = LoggerFactory.getLogger(CustomLogger.class);

    public void logRequest(String method, String path) {
        logger.info("Received {} request for path: {}", method, path);
    }

    public void logResponse(String method, String path, int statusCode) {
        logger.info("Responded with {} for {} request to path: {}", statusCode, method, path);
    }

    public void logError(String message) {
        logger.error("Error occurred: {} ", message);
    }
}
