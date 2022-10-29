package com.autentia.tutoriales.java11;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest {

    @Test
    public void streamsTest() {
        System.out.println("Ejemplo takeWhile():");
        List takeWhileResult = Stream.of(1, 2, 3, 4, 5).takeWhile(value -> value < 3).collect(Collectors.toList());
        System.out.println(takeWhileResult);

        System.out.println("Ejemplo dropWhile():");
        List dropWhileResult = Stream.of(1, 2, 3, 4, 5).dropWhile(value -> value < 3).collect(Collectors.toList());
        System.out.println(dropWhileResult);

        System.out.println("Ejemplo iterate():");
        List iterateResult = Stream.iterate(1L, n  ->  n  + 1).limit(10).collect(Collectors.toList());
        System.out.println(iterateResult);

        System.out.println("Ejemplo ofNullable():");
        String example = "example";
        List ofNullableResult = Stream.ofNullable(example).collect(Collectors.toList());
        System.out.println(ofNullableResult);
        String nullExample = null;
        List ofNullableNullResult = Stream.ofNullable(nullExample).collect(Collectors.toList());
        System.out.println(ofNullableNullResult);

    }

}
