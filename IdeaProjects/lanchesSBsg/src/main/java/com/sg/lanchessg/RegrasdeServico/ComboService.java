package com.sg.lanchessg.RegrasdeServico;

import com.sg.lanchessg.Model.Combo;
import com.sg.lanchessg.Model.Lanches;
import com.sg.lanchessg.Repositories.ComboRepository;
import com.sg.lanchessg.Repositories.LancheRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class ComboService {
    private final ComboRepository comboRepo;
    private final LancheRepository lancheRepo;

    public ComboService(ComboRepository comboRepo, LancheRepository lancheRepo) {
        this.comboRepo = comboRepo;
        this.lancheRepo = lancheRepo;
    }
    @Transactional
    public Combo montarCombo(int id, Combo combo){
        Optional<Combo> bCombo = this.comboRepo.findById(id);
        if(bCombo.isPresent()){
            for (int i = 0; i < combo.getProdutos().size(); i ++){
                Optional<Lanches> bLanche = this.lancheRepo.findById(id);
                if (bLanche.get().getQntLanches() < 3 && bLanche.get().getQntLanches() > 1){
                    System.out.println("Poucos lanches disponíveis !");
                    Lanches lanche = bLanche.get();
                    lanche.setQntLanches(lanche.getQntLanches() - 1);
                    lancheRepo.save(lanche);
                }else if (bLanche.get().getQntLanches() > 3){
                    Lanches lanche = bLanche.get();
                    lanche.setQntLanches(lanche.getQntLanches() - 1);
                }else{
                    System.out.println("Sem lanches disponíveis !");
                }
            }
            Combo combosFeitos = bCombo.get();
            combosFeitos.setQuantidade(combosFeitos.getQuantidade() + 1);
        }else{ return combo; }
        return combo;
    }
    public Combo addCombo(Combo combo){
        return this.comboRepo.save(combo);   //metodo salva o combo.
    }
    @Transactional
    public void delCombo(int id, Combo combo){
         this.comboRepo.delete(combo);          //deleta combo.
    }
    public List<Combo> listaCombo(){
        return comboRepo.findAll();    //Lista de todos combos.
    }
     public Combo comboId(int id, Combo combo){
         Optional<Combo> bCombo = this.comboRepo.findById(id); //Procura de combo pela id.
         return null;
     }
}
