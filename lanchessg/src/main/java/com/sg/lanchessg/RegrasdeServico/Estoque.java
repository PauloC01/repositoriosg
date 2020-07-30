package com.sg.lanchessg.RegrasdeServico;

import com.sg.lanchessg.Model.Combo;
import com.sg.lanchessg.Model.Ingredientes;
import com.sg.lanchessg.Model.Lanches;
import com.sg.lanchessg.Model.Produtos;
import com.sg.lanchessg.Repositories.ComboRepository;
import com.sg.lanchessg.Repositories.IngRepository;
import com.sg.lanchessg.Repositories.LancheRepository;
import com.sg.lanchessg.Repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.join;

@Service //marcou essa classe como uma provedora de serviços, ou simplesmente uma classe que contém regras.
public class Estoque {
    private final ComboRepository comboRepository;
    private final ProdutoRepository produtoRepository;
    private final IngRepository ingRepository;
    private final LancheRepository lancheRepository;

    public Estoque(ComboRepository comboRepository, ProdutoRepository produtoRepository, IngRepository ingRepository, LancheRepository lancheRepository) {
        this.comboRepository = comboRepository;             //Método construtor para o combo, ingredientes,
        this.ingRepository = ingRepository;                 //e produto.
        this.produtoRepository = produtoRepository;
        this.lancheRepository = lancheRepository;
    }

    @Transactional //Mostra que essa parte do codigo só fara mundaças no DB se for completada com exito.
    public String listarEstoque0() {
        List<Ingredientes> ingredientes = this.ingRepository.findAll();
        List<Produtos> produtos = this.produtoRepository.findAll();
        List<Combo> combos = this.comboRepository.findAll();
        List<Lanches> lanches =  this.lancheRepository.findAll();
        String join;
        int tot = 0;
        ArrayList<String> estoque = new ArrayList();
        for (Combo combo : combos) {
            if (combo.getQuantidade() < 1) {
                estoque.add(combo.getNome());
            }}
            for (Produtos produto : produtos) {
                if (produto.getQntProdutos() < 1) {
                    estoque.add(produto.getNome());
                }
            }
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
                tot++;
            }
            join = String.join(",", estoque);
            estoque.add("Total de itens em falta: " + tot + "" + join);
            String ultimaPosicao = estoque.get(estoque.size() - 1);

            return ultimaPosicao;
    }
}




