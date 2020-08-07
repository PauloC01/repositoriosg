package com.campeonato.futebol.ControllersAPI;


import com.campeonato.futebol.Services.ColocacaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "colocacoes")
@AllArgsConstructor
public class ColocacaoController {
    private ColocacaoService colocacaoService;

   @GetMapping(path = "/colocacao/{idC}")
   public ResponseEntity buscaColocacao(@PathVariable int idC){
       return  ResponseEntity.ok(this.colocacaoService.buscaId(idC));
   }

}
