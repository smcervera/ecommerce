package com.capitole.ecommerce.entrypoints.errorhandlers;

import com.capitole.ecommerce.core.exceptions.PriceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handlerNotFound(PriceNotFoundException ex, WebRequest request) {

        logger.debug("[PriceNotFoundException] ", ex);

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Price not found " + ex);

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
