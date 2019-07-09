package com.frankie.demo;

import com.frankie.demo.dto.AddressDto;
import com.frankie.demo.dto.OrderDto;
import com.frankie.demo.dto.PersonDto;
import com.frankie.demo.dto.ProductDto;
import com.frankie.demo.model.Order;
import com.frankie.demo.model.Person;
import com.frankie.demo.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.ModelMap;

import javax.print.attribute.standard.Destination;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyPermission;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Test
    public void model2Dto(){
        List products = new ArrayList<Product>();
        Product product1 = new Product();
        product1.setName("滋润霜");
        product1.setPrice("25.30");

        Product product2 = new Product();
        product2.setName("护手霜");
        product2.setPrice("13.20");

        products.add(product1);
        products.add(product2);

        Order order = new Order();
        order.setProductInfo(products);
        order.setBasketOrderId(UUID.randomUUID().toString());
        order.setCreatedDate(LocalDateTime.now());

        ModelMapper modelMapper = new ModelMapper();
        OrderDto orderDto = modelMapper.map(order, OrderDto.class);

        System.out.println(2);
    }


    @Test
    public void typeMapTest(){
        PersonDto personDto = new PersonDto();
        personDto.setName("frankie");
        personDto.setAge(23);

        // Create your mapper
        ModelMapper modelMapper = new ModelMapper();

        // Create a TypeMap for your mapping
        TypeMap<PersonDto, Person> typeMap =
                modelMapper.createTypeMap(PersonDto.class, Person.class);

        // Define the mappings on the type map
        typeMap.addMappings(mapper -> {
            mapper.map(src -> src.getName(),
                    Person::setPersonName);
            mapper.map(src -> src.getAge(),
                    Person::setPersonAge);
        });

        Person person = modelMapper.map(personDto, Person.class);

    }

    @Test
    public void configTest(){

        PersonDto personDto = new PersonDto();
        personDto.setName("frankie");
        personDto.setAge(23);
        AddressDto addressDto = new AddressDto();
        addressDto.setDetailAddress("Marykay");
        addressDto.setRecipient("Mary");

        ModelMapper modelMapper = new ModelMapper();
//        modelMapper.addMappings(new PropertyMap<PersonDto, Person>() {
//            @Override
//            protected void configure() {
//                map().setPersonName(source.getName());
//                map().setPersonAge(source.getAge());
//                map().;
//            }
//        });

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Person person = modelMapper.map(personDto, Person.class);
        System.out.println(2);

    }



}
