package com.frankie.demo;/*
 @author: Administrator
 @date: 2019/7/22-21:12
*/

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Inventory {

    public Cache<String, HashMap<String, List<String>>> parentGroupCache = Caffeine.newBuilder()
            .expireAfterWrite(5, TimeUnit.MINUTES)
            .maximumSize(100)
            .build();


    public HashMap<String, List<String>> getAvailableQuantities(String parentSku, String childSku){

        String key = "parentGroupCache";
        HashMap<String, List<String>> parentGroup = parentGroupCache.getIfPresent(key);
        List<String> childSkus = new LinkedList<>();
        childSkus.add(childSku);
        childSkus.add(parentSku);

        if (parentGroup != null){
            if (!parentGroup.containsKey(parentSku)){
                parentGroup.put(parentSku, childSkus);
            }

            else if (!parentGroup.get(parentSku).contains(childSku)){
                parentGroup.get(parentSku).add(childSku);
            }
            return parentGroup;
        } else{
            HashMap<String, List<String>> map = new HashMap<>(10);
            map.put(parentSku, childSkus);
            parentGroupCache.put(key, map);
            return map;
        }
    }
}
