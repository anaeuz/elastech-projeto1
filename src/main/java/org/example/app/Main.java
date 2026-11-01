
package org.example.app;
import org.example.cardapio.ItemCardapio;
import org.example.pedido.Pedido;
import org.example.cardapio.Lanche;
import java.util.HashSet;
public class Main {

    public static void main(String[] args) {

        MenuConsole menu = new MenuConsole();
        RestauranteFacade restaurante = new RestauranteFacade();

        int opcao = -1;

        while (opcao != 0) {
            menu.exibirMenu();
            opcao = menu.lerOpcao();

            switch (opcao) {

                case 1 -> {
                    Pedido pedido = restaurante.criarPedido(menu.lerNomeCliente());

                    do {
                        menu.exibirCardapio();
                        int opcaoCardapio = menu.lerOpcaoLanche();

                        Lanche lanche = restaurante.criarLanche(opcaoCardapio);

                        if (lanche != null) {
                            ItemCardapio itemPersonalizado = menu.personalizarLanche(lanche);
                            pedido.adicionarItem(itemPersonalizado);

                        } else {
                            menu.exibirMensagem("Opção de lanche inválida.");
                        }

                    } while (menu.perguntarMaisItem());

                    menu.exibirPedido(pedido);
                }

                case 2 -> menu.exibirPedidos(restaurante.listarPedidos());

                case 3 -> {
                    double total = restaurante.calcularTotalDoDia();

                    HashSet<String> combinacoes = new HashSet<>();

                    for (Pedido pedido : restaurante.listarPedidos()) {
                        for (ItemCardapio item : pedido.getItens()) {
                            combinacoes.add(item.getDescricao());
                        }
                    }

                    menu.exibirFechamentoDoDia(total, combinacoes);
                    opcao = 0;
                }

                case 0 -> menu.exibirMensagem("Até logo!");

                default -> menu.exibirMensagem("Opção inválida.");
            }
        }
    }
}
