package com.autentia.tutoriales.java11;

import org.junit.Test;

import java.util.Map;

public class LambdaTest {

    @Test
    public void lambdaTest() {
        var map = Map.of(1, 2, 3, 4, 5, 6);
        map.forEach((x, y) -> System.out.println(x + y));
        map.forEach((Integer x, Integer y) -> System.out.println(x + y));
        map.forEach((var x, var y) -> System.out.println(x + y));

        // map.forEach((x, var y) -> System.out.println(x + y)); // No compila
        // map.forEach((int x, var y) -> System.out.println(x + y)); // No compila

    }
}
