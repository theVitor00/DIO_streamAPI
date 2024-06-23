package Desafios;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Desafio19 {

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 2, 3, -4, 5, 6, 7, 8, 9, 10, 5, 4, 3, 15, 30);

        Predicate<Integer> multiplosTresCinco = num -> {
            if(num % 3 == 0 && num % 5 == 0) {
                return true;
            }
            return false;
        };

        System.out.println(numeros.stream().filter(multiplosTresCinco).reduce(0, Integer::sum));
    }
}
