package proj.integrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proj.integrador.entities.AtleticaEntity;


@Repository
public interface AtleticaRepository extends JpaRepository<AtleticaEntity,Integer>{
	
	

}
