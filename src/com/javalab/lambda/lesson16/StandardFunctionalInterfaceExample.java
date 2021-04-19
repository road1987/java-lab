package com.javalab.lambda.lesson16;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import com.javalab.lambda.common.Person;

public class StandardFunctionalInterfaceExample {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Person> persons = Arrays.asList(new Person("louis", "c", 30), new Person("angel", "b", 25), new Person("Susan", "a", 20));

        Collections.sort(persons, (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName()));


        print(persons, person -> person.getFirstName().startsWith("l"), person -> System.out.println(person.toString()));

    }

    public static void print(List<Person> persons, Predicate<Person> predicate, Consumer<Person> consumer) {
        persons.forEach(person -> {
            if (predicate.test(person)) {
                consumer.accept(person);
            }
        });
    }

}
