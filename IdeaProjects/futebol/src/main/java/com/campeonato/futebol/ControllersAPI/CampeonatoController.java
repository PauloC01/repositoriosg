package com.campeonato.futebol.ControllersAPI;

import com.campeonato.futebol.Model.Campeonato;
import com.campeonato.futebol.Model.Jogos;
import com.campeonato.futebol.Repositorios.ChampRepository;
import com.campeonato.futebol.Services.ChampService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "campeonato")
@AllArgsConstructor
@NoArgsConstructor
public class CampeonatoController {   //adiciona, busca a lista, e por id.
    private ChampService champService;
    private ChampRepository champRepo;

    @PostMapping("/addCamp")
    public ResponseEntity addChamp(@RequestBody Campeonato champ){

        return ResponseEntity.ok(this.champService.addChamp(champ));
    }
    @GetMapping("buscaCamp/{id}")
    public ResponseEntity buscaChamp(@PathVariable int id){
        return ResponseEntity.ok(this.champService.buscaChamp(id));
    }
    @GetMapping("listaCamp")
    public List listaChamp(Campeonato champ){
        return champRepo.findAll();
    }
}
