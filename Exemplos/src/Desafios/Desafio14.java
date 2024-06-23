package Desafios;

import java.util.Comparator;
import java.util.List;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;


public class Desafio14 {

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 45, 11, 15, 17, 97, 5, 4, 3, 99);
        Predicate<Integer> isPrimo = num -> {
            for(int i = 2; i <= Math.sqrt(num); i++) {
                if(num % i == 0) return false;
            }
            return true;
        };

        List<Integer> primos = numeros.stream()
                .filter(isPrimo)
                .distinct()
                .toList();

        Optional<Integer> maiorPrimo = primos.stream()
                .max(Comparator.naturalOrder());

        System.out.println(maiorPrimo);

    }
}
