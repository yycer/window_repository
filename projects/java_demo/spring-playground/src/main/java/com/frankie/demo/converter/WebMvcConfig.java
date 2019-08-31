package com.frankie.demo.converter;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author: Yao Frankie
 * @date: 2019/8/31 18:27
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
        converters.add(new ToStringHttpMessageConverter());
    }
}
