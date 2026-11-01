
package org.example.app;

import org.example.pedido.GerenciadorPedidos;
import org.example.pedido.Pedido;
import org.example.cardapio.Lanche;
import org.example.cardapio.LancheFactory;
import java.util.Collection;

public class RestauranteFacade {

    private GerenciadorPedidos gerenciador = new GerenciadorPedidos();

    public Pedido criarPedido(String nomeCliente) {
        return gerenciador.criarPedido(nomeCliente);
    }

    public Collection<Pedido> listarPedidos() {
        return gerenciador.getPedidos();
    }

    public double calcularTotalDoDia() {
        return gerenciador.calcularTotalDoDia();
    }

    public Lanche criarLanche(int opcao) {
        if (opcao == 1) {
            return LancheFactory.xBurger();
        } else if (opcao == 2) {
            return LancheFactory.xSalada();
        } else if (opcao == 3) {
            return LancheFactory.xBacon();
        }

        return null;
    }
}
