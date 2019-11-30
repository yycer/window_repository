package com.frankie.demo;

import com.frankie.demo.implems.Person;
import com.frankie.demo.interfaces.DataSource;
import com.frankie.demo.interfaces.Party;
import com.frankie.demo.utils.BeanUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * @author: Yao Frankie
 * @date: 2019/11/27 22:06
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class injectTest {

    @Autowired
    private BeanUtils beanUtils;


    /**
     * Ambiguous Beans.
     */
//    @Resource
//    private Party party;

//    @Autowired
//    private Party party;
//
//    @Inject
//    private Party party;

    /**
     * Field Name(four styles).
     */
//    @Resource
//    private Party person;
//
//    @Autowired
//    private Party person;
//
//    @Inject
//    private Party person;
//
//    @Resource(name = "person")
//    private Party party;

    /**
     * Filed Type
     */
//    @Resource
//    private Person party;
//    @Autowired
//    private Person party;
//    @Inject
//    private Person party;

    /**
     * Qualifier
     */

//    @Resource
//    @Qualifier(value = "personBean")
//    private Person frankie;
//
//    @Autowired
//    @Qualifier(value = "personBean")
//    private Person frankie;
//
//    @Inject
//    @Qualifier(value = "personBean")
//    private Person frankie;
//
//    @Resource(name = "personBean")
//    private Person frankie;
//


    @Test
    public void resourceTest(){
        beanUtils.printAllBeanNames();
//        dataSource.connect();
        party.printDefault();
    }

}
