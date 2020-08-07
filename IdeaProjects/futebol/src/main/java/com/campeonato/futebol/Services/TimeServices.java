package com.campeonato.futebol.Services;

import com.campeonato.futebol.Model.Time;
import com.campeonato.futebol.Repositorios.TimeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class TimeServices {
    public TimeRepository timeRepo;

    @Transactional
    public Time adicionaTime(Time time){
        return this.timeRepo.save(time);  //Metodo adicionar um time
    }
    public List listaTime(Time time) {
        return timeRepo.findAll();
    }
    public Time buscarTime(int id){
        Optional<Time> bTime = this.timeRepo.findById(id);

        if (bTime.isPresent()){
            return bTime.get();
        }
        return null;
    }


}
