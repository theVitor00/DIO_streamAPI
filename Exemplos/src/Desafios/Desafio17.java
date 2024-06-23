package Desafios;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Desafio17 {

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 5, 4, 3, 17, 21, 23, 25, 27, 29);

        Predicate<Integer> isPrimo = num -> {
            for(int i = 2; i <= num / 2; i++) {
                if(num % i == 0) return false;
            }
            return true;
        };

        List<Integer> primos = numeros.stream()
                .filter(isPrimo)
                .distinct()
                .toList();

        System.out.println("Primos: " + primos);
    }
}
