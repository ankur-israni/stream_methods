package com.core.newfeatures.java8.streams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Map;

public class StreamServiceTests {

    private StreamService streamService;

    @BeforeEach
    public  void setup(){
        streamService = new StreamService();
    }

    @Test
    public void withJava8_multipleCriteria_map(){
        Map<String,List<Employee>> map = streamService.withJava8_multipleCriteria_map();
        streamService.print(map);
    }

    @Test
    public void withJava8_multipleCriteria_list(){
        List<Employee> list = streamService.withJava8_multipleCriteria_list();
        System.out.println(list);
    }

    @Test
    public void withJava8_groupingBy_multipleFactors(){
        Map<String,List<Item>> map = streamService.withJava8_groupingBy_multipleFactors();
        streamService.print(map);

    }

    @Test
    public void withJava8_groupingBy_itemPrice(){
        Map<String,Double> map = streamService.withJava8_groupingBy_itemPrice();
        streamService.print(map);
    }


    @Test
    public void withJava8_groupingBy_ItemName(){
        Map<String,Long> map = streamService.withJava8_groupingBy_ItemName();
        streamService.print(map);
    }


    @Test
    public void withJava8_groupingBy_groupedStringValues_count(){
        Map<String, Long> map = streamService.withJava8_groupingBy_StringValues_count();
        streamService.print(map);
    }

    @Test
    public void withJava8_groupingBy_groupedStringValues(){
     Map<String, List<String>> map = streamService.withJava8_groupingBy_groupedStringValues();
     streamService.print(map);
    }




    @Test
    public void withJava8Map(){
        System.out.println("*********** Stream > map()**************");
        System.out.println("List BEFORE map() function");
        StreamFixture.hobbies().forEach(System.out::println);

        System.out.println();
        System.out.println("List AFTER map() function");
        List<String> hobbies =  streamService.withJava8Map(StreamFixture.hobbies());
        hobbies.forEach(System.out::println);
    }

    @Test
    public void withJava8FlatMap(){
        System.out.println("*********** Stream > flatMap()**************");
        System.out.println("List BEFORE map() function");
        StreamFixture.hobbies().forEach(System.out::println);


        System.out.println();
        System.out.println("List AFTER flatMap() function");
        List<String> hobbies = streamService.withJava8FlatMap(StreamFixture.hobbies());
        hobbies.forEach(System.out::println);
    }


    @Test
    public void withJava8SequentialStream(){
        Instant start = Instant.now();
        List<Integer> evenNumbers = streamService.withJava8SequentialStream(StreamFixture.numbers());
        Instant end = Instant.now();
        Duration duration = Duration.between(start,end);
        System.out.println("**************** Stream > Sequential Stream duration **********");
        System.out.println(duration.toMillis() +" milliseconds");
    }

    @Test
    public void withJava8ParallelStream(){
        Instant start = Instant.now();
        List<Integer> evenNumbers = streamService.withJava8ParallelStream(StreamFixture.numbers());
        Instant end = Instant.now();
        Duration duration = Duration.between(start,end);
        System.out.println("**************** Stream > Parallel Stream duration **********");
        System.out.println(duration.toMillis());
    }
}
