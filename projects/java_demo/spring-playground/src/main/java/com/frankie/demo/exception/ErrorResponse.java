package com.frankie.demo.exception;

import io.swagger.annotations.ApiModel;
import lombok.Getter;

import java.io.Serializable;

/**
 * @author: Yao Frankie
 * @date: 2019/8/31 10:41
 */

@ApiModel
@Getter
public class ErrorResponse<T> implements Serializable {

    private static final long serialVersionUID = -2254339918462802230L;

    private final int errorCode;
    private final String errorMsg;
    private final T errorData;

    private ErrorResponse(ResultCode resultCode, T errorData) {
        this.errorCode = resultCode.getErrorCode();
        this.errorMsg  = resultCode.getErrorData();
        this.errorData = errorData;
    }

    public static <T> ErrorResponse<T> failed(ResultCode resultCode, T data){
        return new ErrorResponse(resultCode, data);
    }

}
