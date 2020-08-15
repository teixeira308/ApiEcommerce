package br.ecommerce.api.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import br.ecommerce.api.entity.Cliente; 
import br.ecommerce.api.repository.ClienteRepository;

@Service
public class ClienteService implements IClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	@Cacheable(value = "clienteCache", key = "#id")
	public Cliente getClienteById(long id) {
		System.out.println("getClienteById()");
		return clienteRepository.findById(id).get();

	}

	@Override
	@Cacheable(value = "allClientesCache", unless = "#result.size() == 0")
	public List<Cliente> getAllClientes() {
		System.out.println("getAllClientes()");
		List<Cliente> lista = new ArrayList<>();
		clienteRepository.findAll().forEach(e -> lista.add(e));
		return lista;
	}

	@Override
	@Caching(put = { @CachePut(value = "clienteCache", key = "#cliente.id") }, evict = {
			@CacheEvict(value = "allClienteCache", allEntries = true) })
	public Cliente addCliente(Cliente cliente) {
		System.out.println("addCliente()");
		return clienteRepository.save(cliente);
	}

	@Override
	@Caching(put = { @CachePut(value = "clienteCache", key = "#cliente.id") }, evict = {
			@CacheEvict(value = "allClientesCache", allEntries = true) })
	public Cliente updateCliente(Cliente cliente) {
		System.out.println("addCliente()");
		return clienteRepository.save(cliente);
	}

	@Override
	@Caching(     evict= {  @CacheEvict(value= "clienteCache", key= "#id"), @CacheEvict(value= "allClientesCache", allEntries= true)     }   ) 
	public void deleteCliente(long id) 
	{     System.out.println("deleteCliente()");     
	clienteRepository.delete(clienteRepository.findById(id).get());  
	} 
}