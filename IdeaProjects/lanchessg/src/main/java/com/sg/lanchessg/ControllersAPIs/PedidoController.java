package com.sg.lanchessg.ControllersAPIs;

import com.sg.lanchessg.Model.Pedido;
import com.sg.lanchessg.RegrasdeServico.PedidoServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
@AllArgsConstructor
@RestController
@RequestMapping(path= "/pedidos")
public class PedidoController {
@Autowired
    private PedidoServices pedidoServices;
    public PedidoController(){}

    @PostMapping(path="add/{idTipoPedido}")    //id = 1 para lanches normais id = 2 para combos; front vai mostrar as opções.
    public ResponseEntity fazerPedido(@PathVariable byte idTipoPedido, @RequestBody Pedido pedido){
        return ResponseEntity.ok(this.pedidoServices.fazerPedido(idTipoPedido,pedido));
    }
    @GetMapping(path = "listaPedidos/{idP}")
    public ArrayList listaPedidos(@PathVariable int idP){
        return this.pedidoServices.listaPedidos(idP); //metodo Listagem de pedidos
    }
}
