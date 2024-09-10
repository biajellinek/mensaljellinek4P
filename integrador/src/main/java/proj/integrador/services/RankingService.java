package proj.integrador.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import proj.integrador.entities.RankingEntity;
import proj.integrador.repositories.RankingRepository;

@Service
public class RankingService {
	
	@Autowired
	private RankingRepository rankingRepository;
	
	public List<RankingEntity> listarRankings (){
		
		return rankingRepository.findAll(Sort.by(Sort.Direction.DESC,"pontuacao"));
	}
	
	public void aturalizarPontuacao (Integer atleticaId, int pontos) {
		Optional<RankingEntity> rankingOpt = rankingRepository.findByAtleticaId(atleticaId);
		if (rankingOpt.isPresent()) {
			RankingEntity ranking = rankingOpt.get();
			ranking.setPontuacaoTotal(ranking.getPontuacaoTotal() + pontos);
			rankingRepository.save(ranking);		
		} else {
			System.out.println("atlética não encontrada no ranking");
		}
		
	}
	
	// cod pra teste
	//rankingService.atualizarPontuacao(1L, 50); 

}
