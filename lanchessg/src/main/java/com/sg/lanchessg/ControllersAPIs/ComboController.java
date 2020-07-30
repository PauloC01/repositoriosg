package com.sg.lanchessg.ControllersAPIs;

import com.sg.lanchessg.Model.Combo;
import com.sg.lanchessg.Repositories.ComboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/combosDisponives")
public class ComboController {
    @Autowired
    ComboRepository comboRepo;

    @PostMapping("/novosCombos")
    public ResponseEntity<?> adicionaCombos(@RequestBody Combo combo) {
        Combo comboSalvo = comboRepo.save(combo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/combosDisponiveis").path("{id}").
                buildAndExpand(comboSalvo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @GetMapping
    public ResponseEntity<List<Combo>> listaCombos(){
        return ResponseEntity.ok().body(comboRepo.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Combo> buscaComboId(@PathVariable Integer id){
        return ResponseEntity.ok().body(comboRepo.findById(id).get());

    }

}
