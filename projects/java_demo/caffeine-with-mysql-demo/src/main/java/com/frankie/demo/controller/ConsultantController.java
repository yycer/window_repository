package com.frankie.demo.controller;

import com.frankie.demo.domain.Consultant;
import com.frankie.demo.service.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Yao Frankie
 * @date: 2019/9/10 16:44
 */
@RestController
public class ConsultantController {

    @Autowired
    private ConsultantService consultantService;

    @GetMapping("v1/consultants/{contact_id}")
    public Consultant getConsultant(@PathVariable("contact_id") long contactId){
        Consultant consultant = consultantService.getConsultant(contactId);
        return consultant;
    }
}
