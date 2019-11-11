package com.frankie.demo.optional;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: Yao Frankie
 * @date: 2019/11/10 14:10
 */
@Setter
@Getter
public class Person {

    private String name;
    private String gender;
    private int    age;
    private Location location;

    public Person(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + '}';
    }

    public void greeting(Person person) {
        System.out.println("Hello " + person.getName() + "!");
    }

    public static void showIdentity(Person person) {
        System.out.println("Person: {" + "name='" + person.getName() + '\'' + ", gender='"
                + person.getGender() + '\'' + ", age=" + person.getAge() + '}');
    }
}
