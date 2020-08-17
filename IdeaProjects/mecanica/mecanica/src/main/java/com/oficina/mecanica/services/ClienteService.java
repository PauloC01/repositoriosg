package com.oficina.mecanica.services;

import com.oficina.mecanica.model.Cliente;
import com.oficina.mecanica.repositories.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteService {
    ClienteRepository clienteRepository;
    //add e update de clientes
    @Transactional
    public Cliente addCliente(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }
    //traz lista de clientes completa
    @Transactional
    public List listaClientes() {
        return this.clienteRepository.findAll();
    }

    //busca cliente por id
    @Transactional
    public Cliente ClientePorId(int id) {
        Optional<Cliente> bCliente = this.clienteRepository.findById(id);
        return bCliente.get();
    }
}
