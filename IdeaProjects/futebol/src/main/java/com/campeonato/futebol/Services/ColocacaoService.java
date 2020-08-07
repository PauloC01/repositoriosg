package com.campeonato.futebol.Services;

import com.campeonato.futebol.Model.Campeonato;
import com.campeonato.futebol.Model.Colocacao;
import com.campeonato.futebol.Model.Jogos;
import com.campeonato.futebol.Model.Time;
import com.campeonato.futebol.Repositorios.ColocacaoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ColocacaoService {
    private TimeServices timeService;
    private ColocacaoRepository colocacaoRepo;

    @Transactional
    public Colocacao addTime(Colocacao colocacao) {
        return this.colocacaoRepo.save(colocacao);
    }

    @Transactional
    public Colocacao buscaId(int idColocacao) {
        Optional<Colocacao> bTime = this.colocacaoRepo.findById(idColocacao);
        return bTime.get();
    }

    @Transactional
    public List<Colocacao> listaColocados() {
        List<Colocacao> bChamp = this.colocacaoRepo.findAll();
        return bChamp;
    }

    @Transactional
    public Colocacao atualizarClassificacao(Jogos jogos) {
        Time daCasa = jogos.getDaCasa();
        Time visitante = jogos.getVisitante();
        Campeonato champ = jogos.getCampeonato();

        int mandante_id = daCasa.getId_time();
        int visitante_id = visitante.getId_time();
        int torneio_id = champ.getId_champ();

        Colocacao classificacaoDaCasa = this.colocacaoRepo.findByChampTime(torneio_id, mandante_id) ;
        Colocacao classificacaoVisitante = this.colocacaoRepo.findByChampTime(torneio_id, visitante_id) ;

        int golsDaCasa = jogos.getGols_daCasa();
        int golsVisitante = jogos.getGols_visitante();

        classificacaoVisitante.setGols(classificacaoVisitante.getGols() + golsVisitante);
        classificacaoDaCasa.setGols(classificacaoDaCasa.getGols() + golsDaCasa);
        classificacaoVisitante.setJogos(classificacaoVisitante.getJogos() + 1);
        classificacaoDaCasa.setJogos(classificacaoDaCasa.getJogos() + 1);


        if (golsDaCasa == golsVisitante) {
            classificacaoDaCasa.setEmpates(classificacaoDaCasa.getEmpates() + 1);
            classificacaoDaCasa.setPontos(classificacaoDaCasa.getPontos() + 1);
            classificacaoVisitante.setEmpates(classificacaoVisitante.getEmpates() + 1);
            classificacaoVisitante.setPontos(classificacaoVisitante.getPontos() + 1);

        } else if (golsDaCasa > golsVisitante) {
            classificacaoDaCasa.setVitorias(classificacaoDaCasa.getVitorias() + 1);
            classificacaoDaCasa.setPontos(classificacaoDaCasa.getPontos() + 3);
            classificacaoVisitante.setDerrotas(classificacaoVisitante.getDerrotas() + 1);
        } else {
            classificacaoDaCasa.setDerrotas(classificacaoDaCasa.getDerrotas() + 1);
            classificacaoVisitante.setVitorias(classificacaoVisitante.getVitorias() + 1);
            classificacaoVisitante.setPontos(classificacaoVisitante.getPontos() + 3);
        }
        this.colocacaoRepo.save(classificacaoDaCasa);
        return this.colocacaoRepo.save(classificacaoVisitante);
    }
}
