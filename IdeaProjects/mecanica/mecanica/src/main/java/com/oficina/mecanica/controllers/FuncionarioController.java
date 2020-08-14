package com.oficina.mecanica.controllers;

import com.oficina.mecanica.model.Funcionario;
import com.oficina.mecanica.services.FuncionarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionario")
@AllArgsConstructor
public class FuncionarioController {
    FuncionarioService funcionarioService;

    @PostMapping("/add")//também faz update
    public ResponseEntity addFuncionario(@RequestBody Funcionario funcionario){
        return  ResponseEntity.ok(funcionarioService.addFuncionario(funcionario));
    }
    @GetMapping("/lista")
    public ResponseEntity listaFuncionarios(@RequestBody Funcionario funcionario){
        return ResponseEntity.ok(this.funcionarioService.listarFuncionarios());
    }
    @GetMapping("/{id}")
    public ResponseEntity funcionarioPorId(@PathVariable int id){
        return ResponseEntity.ok(funcionarioService.funcionarioPorId(id));
    }

}
