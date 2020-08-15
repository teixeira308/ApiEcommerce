package br.ecommerce.api.controller;

 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.ecommerce.api.entity.Pedido;
import br.ecommerce.api.service.IPedidoService;
 

@RestController
@RequestMapping("cadastro")
public class PedidoController {

	@Autowired
	private IPedidoService pedidoService;
	
	@GetMapping("pedido/{id}") 
	public ResponseEntity<Pedido> getPedidoById(@PathVariable("id") int id) 
	{     
		Pedido pedido = pedidoService.getPedidoById(id); 
		return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);   
	}
	
	@GetMapping("pedido")
	public ResponseEntity<List<Pedido>> getAllPedido() {
		List<Pedido> lista = pedidoService.getAllPedidos();
		return new ResponseEntity<List<Pedido>>(lista, HttpStatus.OK);
	}
	

	@PostMapping("pedido")
	public ResponseEntity<Void> addPedido(@RequestBody Pedido pedido, UriComponentsBuilder builder) {
		Pedido savedPedido ;
		 try {
			  savedPedido = pedidoService.addPedido(pedido);  
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
		}
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/pedido/{id}").buildAndExpand(savedPedido.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("pedido")
	public ResponseEntity<Pedido> updatePedido(@RequestBody Pedido pedido) {
		pedidoService.updatePedido(pedido);
		return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
	}
	@DeleteMapping("pedido/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") int id) {
		pedidoService.deletePedido(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
}