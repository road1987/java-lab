package com.javalab.lambda.lesson13To15;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import com.javalab.lambda.common.Person;

public class Unit1Exercise {

    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(new Person("louis", "c", 30), new Person("angel", "b", 25), new Person("Susan", "a", 20));
        printAll(persons);

        // step1 sort list by last name
        // before the lambda
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        printAll(persons);

        // after the lambda
        List<Person> sortedPersons =
                persons.stream().sorted((a, b) -> a.getLastName().compareTo(b.getLastName())).collect(Collectors.toList());
        printAll(sortedPersons);
        // step2 create a print function

        // filter all the person who's first start with a;
        List<Person> startWithAPersons =
                persons.stream().filter(person -> person.getFirstName().startsWith("a")).collect(Collectors.toList());
        printAll(startWithAPersons);


        // before lambda function
        System.out.println("print all the persons with first name start with l");
        printConditionally(persons, new Condition() {
            @Override
            public boolean test(Person person) {
                return person.getFirstName().startsWith("l");
            }
        });
        // with lambda
        System.out.println("print all the persons with first name start with l");
        printConditionally(persons, person -> person.getFirstName().startsWith("l"));

        // with lambda function package out of box interface.
        System.out.println("outOfBoxInterface : print all the persons with first name start with l");
        printWithOutOfBoxInterface(persons, person -> person.getFirstName().startsWith("l"));
    }

    public static void printAll(List<Person> persons) {
        persons.forEach(person -> System.out.println(person.toString()));
        System.out.println();
    }

    public static void printConditionally(List<Person> persons, Condition condition) {
        persons.forEach(person -> {
            if (condition.test(person))
                System.out.println(person.toString());
        });
    }

    public static void printWithOutOfBoxInterface(List<Person> persons, Predicate<Person> predicate) {
        persons.forEach(person -> {
            if (predicate.test(person))
                System.out.println(person.toString());
        });
    }
}


@FunctionalInterface
interface Condition {
    boolean test(Person person);
}
