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


    //registra o orçamento
    @Transactional
    public Orcamento registrarOrcamento(Orcamento orcamento) {
        return this.orcamentoRepository.save(orcamento);
    }

    //lista orçamentos
    @Transactional
    public List listaOrcamento() {
        return this.orcamentoRepository.findAll();
    }

    //busca orçamentos por id
    @Transactional
    public Orcamento OrcamentoPorId(int id) {
        Optional<Orcamento> bOrcamento = orcamentoRepository.findById(id);
        return bOrcamento.get();
    }

    //deleta orcamentos, mas somente utilizado no metodo para efetivar
    // o orcamento para uma ordem de serviço
    @Transactional
    public void deletaOrcamento(int id){
         orcamentoRepository.deleteById(id);
    }


    //valida o status do orcamento, se estiver em analise ele não fará nada, se for rejeitado,
    //se for rejeitado será excluida, e se for aprovado será efetivada para uma OS de facto
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
