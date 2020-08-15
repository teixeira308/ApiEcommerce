package br.ecommerce.api.repository;

import org.springframework.data.repository.CrudRepository;
import br.ecommerce.api.entity.Produto;

public interface ProdutoRepository extends CrudRepository<Produto,Long>{
	
}