

# Sistema de Pedidos de Restaurante

Projeto desenvolvido durante o curso de Java da Elas Tech, com o objetivo de praticar conceitos de Programação Orientada a Objetos, padrões de projeto e testes automatizados.

## Sobre o projeto

O sistema simula o funcionamento de um restaurante, permitindo visualizar o cardápio, selecionar lanches, personalizar pedidos com ingredientes adicionais e calcular o valor total.

O desenvolvimento teve como foco a organização do código, a separação de responsabilidades e a aplicação de boas práticas de programação.

## Link do vídeo 
https://app.screencastify.com/watch/9awigbZLqPIUZR1M0aYe

## Funcionalidades

- Visualização do cardápio.
- Seleção de lanches.
- Personalização dos lanches.
- Adição de ingredientes extras.
- Remoção de ingredientes.
- Gerenciamento de pedidos.
- Cálculo do valor total.

## Tecnologias utilizadas

- Java 17
- JUnit 5
- IntelliJ IDEA

## Estrutura do projeto

O projeto foi organizado em pacotes para facilitar a manutenção e separar as responsabilidades:

| Pacote | Responsabilidade |
|---|---|
| `app` | Inicialização e interação com a aplicação. |
| `cardapio` | Classes relacionadas aos lanches e ingredientes. |
| `pedido` | Gerenciamento dos pedidos. |
| `financeiro` | Cálculos financeiros. |
| `util` | Funcionalidades auxiliares. |

## Conceitos aplicados

Durante o desenvolvimento, foram utilizados conceitos de:

- **Programação Orientada a Objetos:** encapsulamento, abstração, herança e polimorfismo.
- **Padrão Decorator:** permite adicionar ingredientes extras aos lanches sem modificar sua implementação original.
- **Princípios SOLID:** aplicação dos princípios SRP, OCP e DIP para melhorar a organização, manutenção e flexibilidade do código.
- **Testes automatizados:** utilização do JUnit 5 para validar o funcionamento das funcionalidades e os cálculos do sistema.

## Testes

Os testes automatizados foram desenvolvidos com JUnit 5.
