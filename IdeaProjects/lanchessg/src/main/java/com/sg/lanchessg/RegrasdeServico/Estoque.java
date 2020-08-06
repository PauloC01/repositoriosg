package com.sg.lanchessg.RegrasdeServico;

import com.sg.lanchessg.Model.Combo;
import com.sg.lanchessg.Model.Ingredientes;
import com.sg.lanchessg.Model.Lanches;
import com.sg.lanchessg.Model.Produtos;
import com.sg.lanchessg.Repositories.ComboRepository;
import com.sg.lanchessg.Repositories.IngRepository;
import com.sg.lanchessg.Repositories.LancheRepository;
import com.sg.lanchessg.Repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service //classe que contém regras, logica. ao invés de jogar essa responsabilidade para a API.
@AllArgsConstructor
public class Estoque {
    private final ComboRepository comboRepository;
    private final IngRepository ingRepository;
    private final LancheRepository lancheRepository;

    @Transactional //Mostra que essa parte do codigo só fara mundaças no DB se for completada com exito.
    public String listarEstoque() {
        List<Ingredientes> ingredientes = this.ingRepository.findAll();
        List<Combo> combos = this.comboRepository.findAll();
        List<Lanches> lanches =  this.lancheRepository.findAll();
        String join;
        int t = 0;
        ArrayList<String> estoque = new ArrayList();
        for (Combo combo : combos) {
            if (combo.getQuantidade() < 1) {
                estoque.add(combo.getNome());
            }}
            for (Ingredientes ingrediente : ingredientes) {
                if (ingrediente.getQuantidadeIng() < 1) {
                    estoque.add(ingrediente.getNome());
                }
            }
            for(Lanches lanche:lanches){
                if(lanche.getQntLanches()<1){
                    estoque.add(lanche.getNome());
                }
            }
            for (int i = 0; i < estoque.size(); i++) {
                t++;
            }
            join = String.join(",", estoque);
            estoque.add("Total de itens em falta: " + t + "" + join);
            String ultimaPosicao = estoque.get(estoque.size() - 1);

            return ultimaPosicao;
    }
}




