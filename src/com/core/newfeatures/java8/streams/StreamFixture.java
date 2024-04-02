package com.core.newfeatures.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamFixture {


    public static List<String> hobbies() {
        List<String> hobbies = new ArrayList<>();
        hobbies.add("tennis");
        hobbies.add("sleeping");
        hobbies.add("cricket");
        return hobbies;
    }

    public static List<Integer> numbers() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 99000000; i++) {
            numbers.add(i);
        }
        return numbers;
    }


    public static List<String> stringItems(){
        return Arrays.asList("apple","banana","strawberry","apple","apple","banana","guava");
    }


    public static List<Item> itemItems(){
        return Arrays.asList(
                new Item("apple", 10, 9.99),
                new Item("banana", 20, 19.99),
                new Item("orang", 10, 29.99),
                new Item("watermelon", 10, 29.99),
                new Item("papaya", 20, 9.99),
                new Item("apple", 10, 9.99),
                new Item("banana", 10, 19.99),
                new Item("apple", 20, 9.99));
    }

    public static List<Employee> employees(){
        return Arrays.asList(
                new Employee("ankur",30,10000.99f,Location.INDIA,Designation.DEVELOPER),
                new Employee("ankur",40,45000.99f,Location.CANADA,Designation.DEVELOPER),
                new Employee("ravi",50,60000.99f,Location.US,Designation.PRODUCT_OWNER),
                new Employee("ravi",60,60000.99f,Location.US,Designation.DELIVERY_MANAGER),
                new Employee("ravi",70,50000.99f,Location.INDIA,Designation.DEVELOPER),
                new Employee("donald",30,10000.99f,Location.CANADA,Designation.QA),
                new Employee("obama",70,30000.99f,Location.CANADA,Designation.QA),
                new Employee("pamela",60,30000.99f,Location.US,Designation.DEVELOPER),
                new Employee("donald",90,20000.99f,Location.US,Designation.DEVELOPER)
        );
    }

}
