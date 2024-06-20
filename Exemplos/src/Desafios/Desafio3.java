package Desafios;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Desafio3 {

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, -5, 6, 7, 8, 9, -10, 5, 4, 3);
        Predicate<Integer> isPositivo = numero -> numero > 0;

        List<Integer> checkPositivos = numeros.stream()
                .filter(isPositivo)
                .toList();

        checkPositivos.forEach(System.out::println);
    }
}
