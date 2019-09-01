package com.frankie.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(DemoApplication.class, args);

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统类加载器: " + systemClassLoader);
        System.out.println();

        Enumeration<URL> resources = systemClassLoader.getResources("");
        while (resources.hasMoreElements()){
            System.out.println(resources.nextElement());
        }

        ClassLoader extensionClassLoader = systemClassLoader.getParent();
        System.out.println("扩展类加载器: " + extensionClassLoader);
    }

}
