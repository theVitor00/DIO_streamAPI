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