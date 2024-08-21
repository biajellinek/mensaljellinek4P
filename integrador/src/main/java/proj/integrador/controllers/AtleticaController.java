package proj.integrador.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proj.integrador.entities.AtleticaEntity;
import proj.integrador.services.AtleticaService;

@RestController
@RequestMapping("/atletica")
public class AtleticaController {
	
	@Autowired
	private AtleticaService atleticaService;
	
	@PostMapping("/save")
	public AtleticaEntity saveAtletica(@RequestBody AtleticaEntity atleticaEntity) {
		return atleticaService.saveAtletica(atleticaEntity);
		
	}
	
	@GetMapping("findbyid/{id}")
	public ResponseEntity<AtleticaEntity> findById(@PathVariable Integer id){
		
		try {
			return ResponseEntity.ok(atleticaService.findById(id));
		} catch (Exception e) {
			System.err.println(e.getClass());
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<AtleticaEntity>> findAll(){
		
		try {
			return ResponseEntity.ok(atleticaService.findAll());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	

}
