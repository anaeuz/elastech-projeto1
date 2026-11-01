
package org.example.pedido;

import org.example.cardapio.ItemCardapio;
import java.util.ArrayList;

public class Pedido {

    private int numeroPedido;
    private String nomeCliente;
    private ArrayList<ItemCardapio> itens;

    public Pedido(int numero, String nomeCliente) {
        this.numeroPedido = numero;
        setNomeCliente(nomeCliente);
        this.itens = new ArrayList<>();
    }

    public void setNomeCliente(String nomeCliente) {
        if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do cliente não pode ser vazio.");
        }
        this.nomeCliente = nomeCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void adicionarItem(ItemCardapio item) {
        itens.add(item);
    }

    public int getNumero() {
        return numeroPedido;
    }

    public ArrayList<ItemCardapio> getItens() {
        return itens;
    }

    public double calcularTotal() {
        double total = 0;

        for (ItemCardapio item : itens) {
            total += item.getPreco();
        }

        return total;
    }
}
