package com.frankie.demo.controller;

import com.frankie.demo.service.AnnotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Yao Frankie
 * @date: 2019/9/11 15:22
 */
@RestController
public class TestController {

    @Autowired
    AnnotationService annotationService;

    @GetMapping("/v1/anno")
    public void costTimeTest(){
        annotationService.costLongTime();
    }
}
