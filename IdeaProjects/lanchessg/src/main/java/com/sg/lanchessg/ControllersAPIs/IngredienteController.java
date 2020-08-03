package com.sg.lanchessg.ControllersAPIs;



import com.sg.lanchessg.Model.Ingredientes;
import com.sg.lanchessg.Repositories.IngRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ingredientes")
public class IngredienteController {

    @Autowired
    IngRepository ingRepo;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?>adicionaIngrediente(@RequestBody Ingredientes ingrediente) {
            Ingredientes ingredienteSalvo = ingRepo.save(ingrediente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/ingredientes").path("/{id}").
                buildAndExpand(ingredienteSalvo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

@GetMapping
public ResponseEntity<List<Ingredientes>> listaIngredientes() {

        return ResponseEntity.ok().body(ingRepo.findAll());
}

@GetMapping("/{id}")
    public ResponseEntity<Ingredientes> buscaporId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(ingRepo.findById(id).get());
    }
    @GetMapping("listaIngredientes")
    public List<Ingredientes> listarIngrediente(){
        return this.ingRepo.findAll();
    }

}


