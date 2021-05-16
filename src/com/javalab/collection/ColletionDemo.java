package com.javalab.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ColletionDemo {

    public static void main(String[] args) {
        arrayListTest();

        setTest();

        mapTest();
    }

    public static void arrayListTest() {
        Collection<Collection<Integer>> integers = new ArrayList<>();
        integers.add(Arrays.asList(1, 1, 1, 1));
        integers.add(Arrays.asList(2, 2, 2, 2));
        integers.add(Arrays.asList(3, 3, 3, 3));
        integers.add(Arrays.asList(4, 4, 4, 4));
        System.out.println(integers.toString());

        Collection<Integer> integers2 = new ArrayList<Integer>();

        integers2 = integers.stream().flatMap((item) -> {
            return item.stream();
        }).collect(Collectors.toList());
        System.out.println(integers2.toString());
    }

    public static void setTest() {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        set.add(1);
        set.add(1);
        System.out.println(set.toString());

    }

    public static void mapTest() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "string");
        map.put(2, "string2");
        System.out.println(map.toString());

    }

}
