package com.campeonato.futebol.Services;

import com.campeonato.futebol.Model.Campeonato;
import com.campeonato.futebol.Model.Jogos;
import com.campeonato.futebol.Repositorios.ChampRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ChampService {
    private ChampRepository champRepo;

    @Transactional
    public Campeonato addChamp(Campeonato champ){
        return this.champRepo.save(champ);
    }
    @Transactional
    public List<Campeonato> listaChamps(Campeonato champs){
        return champRepo.findAll();
    }
    public Campeonato buscaChamp(int id){
        Optional<Campeonato> bChamp = this.champRepo.findById(id);
        if(bChamp.isPresent()&& bChamp != null){
            return bChamp.get();
        }
        return null;
    }
}

