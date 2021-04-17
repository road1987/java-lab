package com.javalab.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        final Integer DEFAULT_VALUE = 0;
        Optional<Integer> opt1 = Optional.empty();
        System.out.println(opt1.orElse(DEFAULT_VALUE));

        Optional<Integer> opt2 = Optional.of(1);
        System.out.println(opt2.orElse(DEFAULT_VALUE));

        List<String> DEFAULT_LIST = Arrays.asList("item1", "item2");

        // before java8
        List<String> list = getList();
        List<String> listOpt_old = list != null ? list : DEFAULT_LIST;
        listOpt_old.forEach((item) -> {
            System.out.println(item);
        });

        // after java8 optional
        List<String> listOpt_new = Optional.ofNullable(getList()).orElse(DEFAULT_LIST);
        listOpt_new.forEach((item) -> {
            System.out.println(item);
        });
    }

    public static List<String> getList() {
        return Arrays.asList("test");
    }
}
