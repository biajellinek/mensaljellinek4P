package proj.integrador.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proj.integrador.entities.UsuarioEntity;
import proj.integrador.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UsuarioEntity saveUsuario (UsuarioEntity usuarioEntity) {
		return usuarioRepository.save(usuarioEntity);
		
	}

	public List<UsuarioEntity> findAll(){
		return usuarioRepository.findAll();
	}
}
