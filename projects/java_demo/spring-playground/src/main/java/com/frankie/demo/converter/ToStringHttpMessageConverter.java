package com.frankie.demo.converter;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author: Yao Frankie
 * @date: 2019/8/31 18:24
 */
public class ToStringHttpMessageConverter extends AbstractHttpMessageConverter<Object> {

    public ToStringHttpMessageConverter(){
        super(StandardCharsets.UTF_8, new MediaType("application", "toString"));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage)
            throws IOException, HttpMessageNotReadableException {
        return StreamUtils.copyToString(inputMessage.getBody(), StandardCharsets.UTF_8);
    }

    @Override
    protected void writeInternal(Object o, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
        outputMessage.getBody().write(o.toString().getBytes());
    }
}
