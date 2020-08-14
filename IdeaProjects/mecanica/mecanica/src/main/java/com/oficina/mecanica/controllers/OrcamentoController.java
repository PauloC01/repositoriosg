package com.oficina.mecanica.controllers;

import com.oficina.mecanica.model.Orcamento;
import com.oficina.mecanica.model.Ordem;
import com.oficina.mecanica.repositories.OrdemRepository;
import com.oficina.mecanica.services.OrcamentoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orcamento")
@AllArgsConstructor
public class OrcamentoController {
    private OrcamentoService orcamentoService;

    @PostMapping("/add")
    public ResponseEntity addOrcamento(@RequestBody Orcamento orcamento){
        return ResponseEntity.ok(this.orcamentoService.registrarOrcamento(orcamento));
    }
    @GetMapping("/list")
    public List listaOrcamento(){
        return this.orcamentoService.listaOrcamento();
    }
    @GetMapping("/{id}")
    public ResponseEntity orcamentoPorId(@PathVariable int id){
        return ResponseEntity.ok(this.orcamentoService.OrcamentoPorId(id));
    }
}
