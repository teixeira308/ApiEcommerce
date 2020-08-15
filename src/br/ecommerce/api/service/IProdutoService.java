package br.ecommerce.api.service;

import java.util.List;

import br.ecommerce.api.entity.Produto;

public interface IProdutoService {
     List<Produto> getAllProdutos();
     Produto getProdutoById(long id);
     Produto addProduto(Produto produto);
     Produto updateProduto(Produto produto);
     void deleteProduto(long id);
} 
