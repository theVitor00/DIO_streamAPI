package Consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


public class ComsumerExample {

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        // Usar o Consumer com expressão lambdar para imprimir números pares
        Consumer<Integer> imprimirNumeroPar = numero -> {
            if(numero % 2 == 0) System.out.println(numero);
        };

        // Usar o Consumer para imprimir os numeros pares no Stream

        // numeros.stream().forEach(imprimirNumeroPar);

        /*
        numeros.stream().forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer numero) {
                if(numero % 2 == 0) System.out.println(numero);
            }
        });
        */


        numeros.stream()
                .filter(numero -> numero % 2 == 0)
                .forEach(System.out::println);
    }
}
