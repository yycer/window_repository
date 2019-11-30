package com.frankie.demo.implems;

import com.frankie.demo.interfaces.Party;
import org.springframework.stereotype.Component;

/**
 * @author: Yao Frankie
 * @date: 2019/11/30 15:39
 */
@Component
public class Organization implements Party {
    @Override
    public void printDefault() {
        System.out.println("Hi Organization.");
    }
}
