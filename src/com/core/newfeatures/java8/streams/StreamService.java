package com.core.newfeatures.java8.streams;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamService {


    public List<String> withJava8Map(List<String> hobbies) {
        return hobbies.stream().map(hobby -> hobby.toUpperCase()).collect(Collectors.toList());
    }

    public List<String> withJava8FlatMap(List<String> hobbies) {
        return hobbies.stream().flatMap(hobby -> Stream.of(hobby.toUpperCase(), hobby.toLowerCase(), hobby.concat("ankur "))).collect(Collectors.toList());
    }

    public List<Integer> withJava8SequentialStream(List<Integer> numbers) {
        Predicate<Integer> even = (n -> n % 2 == 0);
        return numbers.stream().filter(even).collect(Collectors.toList());
    }

    public List<Integer> withJava8ParallelStream(List<Integer> numbers) {
        Predicate<Integer> even = (n -> n % 2 == 0);
        return numbers.parallelStream().filter(even).collect(Collectors.toList());
    }


    public Map<String, List<String>> withJava8_groupingBy_groupedStringValues() {
        List<String> items = StreamFixture.stringItems();
        Map<String, List<String>> map = items.stream().collect(Collectors.groupingBy(Function.identity()));
        return map;
    }

    public Map<String, Long> withJava8_groupingBy_StringValues_count() {
        List<String> items = StreamFixture.stringItems();
        Map<String, Long> count = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return count;
    }

    public void print(Map map) {
        map.forEach((key, value) -> System.out.println("key = " + key + " value = " + value));
    }


    public Map<String, Double> withJava8_groupingBy_itemPrice() {
        List<Item> items = StreamFixture.itemItems();
        return items.stream().collect(Collectors.groupingBy(Item::getName, Collectors.summingDouble(Item::getPrice)));
    }

    /**
     * Item names and their respective counts
     */
    public Map<String, Long> withJava8_groupingBy_ItemName() {
        List<Item> items = StreamFixture.itemItems();
        Map<String, Long> map = items.stream().collect(Collectors.groupingBy(Item::getName, Collectors.counting()));
        return map;
    }

    /**
     * Map<String, List<Book>> = find books where quantity == 10 && price less than $10, groupBy itemName
     */
    public Map<String, List<Item>> withJava8_groupingBy_multipleFactors() {
        List<Item> items = StreamFixture.itemItems();
        return items.stream().filter(item -> quantityEqualsTen(item))
                .filter(item -> priceLessThanTen(item))
                .collect(Collectors.groupingBy(Item::getName));
    }


    /**
     * Same criteria as 'withJava8_multipleCriteria_list()'
     * withJava8_multipleCriteria_map() - This method returns a Map<String,List<Employee>>
     * withJava8_multipleCriteria_list() - returns a List<Employee>
     */
    public Map<String, List<Employee>> withJava8_multipleCriteria_map() {
//                Set<Map.Entry<String, List<Employee>>> set = StreamFixture.employees().stream()
//                .filter(e -> salaryGreaterThan20000(e))
//                .collect(Collectors.groupingBy(this::getKey)).entrySet();
        Map<String, List<Employee>> map = StreamFixture.employees().stream()
                .filter(employee -> salaryGreaterThan20000(employee))
                .collect(Collectors.groupingBy(this::getCompositeKey)).entrySet().stream()
                .filter(entry -> entry.getValue().stream().anyMatch(this::inUS))
                .filter((entry -> entry.getValue().stream().anyMatch(this::isDeveloper)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return map;

    }


    /**
     * Same criteria as 'withJava8_multipleCriteria_map()'
     * withJava8_multipleCriteria_map() - This method returns a Map<String,List<Employee>>
     * withJava8_multipleCriteria_list() - returns a List<Employee>
     */
    public  List<Employee> withJava8_multipleCriteria_list() {
        List<Employee> list = StreamFixture.employees().stream()
                .filter(employee -> salaryGreaterThan20000(employee))
                .filter(employee -> inUS(employee))
                .filter(employee -> isDeveloper(employee))
                .collect(Collectors.toList());

        return list;
    }




    public boolean isDeveloper(Employee employee) {
        return employee.getDesignation() == Designation.DEVELOPER;
    }

    private boolean inUS(Employee employee) {
        return employee.getLocation() == Location.US;
    }

    private String getCompositeKey(Employee employee) {
        return employee.getName() + "_" + employee.getAge();
    }

    private boolean salaryGreaterThan20000(Employee employee) {
        return employee.getSalary() > 20000;
    }


    public boolean quantityEqualsTen(Item item) {
        return item.getQuantity() > 10;
    }

    public boolean priceLessThanTen(Item item) {
        return item.getPrice() < 10;
    }


}
