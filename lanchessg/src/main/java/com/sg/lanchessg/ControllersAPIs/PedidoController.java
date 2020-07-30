package com.sg.lanchessg.ControllersAPIs;

import com.sg.lanchessg.Model.Pedido;
import com.sg.lanchessg.RegrasdeServico.PedidoServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path= "/pedido")
public class PedidoController {
    private final PedidoServices pedidoServices;

    public PedidoController(PedidoServices pedidoServices) {
        this.pedidoServices = pedidoServices;
    }
    @PostMapping(path="/pedir/{idTipoPedido}")
    public ResponseEntity fazerPedido(@PathVariable byte idTipoPedido, @RequestBody Pedido pedido){
        return ResponseEntity.ok(this.pedidoServices.realizarPedido(idTipoPedido,pedido));
    }
}
