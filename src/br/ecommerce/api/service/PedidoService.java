package br.ecommerce.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import br.ecommerce.api.entity.Pedido;
import br.ecommerce.api.entity.Produto;
import br.ecommerce.api.repository.PedidoRepository;
import br.ecommerce.api.service.ProdutoService;

@Service
public class PedidoService implements IPedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ProdutoService produtoService;

	@Override
	@Cacheable(value = "pedidoCache", key = "#id")
	public Pedido getPedidoById(int id) {
		System.out.println("getPedidoById()");
		return pedidoRepository.findById(id).get();
	}

	@Override
	@Cacheable(value = "allPedidosCache", unless = "#result.size() == 0")
	public List<Pedido> getAllPedidos() {
		System.out.println("getAllPedidos()");
		List<Pedido> lista = new ArrayList<>();
		pedidoRepository.findAll().forEach(e -> lista.add(e));
		return lista;
	}

	@Override
	@Caching(put = { @CachePut(value = "pedidoCache", key = "#pedido.id") }, evict = {
			@CacheEvict(value = "allPedidosCache", allEntries = true) })
	public Pedido addPedido(Pedido pedido) {
		System.out.println("addPedido()");
		List<Produto> prod = convertSetToList(pedido.getProdutos());
		Produto produtoAtualizado;
		int quantidadeDoPedido = 0;

		for (int i = 0; i < prod.size(); i++) {
			quantidadeDoPedido = prod.get(i).getQuantidade();
			produtoAtualizado = produtoService.getProdutoById(prod.get(i).getId());

			if (produtoAtualizado.getQuantidade() > 0) {
				produtoAtualizado.setQuantidade(produtoAtualizado.getQuantidade() - quantidadeDoPedido);
				produtoService.updateProduto(produtoAtualizado);
			}
		}

		return pedidoRepository.save(pedido);
	}

	@Override
	@Caching(put = { @CachePut(value = "pedidoCache", key = "#pedido.id") }, evict = {
			@CacheEvict(value = "allPedidosCache", allEntries = true) })
	public Pedido updatePedido(Pedido pedido) {
		System.out.println("addPedido()");
		return pedidoRepository.save(pedido);
	}

	@Override
	@Caching(evict = { @CacheEvict(value = "pedidoCache", key = "#id"),
			@CacheEvict(value = "allPedidosCache", allEntries = true) })
	public void deletePedido(int id) {
		System.out.println("deletePedido()");
		pedidoRepository.delete(pedidoRepository.findById(id).get());
	}

	public static <T> List<T> convertSetToList(Set<T> set) {
		// create an empty list
		List<T> list = new ArrayList<>();

		// push each element in the set into the list
		for (T t : set)
			list.add(t);

		// return the list
		return list;
	}
}