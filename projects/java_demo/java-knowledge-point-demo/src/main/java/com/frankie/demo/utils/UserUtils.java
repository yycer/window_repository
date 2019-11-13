package com.frankie.demo.utils;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author: Yao Frankie
 * @date: 2019/11/13 10:26
 */
@Service
public class UserUtils {

    public String getUserId(String userId){
        if (userId == null || userId.length() == 0){
            throw new RuntimeException("Failed to get userId.");
        }
        return userId;
    }

    public String getUserIdUsingOptional(String userId){
        return Optional.ofNullable(userId)
                .filter(x -> !x.isEmpty())
                .orElseThrow(() -> new RuntimeException("Failed to get userId."));
    }
}
