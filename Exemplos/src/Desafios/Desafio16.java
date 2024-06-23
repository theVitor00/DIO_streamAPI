package Desafios;

import java.util.Arrays;
import java.util.List;

public class Desafio16 {

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 2, 3, -4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        List<Integer> pares = numeros.stream().filter(num -> num % 2 == 0).toList();
        List<Integer> impares = numeros.stream().filter(num -> num % 2 != 0).toList();

        System.out.println("Pares: " + pares);
        System.out.println("Impares: " + impares);
    }
}
