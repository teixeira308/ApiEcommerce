package br.ecommerce.api.service;

import java.util.List;
import br.ecommerce.api.entity.Pedido;

public interface IPedidoService {

	List<Pedido> getAllPedidos();
	Pedido getPedidoById(int id);
	Pedido addPedido(Pedido pedido);
	Pedido updatePedido(Pedido pedido);
	void deletePedido(int id);
}