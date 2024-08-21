package proj.integrador.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proj.integrador.entities.UsuarioEntity;
import proj.integrador.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/save")
	public UsuarioEntity saveUsuario(@RequestBody UsuarioEntity usuarioEntity) {
		return usuarioService.saveUsuario(usuarioEntity);
		}
	
	@GetMapping("/findAll")
	public ResponseEntity <List<UsuarioEntity>> findAll(){
		
		try {
		return ResponseEntity.ok(usuarioService.findAll());
		} catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
		}}
	
