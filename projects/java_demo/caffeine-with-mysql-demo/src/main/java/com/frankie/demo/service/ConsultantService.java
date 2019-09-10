package com.frankie.demo.service;

import com.frankie.demo.domain.Consultant;
import com.frankie.demo.repository.mysql.contacts.ContactsMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author: Yao Frankie
 * @date: 2019/9/10 16:45
 */
@Service
@Slf4j
public class ConsultantService {

    @Autowired
    private ContactsMapper contactsMapper;

    @Cacheable(value = "consultants")
    public Consultant getConsultant(long contactId){
        log.warn("Get data from mysql by contactId = " + contactId);
        Consultant consultant = contactsMapper.getConsultantById(contactId);
        return consultant;
    }
}
