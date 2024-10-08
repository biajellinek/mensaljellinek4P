package proj.integrador.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proj.integrador.entities.RankingEntity;

@Repository
public interface RankingRepository extends JpaRepository<RankingEntity, Integer>{
	
	Optional<RankingEntity> findById(Integer atletica_id);

	List<RankingEntity> findAllByPontuacaoTotalDesc();
}

