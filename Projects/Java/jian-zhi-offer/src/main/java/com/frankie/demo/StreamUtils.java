package com.frankie.demo;

import com.frankie.demo.model.Order;
import com.frankie.demo.model.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUtils {

    public List<Product> initData(){

        List<Product> products = new ArrayList<>();
        products.add(new Product("舒颜", "200", LocalDateTime.now().plusDays(1)));
        products.add(new Product("幻时", "500", LocalDateTime.now().plusDays(2)));
        products.add(new Product("5X", "300", LocalDateTime.now().plusDays(3)));

        return products;
    }

    public void convertInTwoListWay1(){
        List<Product> products = initData();
        ArrayList<Order> orders = new ArrayList<>();

        for (Product p: products){
            orders.add(new Order(p.getName(), p.getRetailPrice()));
        }
    }

    public void convertInTwoListWay2(){
        List<Product> products = initData();
        List<Order> orders = products.stream()
                .sorted(Comparator.comparing(Product::getStartDate).reversed())
                .map(p -> new Order(p.getName(), p.getRetailPrice()))
                .collect(Collectors.toList());
        System.out.println(2);
    }
}
