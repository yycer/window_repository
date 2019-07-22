package com.frankie.demo;

import com.github.benmanes.caffeine.cache.Cache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void cacheTest() {
        Inventory inventory = new Inventory();
        inventory.getAvailableQuantities("10", "5");
        inventory.getAvailableQuantities("20", "3");
        inventory.getAvailableQuantities("10", "2");
        Cache<String, HashMap<String, List<String>>> parentGroupCache = inventory.parentGroupCache;
    }

}
