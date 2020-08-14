package com.oficina.mecanica.controllers;

import com.oficina.mecanica.model.Carro;
import com.oficina.mecanica.services.CarroService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/carro")
public class CarroController {
    private CarroService carroService;

    @PostMapping("/registrar")
    public ResponseEntity registrarCarro(@RequestBody Carro carro){
        return ResponseEntity.ok(this.carroService.addCarro(carro));
    }
    @GetMapping("/list")
    public ResponseEntity listaCarros(@RequestBody Carro carro){
        return ResponseEntity.ok(this.carroService.listaCarro());
    }
    @GetMapping("/{id}")
    public ResponseEntity carroPorId(@PathVariable int id){
        return ResponseEntity.ok(carroService.carroPorId(id));
    }

}
