package com.sg.lanchessg.RegrasdeServico;


import com.sg.lanchessg.Model.Combo;
import com.sg.lanchessg.Model.Lanches;
import com.sg.lanchessg.Repositories.ComboRepository;
import com.sg.lanchessg.Repositories.LancheRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class CardapioService {
    private final LancheRepository lancheRepo;
    private final ComboRepository comboRepo;
    private final CardapioService cardapioService;


    public CardapioService(LancheRepository lancheRepo, ComboRepository comboRepo, CardapioService cardapioService) {
        this.lancheRepo = lancheRepo;
        this.comboRepo = comboRepo;
        this.cardapioService = cardapioService;
    }

    @Transactional
    public ArrayList cardapio() {
        List<Combo> combos = this.comboRepo.findAll();
        List<Lanches> lanches = this.lancheRepo.findAll();
        ArrayList cardapio = new ArrayList();
        for (Combo combo : combos) {
            if (combo.getQuantidade() > 0) {
                cardapio.add("Combo:" + combo.getId() + "" + combo.getNome());
            }
        }
        for (Lanches lanche : lanches) {
            if (lanche.getQntLanches() > 0) {
                cardapio.add("Lanche:" + lanche.getId() + "" + lanche.getNome());

            }
        }
        return cardapio;
    }
}


