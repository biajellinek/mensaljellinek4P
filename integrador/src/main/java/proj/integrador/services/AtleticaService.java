package proj.integrador.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proj.integrador.entities.AtleticaEntity;
import proj.integrador.repositories.AtleticaRepository;

@Service
public class AtleticaService {
	
	@Autowired
	private AtleticaRepository atleticaRepository;

	public AtleticaEntity findById(Integer id) {
		try {
		return atleticaRepository.findById(id).orElseThrow();
	}catch (Exception e) {
		System.out.println(e.getCause());
		return new AtleticaEntity();
		
	}
		}
	
	public AtleticaEntity saveAtletica(AtleticaEntity atleticaEntity) {
		return atleticaRepository.save(atleticaEntity);
		
	}
	
	public List<AtleticaEntity> findAll(){
		var data = (List<AtleticaEntity>)atleticaRepository.findAll();
		System.out.println(data.size());
		System.out.println(data.get(0).getCnpj());
		return atleticaRepository.findAll();
	}
}
