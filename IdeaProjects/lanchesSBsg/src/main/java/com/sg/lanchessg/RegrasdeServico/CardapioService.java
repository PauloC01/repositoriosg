package com.sg.lanchessg.RegrasdeServico;


import com.sg.lanchessg.Model.Combo;
import com.sg.lanchessg.Model.Lanches;
import com.sg.lanchessg.Repositories.ComboRepository;
import com.sg.lanchessg.Repositories.LancheRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class CardapioService {
     public LancheRepository lancheRepo;
     public ComboRepository comboRepo;

    public CardapioService(LancheRepository lancheRepo, ComboRepository comboRepo) {
        this.lancheRepo = lancheRepo;
        this.comboRepo = comboRepo;

    }

    @Transactional
    public ArrayList cardapio() {
        List<Combo> combos = this.comboRepo.findAll();
        List<Lanches> lanches = this.lancheRepo.findAll();
        ArrayList cardapio = new ArrayList();
        if(combos.size() != 0){
        for (Combo combo : combos) {
            if (combo.getQuantidade() > 0) {
                cardapio.add("Combo:" + combo.getId() + " " + combo.getNome()); //"Combo:" + combo.getId() + "" + combo.getNome()
            }
        }}
        for (Lanches lanche : lanches) {
            if (lanche.getQntLanches() > 0) {
                cardapio.add("Lanche:" + lanche.getId() + " " + lanche.getNome()); //"Lanche:" + lanche.getId() + "" + lanche.getNome()

            }
        }
        return cardapio;
    }
}


