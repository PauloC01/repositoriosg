package com.sg.lanchessg.ControllersAPIs;



import com.sg.lanchessg.RegrasdeServico.LancheService;
import com.sg.lanchessg.Repositories.LancheRepository;
import com.sg.lanchessg.Model.Lanches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/lanche")
public class LancheController {
    @Autowired
    LancheRepository lancheRepo;
    LancheService lancheService;

    @PostMapping("addLanche")
    public ResponseEntity<?> registraLanche(@RequestBody Lanches lanche) {
        Lanches lanchesSalvo = lancheRepo.save(lanche);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/lanche").path("/{id}").
                buildAndExpand(lanchesSalvo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("listarLanche")
    ResponseEntity<List<Lanches>> ListaLanches() {

        return ResponseEntity.ok().body(lancheRepo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lanches> buscaporId(@PathVariable Integer id){
        return ResponseEntity.ok().body(lancheRepo.findById(id).get());
    }
    @PostMapping(path = "montar/{id}")
    public ResponseEntity montarProduto(@RequestBody Lanches produtoLanchonete,@PathVariable int id){
        return ResponseEntity.ok(this.lancheService.montaLanche(produtoLanchonete,id));
    }
}
