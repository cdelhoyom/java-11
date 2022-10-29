package com.autentia.tutoriales.java11;

import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OptionalTest {

    @Test
    public void streamTest() {
        Optional<String> optionalConUnTexto = Optional.of("Un texto");
        Optional<String> optionalVacio = Optional.empty();
        Optional<String> optionalConOtroTexto = Optional.of("Otro texto");

        List<String> textos = Stream.of(optionalConUnTexto, optionalVacio, optionalConOtroTexto)
                .flatMap(optional -> optional.stream()).collect(toList());

        assertEquals(2, textos.size());
        assertEquals("Un texto", textos.get(0));
        assertEquals("Otro texto", textos.get(1));

    }

    @Test
    public void ifPresentOrElseTest() {
        Optional<String> optionalConUnTexto = Optional.of("Un texto");
        Optional<String> optionalVacio = Optional.empty();

        optionalConUnTexto.ifPresentOrElse(
                texto ->{
                    System.out.printf("El optional con texto debería pasar por el present");
                    assertEquals("Un texto", texto);
                },
                () -> {
                    throw new RuntimeException("El optional con texto nunca debería pasar por el else");
                }
        );

        optionalVacio.ifPresentOrElse(
                texto -> {
                    throw new RuntimeException("El optional vacío nunca debería pasar por el present");
                },
                () -> System.out.printf("El optional vacío debería pasar por el else")
        );

    }

    @Test
    public void orTest() {
        Optional<String> optionalConUnTexto = Optional.of("Un texto");
        Optional<String> optionalVacio = Optional.empty();

        Optional orOptionalConUnTexto = optionalConUnTexto.or(()->Optional.of("Optional vacío"));
        Optional orOptionalVacio = optionalVacio.or(()->Optional.of("Optional vacío"));

        assertEquals("Un texto", orOptionalConUnTexto.get());
        assertEquals("Optional vacío", orOptionalVacio.get());
    }

    @Test(expected = Exception.class)
    public void orElseThrowTest() throws Exception{
        Optional<String> optionalVacio = Optional.empty();

        assertTrue(!optionalVacio.isPresent());

        optionalVacio.orElseThrow(()-> new Exception("El optional era nulo"));
    }
}
