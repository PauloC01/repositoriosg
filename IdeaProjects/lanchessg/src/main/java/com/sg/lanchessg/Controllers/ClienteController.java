package com.sg.lanchessg.Controllers;


import com.sg.lanchessg.Model.Cliente;
import com.sg.lanchessg.Repositories.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController //isso define que é um controlador rest
@RequestMapping("/cliente") //define um endpoint desse recurso, que no caso é /cliente
public class    ClienteController {
    @Autowired
    ClientRepository clientRepo;

    @PostMapping
    //Essa anotação foi utilizada para dizer que o metodo adicionaCliente se refere a um POST HTTP
    public ResponseEntity<?> adicionaCliente(@RequestBody Cliente cliente) { //representa o objeto que vai no corpo da requisição

        Cliente clienteSalvo = clientRepo.save(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/cliente").path("/{id}").
                buildAndExpand(clienteSalvo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listaClientes() {
        return ResponseEntity.ok().body(clientRepo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscaporId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(clientRepo.findById(id).get());
    }
}
