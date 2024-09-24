package proj.integrador.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proj.integrador.entities.AtleticaEntity;
import proj.integrador.entities.RankingEntity;


@Repository
public interface AtleticaRepository extends JpaRepository<AtleticaEntity,Integer>{
	
	Optional<AtleticaEntity> findById(Long atletica_id);

	Optional<AtleticaEntity> findAll(Long atletica_id);

}
