package com.frankie.demo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author: Yao Frankie
 * @date: 2019/8/31 10:39
 */
@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ErrorResponse> handleServiceException(ServiceException ex){
        return ResponseEntity
                .status(ex.getStatus())
                .body(ErrorResponse.failed(ex.getResultCode(), ex.getErrorData()));
    }
}
