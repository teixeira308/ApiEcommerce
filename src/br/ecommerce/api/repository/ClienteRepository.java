package br.ecommerce.api.repository;

import org.springframework.data.repository.CrudRepository;
import br.ecommerce.api.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente,Long>{
	
}