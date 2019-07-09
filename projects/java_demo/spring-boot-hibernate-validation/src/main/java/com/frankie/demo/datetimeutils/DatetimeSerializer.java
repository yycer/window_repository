package com.frankie.demo.datetimeutils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DatetimeSerializer extends JsonSerializer<LocalDateTime> {


    @Override
    public void serialize(LocalDateTime value,
                          JsonGenerator gen,
                          SerializerProvider serializers) throws IOException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        gen.writeString(value.format(formatter));
    }
}
