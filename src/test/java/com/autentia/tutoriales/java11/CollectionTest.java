package com.autentia.tutoriales.java11;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toUnmodifiableList;
import static java.util.stream.Collectors.toUnmodifiableMap;

public class CollectionTest {

    @Test
    public void collectionTest() {
        List<Integer> list = List.of(1, 2, 3);
        Set<String> set = Set.of("a", "b", "c");
        Stream<String> stream = Stream.of("a", "b", "c");
        Map<String, String> map = Map.of("clave 1", "valor 1", "clave 2",  "valor 2");

        System.out.println(list);
        System.out.println(set);
        System.out.println(stream.collect(Collectors.toList()));
        System.out.println(map);

        List<Integer> listCopyOf = List.copyOf(list);
        Set<String> setCopyOf = Set.copyOf(set);
        Map<String, String> mapCopyOf = Map.copyOf(map);


        System.out.println(listCopyOf);
        System.out.println(setCopyOf);
        System.out.println(mapCopyOf);

        List toUnmodifiableList = Stream.of("a", "b", "c").collect(toUnmodifiableList());
        Set toUnmodifiableSet = Stream.of("g", "h", "i").collect(Collectors.toUnmodifiableSet());
        Map<Integer, Integer> toUnmodifiableMap = Stream.of(1, 2, 3).collect(toUnmodifiableMap(num -> num, num -> num * 4));

        System.out.println(toUnmodifiableList);
        System.out.println(toUnmodifiableSet);
        System.out.println(toUnmodifiableMap);

    }
}
