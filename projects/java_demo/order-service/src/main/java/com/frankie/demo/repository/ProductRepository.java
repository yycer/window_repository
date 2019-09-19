package com.frankie.demo.repository;

import com.frankie.demo.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: Yao Frankie
 * @date: 2019/9/18 10:34
 */
@FeignClient(value = "product-svc", url = "http://localhost:8080")
public interface ProductRepository {


    @GetMapping("/v1/product/{sku}")
    Product getProduct(@PathVariable String sku);
}
