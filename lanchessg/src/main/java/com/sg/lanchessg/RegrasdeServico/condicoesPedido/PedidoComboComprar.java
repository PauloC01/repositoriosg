package com.sg.lanchessg.RegrasdeServico.condicoesPedido;

import com.sg.lanchessg.Model.Cliente;
import com.sg.lanchessg.Model.Combo;
import com.sg.lanchessg.Model.Pedido;
import com.sg.lanchessg.Repositories.ClientRepository;
import com.sg.lanchessg.Repositories.ComboRepository;
import com.sg.lanchessg.Repositories.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoComboComprar {
    private final PedidoRepository pedidoRepo;
    private final ClientRepository clienteRepo;
    private final ComboRepository comboRepo;

    public PedidoComboComprar(PedidoRepository pedidoRepo, ClientRepository clienteRepo, ComboRepository comboRepo) {
        this.pedidoRepo = pedidoRepo;
        this.clienteRepo = clienteRepo;
        this.comboRepo = comboRepo;
    }

    public Combo compraCombo(Pedido pedido) {
        Optional<Combo> bCombo = this.comboRepo.findById(pedido.getCombos().get(0).getId());
        Optional<Cliente> bCliente = clienteRepo.findById(pedido.getId_Cliente().getId());
        if (bCliente.isPresent() && bCombo.isPresent()) {
            Combo combo = bCombo.get();
            if (combo.getQuantidade() < 2) {
                System.out.println("Nível de estoque de" + combo.getNome() + " baixo");
            } else if (combo.getQuantidade() > 3) {
                combo.setQuantidade(combo.getQuantidade() - pedido.getQntCombos());
                Cliente clienteActual = bCliente.get();
                clienteActual.setPontosFidelidade(pedido.getQntProdutos() + pedido.getQntCombos());
                System.out.println("Compra Realizada");
                pedido.setQntCombos(pedido.getQntCombos() + 1);
                pedidoRepo.save(pedido);
                clienteRepo.save(clienteActual);
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

