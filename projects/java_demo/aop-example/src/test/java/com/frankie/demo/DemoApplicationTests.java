package com.frankie.demo;

import com.frankie.demo.business.Business1;
import com.frankie.demo.business.Business2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Business1 business1;

    @Autowired
    private Business2 business2;

    @Test
    public void invokeAopStuff() {
        logger.info(business1.calculateSomething());
        logger.info(business2.calculateSomething());
    }

}
