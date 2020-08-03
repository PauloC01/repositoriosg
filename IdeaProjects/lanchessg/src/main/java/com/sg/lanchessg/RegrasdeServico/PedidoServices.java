package com.sg.lanchessg.RegrasdeServico;

import com.sg.lanchessg.Model.Cliente;
import com.sg.lanchessg.Model.Combo;
import com.sg.lanchessg.Model.Lanches;
import com.sg.lanchessg.Model.Pedido;
import com.sg.lanchessg.Repositories.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Service // Classe com a logica de pedidos
public class PedidoServices {
    public PedidoRepository pedidoRepo;
    public LancheRepository lancheRepo;
    public ComboRepository comboRepo;
    public ClientRepository clientRepo;


    @Transactional
    public Pedido fazerPedido(int tipoPedido, Pedido pedido) {
        if (tipoPedido == 1) {
            for (int i = 0; i < pedido.getLanches().size(); i++) {
                PedidoServices pedidoLancheCompra = new PedidoServices(pedidoRepo, lancheRepo, comboRepo, clientRepo);
                pedidoLancheCompra.CompraLanche(pedido);
            }
        } else if (tipoPedido == 2) {
            for (int i = 0; i < pedido.getCombos().size(); i++) {
                PedidoServices pedidoComboComprar = new PedidoServices(pedidoRepo, lancheRepo, comboRepo, clientRepo);
                pedidoComboComprar.compraCombo(pedido);
            }
        }else{
            System.out.println("Id de pedido quebrada !");
        }
        return pedido;
    }

    @Transactional
    public ArrayList<String> listaPedidos(int id) {
        List<Pedido> pedidos = this.pedidoRepo.findAll();
        ArrayList<String> pedidoCliente = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getId_Cliente().getId() == id) {
                for (int i = 0; i < pedido.getCombos().size(); i++) {
                    pedidoCliente.add(pedido.getCombos() + "Quantidade" + pedido.getQntCombos());
                }
                for (int i = 0; i < pedido.getLanches().size(); i++) {
                    pedidoCliente.add(pedido.getQntLanches() + "Quantidade" + pedido.getLanches());
                }
            } else {
                System.out.println("Cliente não encontrado");
            }
        }
        return pedidoCliente;
    }

    public Lanches CompraLanche(Pedido pedido) {
        Optional<Lanches> bLanche = this.lancheRepo.findById(pedido.getLanches().get(0).getId());
        Optional<Cliente> bCliente = this.clientRepo.findById(pedido.getId_Cliente().getId());
        if (bCliente.isPresent() && bLanche.isPresent()) {
            Lanches lanches = bLanche.get();
            if (lanches.getQntLanches() < 3) { //verificador de estoque baixo
                System.out.println("Há lanches, porém o estoque está baixo");
            } else if (lanches.getQntLanches() > 3) {
                lanches.setQntLanches(lanches.getQntLanches() - pedido.getQntLanches());
                Cliente clienteActual = bCliente.get();
                clienteActual.setPontosFidelidade(clienteActual.getPontosFidelidade() + pedido.getQntLanches());
                System.out.println("Compra efetivada com sucesso");
                pedido.setQntLanches(pedido.getQntLanches() + 1);
                pedidoRepo.save(pedido);
                clientRepo.save(clienteActual);
                return lancheRepo.save(lanches);
                                                     }
            if (lanches.getQntLanches() == 0) {  //
                System.out.println("Lanche em falta no estoque !");
            } else if (lanches.getQntLanches() < 0) {
                System.out.println("Quantidade inválida !"); }
        }
        return null;
    }

    public Combo compraCombo(Pedido pedido) {
        Optional<Combo> bCombo = this.comboRepo.findById(pedido.getCombos().get(0).getId());
        Optional<Cliente> bCliente = clientRepo.findById(pedido.getId_Cliente().getId());
        if (bCliente.isPresent() && bCombo.isPresent()) {
            Combo combo = bCombo.get();
            if (combo.getQuantidade() < 2) {
                System.out.println("Nível de estoque de" + combo.getNome() + " baixo");
            } else if (combo.getQuantidade() > 3) {
                combo.setQuantidade(combo.getQuantidade() - pedido.getQntCombos());
                Cliente clienteActual = bCliente.get();
                clienteActual.setPontosFidelidade(pedido.getQntLanches() + pedido.getQntCombos());
                System.out.println("Compra Realizada");
                pedido.setQntCombos(pedido.getQntCombos() + 1);
                pedidoRepo.save(pedido);
                clientRepo.save(clienteActual);
                return comboRepo.save(combo);
            } else if (combo.getQuantidade() == 0) {
                System.out.println("Combo em falta !");
            } else if (combo.getQuantidade() < 0) {
                System.out.println("Quantidade Inválida !");
            }
        }
        return null;
    }
}


