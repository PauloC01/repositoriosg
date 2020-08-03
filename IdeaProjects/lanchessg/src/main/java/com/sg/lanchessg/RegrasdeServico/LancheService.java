package com.sg.lanchessg.RegrasdeServico;

import com.sg.lanchessg.Model.Ingredientes;
import com.sg.lanchessg.Model.Lanches;
import com.sg.lanchessg.Repositories.IngRepository;
import com.sg.lanchessg.Repositories.LancheRepository;

import javax.transaction.Transactional;
import java.util.Optional;

public class LancheService {
    private final LancheRepository lancheRepository;
    private final IngRepository ingRepository;

    public LancheService(LancheRepository lancheRepository, IngRepository ingRepository) {
        this.lancheRepository = lancheRepository;
        this.ingRepository = ingRepository;
    }

    @Transactional
    public Lanches montagemLanche(Lanches lanches, int id) {
        Optional<Lanches> bLanches = lancheRepository.findById(id);
        if (bLanches.isPresent()) {
            for (int i = 0; i < lanches.getIngredientes().size(); i++) {
                Optional<Ingredientes> bIngredientes = ingRepository.findById(bLanches.get().
                        getIngredientes().get(i).getId());
                if (lanches.getIngredientes().size() > 0) {
                    if (bIngredientes.get().getQuantidadeIng() >= 1) {
                    } else if (bIngredientes.get().getQuantidadeIng() < 4) {
                        Ingredientes ingredientes = bIngredientes.get();
                        ingredientes.setQuantidadeIng(ingredientes.getQuantidadeIng() - 1); //faz o lanche, mas adverte que o estoque de ingredientes esta baixo
                        System.out.println("Estoque de ingredientes baixo");
                    } else if (bIngredientes.get().getQuantidadeIng() > 4) {
                        Ingredientes ingredientes = bIngredientes.get();
                        ingredientes.setQuantidadeIng(ingredientes.getQuantidadeIng() - 1);  //para fazer umm lanche e retirar um ingrediente do estoque
                    } else {
                        System.out.println("Estoque zerado!\n Contate o fornecedor o mais rápido possível");
                    }

                    Lanches lanche = bLanches.get();
                    lanche.setQntLanches(lanche.getQntLanches() + 1);
                } else {
                    System.out.println(lanches.getId() + "Não possui ingredientes suficientes");
                }
            }

        }
        return lanches;
    }
}


