package com.oficina.mecanica.services;

import com.oficina.mecanica.model.Orcamento;
import com.oficina.mecanica.model.Ordem;
import com.oficina.mecanica.repositories.OrcamentoRepository;
import com.oficina.mecanica.repositories.OrdemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrcamentoService {
    private OrcamentoRepository orcamentoRepository;
    private OrdemRepository ordemRepository;

    @Transactional
    public Orcamento registrarOrcamento(Orcamento orcamento) {
        return this.orcamentoRepository.save(orcamento);
    }

    @Transactional
    public List listaOrcamento() {
        return this.orcamentoRepository.findAll();
    }

    @Transactional
    public Orcamento OrcamentoPorId(int id) {
        Optional<Orcamento> bOrcamento = orcamentoRepository.findById(id);
        return bOrcamento.get();
    }
    @Transactional
    public void deletaOrcamento(int id){
         orcamentoRepository.deleteById(id);
    }

    @Transactional
    public Ordem efetivarOrcamento(int orcamento, Ordem ordem, int status) {
       switch (status){
           case 0:
               System.out.println("Aprovado pelo cliente");
               return ordemRepository.save(ordem);
           case 1:
               System.out.println("Rejeitado pelo cliente");
               deletaOrcamento(ordem.getId());
                break;
           case 2:
               System.out.println("Ainda em analise pelo cliente");
       }
        return ordem;
    }

}
