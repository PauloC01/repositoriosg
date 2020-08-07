package com.campeonato.futebol.Services;


import com.campeonato.futebol.Model.Jogos;
import com.campeonato.futebol.Repositorios.JogoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class JogoServices {
    private JogoRepository jogoRepo;

    @Transactional
    public Jogos addJogo(Jogos jogos){

        return this.jogoRepo.save(jogos);
    }


    @Transactional
    public List<Jogos> listaJogos(Jogos jogos){

        return jogoRepo.findAll();
    }

    @Transactional
    public Jogos buscarJogo(int id){
        Optional<Jogos> bJogo = this.jogoRepo.findById(id);
                    if(bJogo.isPresent()){
                        return bJogo.get(); }
                    return null;
    }



}
