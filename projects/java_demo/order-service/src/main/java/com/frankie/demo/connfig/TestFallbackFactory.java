package com.frankie.demo.connfig;

import com.frankie.demo.repository.ProductRepository;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author: Yao Frankie
 * @date: 2019/9/18 17:58
 */
@Component
public class TestFallbackFactory implements FallbackFactory<ProductRepository> {

    @Override
    public ProductRepository create(Throwable cause) {

        return null;
    }
}
