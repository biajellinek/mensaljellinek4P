package proj.integrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proj.integrador.entities.ProdutoEntity;


@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity,Integer>{

	
}
