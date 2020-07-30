package com.sg.lanchessg.RegrasdeServico.condicoesPedido;

import com.sg.lanchessg.Model.Cliente;
import com.sg.lanchessg.Model.Lanches;
import com.sg.lanchessg.Model.Pedido;
import com.sg.lanchessg.Repositories.ClientRepository;
import com.sg.lanchessg.Repositories.LancheRepository;
import com.sg.lanchessg.Repositories.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PedidoLancheCompra {
    private final PedidoRepository pedidoRepo;
    private final LancheRepository lancheRepo;
    private final ClientRepository clientRepo;

    public PedidoLancheCompra(LancheRepository lancheRepo, ClientRepository clientRepo, PedidoRepository pedidoRepo) {
        this.lancheRepo = lancheRepo;
        this.clientRepo = clientRepo;
        this.pedidoRepo = pedidoRepo;
    }

    public Lanches CompraProduto(Pedido pedido) {
        Optional<Lanches> bLanche = this.lancheRepo.findById(pedido.getProdutos().get(0).getId());
        Optional<Cliente> bCliente = this.clientRepo.findById(pedido.getId_Cliente().getId());

        if (bCliente.isPresent() && bLanche.isPresent()) {
            Lanches lanches = bLanche.get();
            if (lanches.getQntLanches() < 3) { //verificador de estoque baixo
                System.out.println("Há lanches, porém o estoque está baixo");
            }else if (lanches.getQntLanches()>3) {
                lanches.setQntLanches(lanches.getQntLanches() - pedido.getQntProdutos());
                Cliente clienteActual = bCliente.get();
                clienteActual.setPontosFidelidade(clienteActual.getPontosFidelidade() + pedido.getQntProdutos());
                System.out.println("Compra efetivada com sucesso");
                pedido.setQntProdutos(pedido.getQntProdutos() + 1);
                pedidoRepo.save(pedido);
                clientRepo.save(clienteActual);
                return lancheRepo.save(lanches);
            }
            if (lanches.getQntLanches() == 0){  //
                System.out.println("Lanche em falta no estoque !");
            }
            else if (lanches.getQntLanches() < 0) {
                System.out.println("Quantidade inválida !");
            }
        }
        return null;
    }
}
