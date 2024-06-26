# Ganhando Produtividade com Stream API e Java

- A Stream API traz uma nova opção para a manipulação de coleções em Java seguindo os princípios da programação funcional;
- Stream trata-se de uma poderosa solução para processar coleções de maneira declarativa ao invés da tradicional e burocrática forma imperativa;

```
public class CarrinhoDeCompras {
    
    private List<Item> itemList;
    
    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }
    
    public double calcularValorTotal() {
        double valorTotal = 0d;
        if(!itemList.isEmpty()) {
            for(Item item : itemList) {
                double valorItem = item.getpreco() * item.getQuant();
                valorTotal += valorItem;
            }
            return valorTotal;
        } else {
        throw new RuntimeException("A lista está vazia!");
    }
}
```
- Na forma imperativa, para realizar uma soma simples, por exemplo, o desenvolvedor tem que se preocupar não apenas com o que deve ser feito em cada elemento. isto é, como as regras associadas ao processamentodos elementos da lista, mas também com a maneira de realizar esta iteração;

```
public class CarrinhoDeCompras {
    
    private List<Item> itemList;
    
    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }
    
    public double calcularValorTotal() {
        double valorTotal = 0d;
        if(itemList.isEmpty()) {
           throw new RuntimeException("A lista está vazia!"); 
        }
        return itemList.stream()
            .mapToDouble(item -> item.getPreco() * item.getQuant())
            .sum();
    }
}
```

- Combinada com as **Expressões Lambda** e **Method Reference**, eles proporcionam uma forma diferente de lidar com conjuntos de elementos, oferecendo ao desenvolvedor uma maneira simples e concisa de escrever código que resulta em facilidade de manutenção e paralelização sem efeitos indesejados em tempo de execução;

## As operações na **Stream API** podem ser classificadas em duas categorias principais:


### 1. Operações Intermediárias
___

São aquelas que retornam uma nova Stream e permitem encadear várias operações, formando uma pipeline de processamento de dados. São elas:

- **filter(Predicate<T> predicate)**: Filtra os elementos da Stream com base em um predicado. Retorna uma nova Stream contendo apenas os elementos que atendem ao critério do predicado. Exemplo: *stream.filter(n -> n > 5)*;
- **map(Function<T, R> mapper)**: Transforma cada elemento da Stream usando a função especificada e retorna uma nova Stream contendo os elementos resultantes. Exemplo: *stream.map(s -> s.toUpperCase())*;
- **sorted()**: Classifica os elementos da Stream em ordem natural (Se os elementos forem comparáveis) ou de acordo com um comparador fornecido. Exemplo:  *stream.sorted()*;
- **distinct()**: Remove elementos dublicados da Stream, considerando a implementação do método *equals()* para comparação. exemplo: *stream.distinct()*;
- **limit()**: Limita o número de elementos da Stream aos maxSize primeiros elementos. Exemplo: *stream.limit(10)*;
- **skip(long n)**: Pula os primeiros *n* elementos da Stream e retorna uma nova Stream sem eles. Exemplo: *stream.skip(5)*;

### 2. Operações Terminais
___

São aquelas que encerram o pipeline e produzem um resultado final. São elas:

- **forEach(Consumer<T> action)**: Executa um a ação para cada elemento da Stream. Exemplo: *stream.forEach(System.out::println)*;
- **toArray()**: Converte a Stream em um array contendo os elementos da Stream. Por exemplo: *stream.toArray()*;
- **collect(Collector <T, A, R> collector)**: Coleta os elementos da Stream em uma estrutura de dados específica, como uma lista ou mapa. Exemplo: *strean.collect(Collector.toList())*;
- **count()**: Retorna o número de elementos na Stream. Exemplo: *stream.count()*;
- **anyMatch(Predicate<T> predicate)**: Verifica se algum elemento da Stream atende ao predicado especificado. exemplo: *stream.anyMatch(s -> s.startsWitch("A"))*;
- **allMatch(Predicate<T> predicate)**: Verifica se todos os elementos da Stream atendem ao predicado especificado. Exemplo: *stream.allMatch(n -> n > 0)*;
- **noneMatch(Predicate<T> predicate)**: Verifica se nenhum elemento da Stream atende ao predicado especificado. Exemplo: *stream.noneMatch(s -> s.isEmpty())*;
- **min(Comparator<T> comparator)** e **max(Comparator<T> comparator>**: Encontra o elemento minimo e máximo da Stream, respectivamente, de acordo com o comparador fornecido. Exemplo: *stream.min(Comparator.naturalOrder())* e *stream.max(Comparator.naturalOrder())*;
- **reduce(T identity, BinaryOperator<T> accumulator)**: Combina os elementos da Stream usando o acumulador especificado e retorna o resultado final. Exemplo: *stream.reduce(0, (a, b) -> a + b)*;

## Lambda

As expressões *lambda* permitem representar interfaces funcionais (interfaces com um único método abstrato) de
forma mais consisa e possibilitam escrever código no estilo funcional.
- As interfaces funcionais desempenham um papel crucial na programação funcional em Java, pous servem de base para o uso de expressões lambda;
- Uma função lambda pe uma função sem declaração, isto é, não é necessário colocar um nome, um tipo de retorno e o modificador de acesso. A idéia é que o método seja declarado no mesmo lugar em que será usado;
- As funções lambda em Java tem a sintaxe definida como *(argumento) -> (corpo)*;

```
public class OrdenacaoPeassoa {

    private List<Pessoa> pessoaList;
    
    public OrdenacaoPessoa() {
        this.pessoaList = new ArrayList<>();
  }

    public List<Pessoa> ordenarPorAltura() {
        if (!pessoaList.isEmpty()) {
          List<Pessoa> pessoasPorAltura = new ArrayList<>(pessoaList);
          pessoasPorAltura.sort((p1, p2) -> Double.compare(p1.getAltura(), p2.getAltura()));
          return pessoasPorAltura;
        } else {
          throw new RuntimeException("A lista está vazia!");
        }
   }
}  
```

## Method Reference

Method Reference é um recurso do Java 8 que permite fazer referência a um método construtor de uma  
classe de forma funcional, e assim indicar que ele deve ser utilizado num ponto específico do código, deixando-o  
mais simples e legível.  
Para utilizá-lo, basta informar uma classe ou referência seguida do símbolo "**::**" e o nome do método sem os  
parêteses no final.

```
public class OrdenacaoPessoa {

  private List<Pessoa> pessoaList;
  
  public OrdenacaoPessoa() {
    this.pessoaList = new ArrayList<>();
  }

  public List<Pessoa> ordenarPorAltura() {
    if (!pessoaList.isEmpty()) {
      List<Pessoa> pessoasPorAltura = new ArrayList<>(pessoaList);
      pessoasPorAltura.sort(Comparator.comparingDouble(Pessoa::getAltura));
      return pessoasPorAltura;
    } else {
      throw new RuntimeException("A lista está vazia!");
    }
  }
}
```

## Referências
___

[1] "Java Stream API - Oracle." Oracle Brasil. Disponível em: https://www.oracle.com/br/technical-resources/articles/java-stream-api.html.

[2] "Java Collections API Examples - cami-la." GitHub. Disponível em: https://github.com/cami-la/collections-java-api-2023.

[3] "Como usar funções functional_interface em Java - DevMedia." DevMedia. Disponível em: https://www.devmedia.com.br/como-usar-funcoes-lambda-em-java/32826.

___

## Funcitional Interface

Qualquer interface com um SAM (Single Abstract Method) é uma interface funcional e sua implementação pode ser  
tratada como expressões lambda.

### Consumer<T>

Representa uma operação que aceita um argumento do tipo T e não retorna nenhum resultado. É utilizada principalmente  
para realizar ações ou efeitos colaterais nos elementos do Stream sem modificar ou retornar um valor. Exemplos:

```
public class ConsumerExample {
  public static void main(String[] args) {
    // Criar uma lista de números inteiros
    List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

    // Usar o Consumer com expressão lambda para imprimir números pares
    Consumer<Integer> imprimirNumeroPar = numero -> {
      if (numero % 2 == 0) {
        System.out.println(numero);
      }
    };

    // Usar o Consumer para imprimir números pares no Stream
    numeros.stream_api().forEach(imprimirNumeroPar);
  }
}
```

```
public class ConsumerExample {
  public static void main(String[] args) {
    // Criar uma lista de números inteiros
    List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

    // Usar o Consumer com uma classe anônima para imprimir números pares
    Consumer<Integer> imprimirNumeroPar = new Consumer<Integer>() {
      @Override
      public void accept(Integer numero) {
        if (numero % 2 == 0) {
          System.out.println(numero);
        }
      }
    };

    // Usar o Consumer para imprimir números pares da lista
    for (Integer numero : numeros) {
      imprimirNumeroPar.accept(numero);
    }
  }
}
```

### Suplier<T>

Representa uma operção que não aceita nenhum argumento e retorna um resultado do tipo T. É comumente usado para criar  
ou fornecer novos objetos de um determinado tipo. Exemplos:

```
public class SupplierExample {
  public static void main(String[] args) {
    // Usar o Supplier com expressão lambda para fornecer uma saudação personalizada
    Supplier<String> saudacao = () -> "Olá, seja bem-vindo(a)!";

    // Usar o Supplier para obter uma lista com 5 saudações
    List<String> listaSaudacoes = Stream.generate(saudacao)
        .limit(5)
        .collect(Collectors.toList());

    // Imprimir as saudações geradas
    listaSaudacoes.forEach(System.out::println);
  }
} 
```

``` 
public class SupplierExample {
  public static void main(String[] args) {
    // Usar o Supplier com uma classe anônima para fornecer uma saudação personalizada
    Supplier<String> saudacao = new Supplier<String>() {
      @Override
      public String get() {
        return "Olá, seja bem-vindo(a)!";
      }
    };

    // Usar o Supplier para obter uma lista com 5 saudações
    List<String> listaSaudacoes = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      listaSaudacoes.add(saudacao.get());
    }

    // Imprimir as saudações geradas
    for (String saudacaoGerada : listaSaudacoes) {
      System.out.println(saudacaoGerada);
    }
  }
}
```

### Function<T, R>

Representa uma função que aceita um argumento do tipo T e retorna um resultado do tipo R. É utilizada para transformar ou  
mapear os elementos do Stream em outros valores ou tipos. Exemplos:

``` 
public class FunctionExample {
  public static void main(String[] args) {
    // Criar uma lista de números inteiros
    List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

    // Usar a Function com expressão lambda para dobrar todos os números
    Function<Integer, Integer> dobrar = numero -> numero * 2;

    // Usar a função para dobrar todos os números no Stream e armazená-los em outra lista
    List<Integer> numerosDobrados = numeros.stream_api()
        .map(dobrar)
        .collect(Collectors.toList());

    // Imprimir a lista de números dobrados
    numerosDobrados.forEach(System.out::println);
  }
}
```

``` 
public class FunctionExample {
  public static void main(String[] args) {
    // Criar uma lista de números inteiros
    List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

    // Usar a Function com uma classe anônima para dobrar todos os números
    Function<Integer, Integer> dobrar = new Function<Integer, Integer>() {
      @Override
      public Integer apply(Integer numero) {
        return numero * 2;
      }
    };

    // Usar a função para dobrar todos os números e armazená-los em outra lista
    List<Integer> numerosDobrados = new ArrayList<>();
    for (Integer numero : numeros) {
      numerosDobrados.add(dobrar.apply(numero));
    }

    // Imprimir a lista de números dobrados
    for (Integer numeroDobrado : numerosDobrados) {
      System.out.println(numeroDobrado);
    }
  }
}
```

### Predicate<T> 

Representa uma função que aceita um argumento do tipo T e retorna um valor booleano (verdadeiro ou falso). É comumente usada  
para filtrar os elementos do Stream com base em alguma condição. Exemplos:

``` 
public class PredicateExample {
  public static void main(String[] args) {
    // Criar uma lista de números inteiros
    List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    // Usar o Predicate com expressão lambda para filtrar números pares
    Predicate<Integer> isPar = numero -> numero % 2 == 0;

    // Usar o predicado para filtrar números pares no Stream e armazená-los em outra lista
    List<Integer> numerosPares = numeros.stream_api()
        .filter(isPar)
        .collect(Collectors.toList());

    // Imprimir a lista de números pares
    numerosPares.forEach(System.out::println);
  }
}
```

``` 
public class PredicateExample {
  public static void main(String[] args) {
    // Criar uma lista de números inteiros
    List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    // Usar o Predicate com uma classe anônima para filtrar números pares
    Predicate<Integer> isPar = new Predicate<Integer>() {
      @Override
      public boolean test(Integer numero) {
        return numero % 2 == 0;
      }
    };

    // Usar o predicado para filtrar números pares e armazená-los em outra lista
    List<Integer> numerosPares = new ArrayList<>();
    for (Integer numero : numeros) {
      if (isPar.test(numero)) {
        numerosPares.add(numero);
      }
    }

    // Imprimir a lista de números pares
    for (Integer numeroPar : numerosPares) {
      System.out.println(numeroPar);
    }
  }
}
```

### BinaryOperator<T>

Representa uma operação que combina dois argumentos do tipo T e retorna um resultado do mesmo tipo T. É usada para realizar  
operações de redução em pares de elementos, como somar números ou combinar objetos.

``` 
public class BinaryOperatorExample {
  public static void main(String[] args) {
    // Criar uma lista de números inteiros
    List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

    // Usar o BinaryOperator com expressão lambda para somar dois números inteiros
    BinaryOperator<Integer> somar = (num1, num2) -> num1 + num2;

    // Usar o BinaryOperator para somar todos os números no Stream
    int resultado = numeros.stream_api()
        .reduce(0, somar);

    // Imprimir o resultado da soma
    System.out.println("A soma dos números é: " + resultado);
  }
}
```

``` 
public class BinaryOperatorExample {
  public static void main(String[] args) {
    // Criar uma lista de números inteiros
    List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

    // Usar o BinaryOperator com classe anônima para somar dois números inteiros
    BinaryOperator<Integer> somar = new BinaryOperator<Integer>() {
      @Override
      public Integer apply(Integer num1, Integer num2) {
        return num1 + num2;
      }
    };

    // Usar o BinaryOperator para somar todos os números no Stream
    int resultado = numeros.stream_api()
        .reduce(0, somar);

    // Imprimir o resultado da soma
    System.out.println("A soma dos números é: " + resultado);
  }
}
```

> Classe Anônima: É uma classe que não recebeu um nome e é tanto declarado e instanciado em uma única instrução. Você deve  
considerar o uso de uma classe aônima seore que precisar criar uma classe que será instanciada apenas uma vez.

___

### Referências

[1] "Java 8 Functional Interfaces." Baeldung. Disponível em: https://www.baeldung.com/java-8-functional-interfaces.

[2] "Como utilizar uma classe anônima em Java." FAQ CartX. Disponível em: https://faqcartx.info/programa%C3%A7%C3%A3o/40977-como-utilizar-uma-classe-an%C3%B4nima-em-java.html.


