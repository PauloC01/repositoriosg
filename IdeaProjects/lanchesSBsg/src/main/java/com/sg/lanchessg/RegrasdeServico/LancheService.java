package com.sg.lanchessg.RegrasdeServico;

import com.sg.lanchessg.Model.Ingredientes;
import com.sg.lanchessg.Model.Lanches;
import com.sg.lanchessg.Repositories.IngRepository;
import com.sg.lanchessg.Repositories.LancheRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LancheService {
    private final LancheRepository lancheRepository;
    private final IngRepository ingRepository;

    @Transactional
    public Lanches montaLanche(Lanches lanches, int id) {
        Optional<Lanches> bLanches = lancheRepository.findById(id);
        if (bLanches.isPresent()) {
            for (int i = 0; i < lanches.getIngredientes().size(); i++) {
                Optional<Ingredientes> bIngredientes = ingRepository.findById(bLanches.get().
                        getIngredientes().get(i).getId());
                if (bIngredientes.get().getQuantidadeIng() > 1) {
                    if (bIngredientes.get().getQuantidadeIng() < 3 && bIngredientes.get().getQuantidadeIng() > 0 ) {
                        Ingredientes ingredientes = bIngredientes.get();
                        ingredientes.setQuantidadeIng(ingredientes.getQuantidadeIng() - 1); //faz o lanche
                        System.out.println("Estoque de ingredientes baixo");    //adverte que o estoque de ingredientes esta baixo
                    } else if (bIngredientes.get().getQuantidadeIng() > 3) {
                        Ingredientes ingredientes = bIngredientes.get();
                        ingredientes.setQuantidadeIng(ingredientes.getQuantidadeIng() - 1);  //retira ingrediente do estoque
                    } else {
                        System.out.println("Número de estoque inválido !");
                    }
                    Lanches lanche = bLanches.get();
                    lanche.setQntLanches(lanche.getQntLanches() + 1); //adiciona um lanche pro banco de lanches
                } else {
                    System.out.println(lanches.getId() + "Não possui ingredientes suficientes");
                }
            }
        }
        return lanches;
    }
}


