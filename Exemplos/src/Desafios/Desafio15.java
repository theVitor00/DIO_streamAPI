package Desafios;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Desafio15 {

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 2, 3, -4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        Predicate<Integer> isNegativo = num -> num < 0;
        boolean possuiNegativo = numeros.stream()
                .anyMatch(isNegativo);

        System.out.println(possuiNegativo == true ? "Possui negativo" : "Não possui negativo");

    }
}
