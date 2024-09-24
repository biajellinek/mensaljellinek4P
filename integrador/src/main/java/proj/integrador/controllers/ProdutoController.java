package proj.integrador.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import proj.integrador.entities.ProdutoEntity;
import proj.integrador.services.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping("/save")
	public ProdutoEntity saveProdutos(@RequestBody ProdutoEntity produtoEntity) {
		return produtoService.saveProdutos(produtoEntity);
		
	}
	
	
	@GetMapping("findbyid/{id}")
	public ResponseEntity<ProdutoEntity> findById(@PathVariable Integer id){
		try {
		return ResponseEntity.ok(produtoService.findById(id));
		} catch (Exception e) {
			
			System.err.println(e.getClass());
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<ProdutoEntity>> findAll(){		
		try {
		return ResponseEntity.ok(produtoService.findAll());
	} catch(Exception e) {
		return ResponseEntity.badRequest().build();
	}
	}
	
	@PostMapping("/novaPostagem")
	public ResponseEntity<ProdutoEntity> criarPostagem(@RequestBody ProdutoEntity produto,@RequestParam Long dono_id, @RequestParam Long atletica_id){
		try {
			ProdutoEntity novaPostagem = produtoService.salvarPostagem(produto, dono_id, atletica_id);
			return new ResponseEntity<> (novaPostagem, HttpStatus.CREATED);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
		}
	}

}
