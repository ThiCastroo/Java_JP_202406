package br.com.tgtdc.AppProdutos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tgtdc.AppProdutos.model.Produto;
import br.com.tgtdc.AppProdutos.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto save(Produto produto) {
	
		if(produto.getNome() == null) {
			System.out.println("Nome do produto vazio!");
			return null;
		}
		if (produto.getCodigoBarras() == null) {
			System.out.println("Código de barras do produto vazio!");
			return null;
		}
		
		return produtoRepository.save(produto);
	}
	
	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}
	
	public Optional<Produto> findById(Long id) {
		return produtoRepository.findById(id);
	}
	
	public Produto update(Produto produto) {
		return produtoRepository.save(produto);	
	}
	
	public void delete(Long id) {
		produtoRepository.deleteById(id);
	}
	
}
