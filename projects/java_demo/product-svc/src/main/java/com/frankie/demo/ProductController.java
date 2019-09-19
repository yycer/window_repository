package com.frankie.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Yao Frankie
 * @date: 2019/9/18 10:20
 */
@RestController()
public class ProductController {

    @GetMapping("/v1/product/{sku}")
    public Product getProduct(@PathVariable String sku) throws InterruptedException {
        Product product = new Product();
        product.setName("幻时");
        product.setSku(sku);
        Thread.sleep(500);

        return product;
    }
}
