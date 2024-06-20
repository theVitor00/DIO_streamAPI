package Desafios;

import java.util.List;
import java.util.Arrays;
import java.util.function.Predicate;

public class Desafio6 {

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 18, 9, 10, 5, 4, 3);

        Predicate<Integer> maiorQueDez = num -> num > 10;

        numeros.stream()
                .filter(maiorQueDez)
                .forEach(System.out::println);
    }
}
