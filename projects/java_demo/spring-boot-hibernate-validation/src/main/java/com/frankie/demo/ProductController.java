package com.frankie.demo;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ProductController {

    @GetMapping("products/{sku}")
    String getProductName(@PathVariable String sku){
        return "舒颜保湿";
    }

    @PostMapping("/products")
    String postProductInfo(@Valid @RequestBody Product product){
        return "success";
    }
}
