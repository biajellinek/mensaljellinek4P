package proj.integrador.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proj.integrador.entities.AtleticaEntity;
import proj.integrador.entities.ProdutoEntity;
import proj.integrador.entities.RankingEntity;
import proj.integrador.repositories.AtleticaRepository;
import proj.integrador.repositories.ProdutoRepository;

@Service
public class ProdutoService { 
	
	@Autowired
	private AtleticaRepository atleticaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public ProdutoEntity findById(Integer id) {
		try {
		return produtoRepository.findById(id).orElseThrow();
	}catch (Exception e) {
		System.out.println(e.getCause());
		return new ProdutoEntity();
		}}
	
	public ProdutoEntity saveProdutos(ProdutoEntity produtoEntity) {
		
		return produtoRepository.save(produtoEntity);
	}
	
	public List<ProdutoEntity> findAll(){
		return produtoRepository.findAll();
}
	
	public boolean isDono (Long dono_id, Long atletica_id) {
		
		Optional<AtleticaEntity> atleticaOpt = atleticaRepository.findAll(atletica_id);
		if(atleticaOpt.isPresent()) {
			
			return atleticaOpt.get().getDonoId().equals(dono_id);
		}
		return false;
	}
	
	public ProdutoEntity salvarPostagem(ProdutoEntity produtos, Long dono_id, Long atletica_id) {
		
		if (isDono(dono_id, atletica_id)) {
			return produtoRepository.save(produtos);
			
		} else {
			throw new IllegalArgumentException("apenas o dono podera fazer essa acao");
		}
	}

}
