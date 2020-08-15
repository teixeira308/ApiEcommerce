package br.ecommerce.api.service;

import java.util.List;
import br.ecommerce.api.entity.Cliente;

public interface IClienteService {

	List<Cliente> getAllClientes();
	Cliente getClienteById(long id);
	Cliente addCliente(Cliente cliente);
	Cliente updateCliente(Cliente cliente);
	void deleteCliente(long id);
}