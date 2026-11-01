
package org.example.app;

import java.util.Scanner;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.HashSet;

import org.example.cardapio.ItemCardapio;
import org.example.cardapio.Lanche;
import org.example.cardapio.ComCheddar;
import org.example.cardapio.ComBaconExtra;
import org.example.pedido.Pedido;

public class MenuConsole {

    private Scanner sc = new Scanner(System.in);

    public void exibirMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1 - Novo pedido");
        System.out.println("2 - Listar pedidos");
        System.out.println("3 - Fechamento do dia");
        System.out.println("0 - Sair");
    }

    public int lerOpcao() {
        return lerOpcaoDentroDoIntervalo(
                "Escolha uma opção: ", 0, 3
        );
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void exibirCardapio() {
        System.out.println("\n=== CARDÁPIO ===");
        System.out.println("1 - X-Burger - R$ 16,00");
        System.out.println("2 - X-Salada - R$ 18,00");
        System.out.println("3 - X-Bacon - R$ 22,00");
    }

    public int lerOpcaoLanche() {
        return lerOpcaoDentroDoIntervalo(
                "Escolha seu lanche: ", 1, 3
        );
    }

    public boolean perguntarMaisItem() {
        System.out.print("\nDeseja adicionar outro lanche? (S/N): ");
        String resposta = sc.nextLine();
        return resposta.equalsIgnoreCase("S");
    }

    public String lerNomeCliente() {
        System.out.print("Nome do cliente: ");
        return sc.nextLine();
    }

    public void exibirPedido(Pedido pedido) {
        System.out.println("\n=== RESUMO DO PEDIDO ===");
        System.out.println("Pedido nº: " + pedido.getNumero());
        System.out.println("Cliente: " + pedido.getNomeCliente());

        for (ItemCardapio item : pedido.getItens()) {
            System.out.println(
                    item.getDescricao() + " - R$ " +
                            String.format("%.2f", item.getPreco())
            );
        }

        System.out.printf("Total: R$ %.2f%n", pedido.calcularTotal());
    }

    public void exibirFechamentoDoDia(double total, HashSet<String> combinacoes) {
        System.out.println("\n=== FECHAMENTO DO DIA ===");
        System.out.printf("Total vendido: R$ %.2f%n", total);

        System.out.println("\nCombinações diferentes: " + combinacoes.size());

        for (String combinacao : combinacoes) {
            System.out.println("- " + combinacao);
        }
    }

    public void exibirPedidos(Collection<Pedido> pedidos) {
        System.out.println("\n=== PEDIDOS REALIZADOS ===");

        for (Pedido pedido : pedidos) {
            exibirPedido(pedido);
        }
    }

    public ItemCardapio personalizarLanche(Lanche lanche) {

        ItemCardapio itemPersonalizado = lanche;
        boolean personalizando = true;

        while (personalizando) {

            System.out.println("\n=== PERSONALIZE SEU LANCHE ===");
            System.out.println("Lanche: " + itemPersonalizado.getDescricao());

            System.out.printf(
                    "Preço atual: R$ %.2f%n",
                    itemPersonalizado.getPreco()
            );

            System.out.println("\n1 - Remover ingredientes");
            System.out.println("2 - Adicionar ingredientes");
            System.out.println("3 - Prosseguir com o pedido");

            int opcao = lerOpcaoDentroDoIntervalo(
                    "Escolha uma opção: ", 1, 3
            );

            switch (opcao) {

                case 1:
                    removerIngrediente(lanche);
                    break;

                case 2:
                    itemPersonalizado = adicionarAdicional(itemPersonalizado);
                    break;

                case 3:
                    personalizando = false;
                    break;
            }
        }

        return itemPersonalizado;
    }

    private void removerIngrediente(Lanche lanche) {

        System.out.println("\n=== REMOVER INGREDIENTES ===");

        if (lanche.isQueijo()) {
            System.out.println("1 - Queijo");
        }

        if (lanche.isAlface()) {
            System.out.println("2 - Alface");
        }

        if (lanche.isTomate()) {
            System.out.println("3 - Tomate");
        }

        if (lanche.isCebola()) {
            System.out.println("4 - Cebola");
        }

        System.out.println("0 - Voltar");

        int opcao = lerOpcaoDentroDoIntervalo(
                "Qual ingrediente deseja retirar? ", 0, 4
        );

        switch (opcao) {

            case 1:
                if (lanche.isQueijo()) {
                    lanche.setQueijo(false);
                    System.out.println("Queijo removido!");
                } else {
                    System.out.println("Esse lanche já está sem queijo.");
                }
                break;

            case 2:
                if (lanche.isAlface()) {
                    lanche.setAlface(false);
                    System.out.println("Alface removida!");
                } else {
                    System.out.println("Esse lanche já está sem alface.");
                }
                break;

            case 3:
                if (lanche.isTomate()) {
                    lanche.setTomate(false);
                    System.out.println("Tomate removido!");
                } else {
                    System.out.println("Esse lanche já está sem tomate.");
                }
                break;

            case 4:
                if (lanche.isCebola()) {
                    lanche.setCebola(false);
                    System.out.println("Cebola removida!");
                } else {
                    System.out.println("Esse lanche já está sem cebola.");
                }
                break;

            case 0:
                break;
        }
    }

    private ItemCardapio adicionarAdicional(ItemCardapio item) {

        System.out.println("\n=== ADICIONAR ADICIONAIS ===");

        System.out.println("1 - Cheddar      | R$ 4,00");
        System.out.println("2 - Bacon extra  | R$ 6,00");
        System.out.println("0 - Voltar");

        int opcao = lerOpcaoDentroDoIntervalo(
                "Escolha o adicional: ", 0, 2
        );

        switch (opcao) {

            case 1:
                item = new ComCheddar(item);
                break;

            case 2:
                item = new ComBaconExtra(item);
                break;

            case 0:
                break;
        }

        if (opcao != 0) {
            System.out.println("Adicional acrescentado!");
        }

        return item;
    }

    private int lerOpcaoDentroDoIntervalo(
            String mensagem, int minimo, int maximo
    ) {
        int opcao;

        while (true) {
            try {
                System.out.print(mensagem);
                opcao = sc.nextInt();
                sc.nextLine();

                if (opcao >= minimo && opcao <= maximo) {
                    return opcao;
                }

                System.out.println("Opção inválida. Tente novamente.");

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                sc.nextLine();
            }
        }
    }
}
