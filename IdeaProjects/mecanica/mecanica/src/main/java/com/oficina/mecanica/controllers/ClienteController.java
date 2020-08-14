package com.oficina.mecanica.controllers;

import com.oficina.mecanica.model.Cliente;
import com.oficina.mecanica.services.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cliente")
@AllArgsConstructor
public class ClienteController {
    ClienteService clienteService;

    @GetMapping("/lista")
    public ResponseEntity listaClientes(@RequestBody Cliente cliente){
        return ResponseEntity.ok(this.clienteService.listaClientes());
    }

    @PostMapping("/add")
    public ResponseEntity addcliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok(this.clienteService.addCliente(cliente));
    }
    @GetMapping("/{id}")
    public ResponseEntity  ClientePoriD(@PathVariable int id_cliente){
        return ResponseEntity.ok(this.clienteService.ClientePorId(id_cliente));
    }
}
