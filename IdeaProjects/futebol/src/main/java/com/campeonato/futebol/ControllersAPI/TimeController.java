package com.campeonato.futebol.ControllersAPI;

import com.campeonato.futebol.Model.Time;
import com.campeonato.futebol.Repositorios.TimeRepository;
import com.campeonato.futebol.Services.TimeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/times")
public class TimeController {
    @Autowired
    public TimeServices timeServices;
    public TimeRepository timeRepo;

    @PostMapping("/addTime")
    public ResponseEntity<?> adicionaTime(@RequestBody Time time){
        Time timeSalvo = timeServices.adicionaTime(time);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().replacePath("/lanche").path("/{id}").
                buildAndExpand(timeSalvo.getId_time()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @GetMapping("/listaTimes")
    public List<?> listaTime(Time time){
        return timeRepo.findAll();
    }

    @GetMapping(path = "buscaTime/{id}")
    public ResponseEntity buscaTime(int id){
        return ResponseEntity.ok(this.timeServices.buscarTime(id));
    }
}
