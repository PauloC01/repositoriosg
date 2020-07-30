package com.sg.lanchessg.RegrasdeServico;


import com.sg.lanchessg.Model.Pedido;
import com.sg.lanchessg.RegrasdeServico.condicoesPedido.PedidoComboComprar;
import com.sg.lanchessg.RegrasdeServico.condicoesPedido.PedidoLancheCompra;
import com.sg.lanchessg.Repositories.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service// Classe com a logica de pedidos
public class PedidoServices {
    private final PedidoRepository pedidoRepo;
    private final LancheRepository lancheRepo;
    private final ComboRepository  comboRepo;
    private final ClientRepository clientRepo;


    public PedidoServices(PedidoRepository pedidoRepo, LancheRepository lancheRepo, ComboRepository comboRepo, ClientRepository clientRepo) {
        this.pedidoRepo = pedidoRepo;
        this.lancheRepo = lancheRepo;                //Contrutor dos metodos
        this.comboRepo = comboRepo;
        this.clientRepo = clientRepo;
    }
@Transactional
public Pedido realizarPedido(int tipoPedido,Pedido pedido){
    if (tipoPedido == 1){

        for (int i = 0; i < pedido.getProdutos().size(); i++) {
            PedidoLancheCompra pedidoLancheCompra = new PedidoLancheCompra(lancheRepo, clientRepo, pedidoRepo );
            pedidoLancheCompra.CompraProduto(pedido);

        }
    }else if (tipoPedido == 2){
        for (int i = 0; i < pedido.getCombos().size(); i++) {
            PedidoComboComprar pedidoComboComprar = new PedidoComboComprar(pedidoRepo, clientRepo, comboRepo);
            pedidoComboComprar.compraCombo(pedido);
        }
    }
    return pedido;
}
}


