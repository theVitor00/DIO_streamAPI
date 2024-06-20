package Desafios;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;



public class Desafio5 {

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        Predicate<Integer> maioresQueCinco = numero -> numero > 5;
        ToDoubleFunction<Integer> toDouble = n -> n;

        OptionalDouble media = numeros.stream()
                .filter(maioresQueCinco)
                .mapToDouble(toDouble)
                .average();

        System.out.println(media);
    }

}
