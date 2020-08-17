package com.oficina.mecanica.services;

import com.oficina.mecanica.model.Funcionario;
import com.oficina.mecanica.repositories.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FuncionarioService {
    private FuncionarioRepository funcionarioRepository;

    //add e update  de clientes
    public Funcionario addFuncionario(Funcionario funcionario) {
        return this.funcionarioRepository.save(funcionario);
    }

    //lista todos os clientes
    public List listarFuncionarios() {
        return this.funcionarioRepository.findAll();
    }

    //busca cliente por id
    public Funcionario funcionarioPorId(int id) {
        Optional<Funcionario> bFuncionarios = this.funcionarioRepository.findById(id);
        return bFuncionarios.get();
    }
}
