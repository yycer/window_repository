package com.frankie.demo;

import com.frankie.demo.classloader.ClassLoaderSequence;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: Yao Frankie
 * @date: 2019/9/1 16:48
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ClassLoaderTest {

    /**
     * 类变量赋值与静态代码块赋值顺序
     */
    @Test
    public void staticExcSequenceTest(){
        System.out.println("id  = " + ClassLoaderSequence.id);  // 2
        System.out.println("age = " + ClassLoaderSequence.age); // 20
    }
}
