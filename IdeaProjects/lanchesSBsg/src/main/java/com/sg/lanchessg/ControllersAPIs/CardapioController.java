package com.sg.lanchessg.ControllersAPIs;

import com.sg.lanchessg.Model.Lanches;
import com.sg.lanchessg.RegrasdeServico.CardapioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/cardapio")
public class CardapioController {
//    @Autowired
private CardapioService cardapioService;

    @GetMapping
    public List<Lanches> listaCardapio() {
        return this.cardapioService.cardapio();
    }

}
