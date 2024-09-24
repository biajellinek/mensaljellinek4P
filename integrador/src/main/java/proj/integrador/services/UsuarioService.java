package proj.integrador.services;

import java.util.List;
import java.util.Optional;

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
	
	public UsuarioEntity finById (Integer id){
		try {
			return usuarioRepository.findById(id).orElseThrow();
		} catch (Exception e) {
			System.out.println(e.getCause());
			return new UsuarioEntity();
		}
		
	}
}
