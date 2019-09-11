package com.frankie.demo.service;

import com.frankie.demo.annotation.CostTime;
import com.frankie.demo.exception.ResultCode;
import com.frankie.demo.exception.ServiceException;
import org.springframework.stereotype.Service;

/**
 * @author: Yao Frankie
 * @date: 2019/9/11 15:22
 */
@Service
public class AnnotationService {

    @CostTime
    public void costLongTime(){
        try {
            Thread.sleep(1000);
        } catch (Exception e){
            throw ServiceException.badRequest(
                    ResultCode.INVALID_PARAMETER, "Failed to execute Thread.sleep!");
        }
    }
}
