package com.oficina.mecanica.services;

import com.oficina.mecanica.model.Carro;
import com.oficina.mecanica.repositories.CarroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarroService {
    private CarroRepository carroRepository;

    //add e update de carros
    public Carro addCarro(Carro carro) {
        return this.carroRepository.save(carro);
    }
    //lista todos os carros
    public List listaCarro() {
        return this.carroRepository.findAll();
    }
    //busca carros por id
    public Carro carroPorId(int id) {
        Optional<Carro> bCarro = this.carroRepository.findById(id);
        return bCarro.get();
    }
}
