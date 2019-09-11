package com.frankie.demo.annotation;

import java.lang.annotation.*;

/**
 * @author: Yao Frankie
 * @date: 2019/9/11 15:10
 */
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface CostTime {

}
