package Desafios;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Desafio13 {

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        Predicate<Integer> entreCincoDez = num -> num >= 5 && num <= 10;

        List<Integer> numIntervalo = numeros.stream()
                .filter(entreCincoDez)
                .toList();

        System.out.println(numIntervalo);
    }
}
