# Exercício: JUnit vanilla

Você deve implementar os testes para validar uma classe que representa um financiamento, conforme diagrama a seguir.

O financiamento armazena o montante total de dinheiro financiado (totalAmount), bem como a renda mensal do cliente que está pleiteando o financiamento (income) e o número de meses do financiamento (months). Os métodos entry e quota retornam, respectivamente, os valores da entrada e da prestação mensal do financiamento.

As regras para financiamento são as seguintes:
* O valor da entrada deve ser 20% do montante.
* O valor da prestação deve ser os 80% restantes do montante, divididos pelo número de meses do financiamento.
* O valor da prestação não pode ser maior que metade da renda do cliente. Tanto o construtor com argumentos, quando os métodos setTotalAmount(double), setIncome(double), e setMonths(int) devem lançar uma exceção caso os valores atribuídos não respeitem esta regra.

Você deve criar testes para validar os métodos da classe, inclusive o construtor e os setters. No caso do construtor e setters, você deve cobrir pelo menos dois cenários para cada: quando os dados satisfazem, e quando não satisfazem a regra de negócio (total = pelo menos 10 testes).

> Sugestão: tente fazer seguindo o princípio do TDD (escreva os testes antes de fazer a classe Financing).


> Dica: se você estiver em dúvida sobre como o construtor e os setters devem lançar a exceção, seria algo como mostrado abaixo (você faz uma verificação no início do método, lançando uma exceção caso necessário - isso se chama “programação defensiva”):

 ```java
public void setIncome(double income) {
    if (quota() > income / 2.0) {
        throw new IllegalArgumentException("A prestação não pode ser maior que metade da renda");
    }
    this.income = income;
}
```