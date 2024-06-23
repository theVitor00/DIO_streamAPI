package Desafios;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Desafio18 {

    public static void main(String[] args) {

        //List<Integer> numeros = Arrays.asList(1, 2, 3, -4, 5, 6, 7, 8, 9, 10, 5, 4, 3);
        List<Integer> numeros = Arrays.asList(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2);

        boolean todosIguais = numeros.stream()
                .allMatch(num -> num.equals(numeros.get(0)));

        System.out.println(todosIguais);
    }
}
