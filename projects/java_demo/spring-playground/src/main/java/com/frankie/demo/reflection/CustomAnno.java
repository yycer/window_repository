package com.frankie.demo.reflection;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author: Yao Frankie
 * @date: 2019/9/2 20:42
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface CustomAnno {
}
