package com.frankie.demo.exception;

import lombok.Getter;

/**
 * @author: Yao Frankie
 * @date: 2019/8/31 10:16
 */
@Getter
public enum ResultCode {
    // errorCode
    SUCCESS(0, "SUCCESS"),
    INVALID_PARAMETER(600, "invalid parameter");

    private final int errorCode;
    private final String errorData;

    ResultCode(int errorCode, String errorData){
        this.errorCode = errorCode;
        this.errorData = errorData;
    }

}
