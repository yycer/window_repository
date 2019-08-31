package com.frankie.demo.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author: Yao Frankie
 * @date: 2019/8/31 10:15
 */
@Getter
public class ServiceException extends RuntimeException {

    private HttpStatus status;
    private ResultCode resultCode;
    private Object     customMsg;

    private ServiceException(HttpStatus status, ResultCode resultCode, Object customMsg){
        this.status     = status;
        this.resultCode = resultCode;
        this.customMsg = customMsg;
    }

    public static ServiceException badRequest(ResultCode resultCode, Object data){
        return new ServiceException(HttpStatus.BAD_REQUEST, resultCode, data);
    }

}
