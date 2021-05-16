package com.javalab.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        List<String> list = new ArrayList<String>();
        list.add("item1");
        list.add("item2");
        list.add("item3");
        list.add("item3");

        Stream<String> strStream1 = list.stream();
        Stream<String> strStream = Stream.of("item1", "item2", "item3");

        ThreadLocal<Double> a = new ThreadLocal<Double>();
        // multiple thread
        strStream1.parallel().forEach(item -> {
            System.out.println(item + ":" + a.get() + ":" + Thread.currentThread());
            a.set(20000D);
        });

        strStream.forEach(item -> {
            System.out.println(item + ":" + a.get() + ":" + Thread.currentThread());
        });

        long count = list.stream().distinct().count();
        System.out.println(count);


        List<String> resultList = list.stream().map(element -> element.toUpperCase()).collect(Collectors.toList());
        System.out.println(resultList);


        // flat map test
        flatMapTest();

    }


    public static void flatMapTest() {
        List<Teacher> teachers = new ArrayList<>();
        List<String> addressList1 = Arrays.asList("address1", "address2");
        Teacher teacher1 = new Teacher("wang", 30, addressList1);
        List<String> addressList2 = Arrays.asList("address3", "address4");
        Teacher teacher2 = new Teacher("li", 20, addressList2);
        teachers.add(teacher1);
        teachers.add(teacher2);

        // print all the address use map
        teachers.stream().map(teacherItem -> {
            return teacherItem.getAddress();
        }).forEach(address -> {
            address.forEach(System.out::println);
        });

        // print all address with flatMap
        List<String> addressList = teachers.stream().flatMap(teacherItem -> teacherItem.getAddress().stream()).collect(Collectors.toList());

        System.out.println(addressList);
    }

    public static class Teacher {
        private String name;
        private int age;
        private List<String> address = Arrays.asList("address1", "address2");

        public Teacher(String name, int age, List<String> address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public List<String> getAddress() {
            return address;
        }

    }
}
