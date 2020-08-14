package com.oficina.mecanica.controllers;


import com.oficina.mecanica.model.Orcamento;
import com.oficina.mecanica.model.Ordem;
import com.oficina.mecanica.repositories.OrcamentoRepository;
import com.oficina.mecanica.repositories.OrdemRepository;
import com.oficina.mecanica.services.OrcamentoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ordemServico")
@AllArgsConstructor
public class OrdemController extends Ordem {
    private final OrdemRepository ordemRepository;
    private final OrcamentoService orcamentoService;
    private final OrcamentoRepository orcamentoRepository;

    @PostMapping("/efetivar")
    public ResponseEntity efeticarOrcamento(@RequestBody Ordem ordem,@RequestParam  int orcamento, @RequestParam int status) {
            return ResponseEntity.ok(this.orcamentoService.efetivarOrcamento(orcamento, ordem, status));
    }
}
