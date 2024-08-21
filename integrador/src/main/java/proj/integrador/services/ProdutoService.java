package proj.integrador.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proj.integrador.entities.ProdutoEntity;
import proj.integrador.repositories.ProdutoRepository;

@Service
public class ProdutoService { 
	
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

}
