package proj.integrador.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proj.integrador.entities.ProdutoEntity;
import proj.integrador.entities.RankingEntity;
import proj.integrador.services.ProdutoService;


@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity,Integer>{

	Optional<ProdutoService> saveProdutos(ProdutoEntity produtoEntity);

}
