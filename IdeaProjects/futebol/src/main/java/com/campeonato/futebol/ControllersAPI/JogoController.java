package com.campeonato.futebol.ControllersAPI;



import com.campeonato.futebol.Model.Jogos;
import com.campeonato.futebol.Repositorios.JogoRepository;
import com.campeonato.futebol.Services.ChampService;
import com.campeonato.futebol.Services.JogoServices;
import com.campeonato.futebol.Services.TimeServices;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogo")
@AllArgsConstructor
@NoArgsConstructor
public class JogoController {

    private JogoServices jogoService;
    private ChampService champService;
    private TimeServices timeServices;
    private JogoRepository jogoRepo;

    @PostMapping("/addjogo")
    public ResponseEntity addJogo(@RequestBody Jogos jogos){

        return ResponseEntity.ok(this.jogoService.addJogo(jogos));
    }
    @GetMapping("buscaJogo/{id}")
    public ResponseEntity buscaJogo(@PathVariable int id){
        return ResponseEntity.ok(this.jogoService.buscarJogo(id));
    }
    @GetMapping("listaJogo")
    public List listaJogo(Jogos jogos){
        return jogoRepo.findAll();
    }
}
