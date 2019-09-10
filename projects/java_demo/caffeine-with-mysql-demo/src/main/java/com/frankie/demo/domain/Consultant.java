package com.frankie.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: Yao Frankie
 * @date: 2019/9/10 15:25
 */
@Setter
@Getter
public class Consultant {
    @JsonProperty("contact_id")
    private long contactId;
    private String name;
}
