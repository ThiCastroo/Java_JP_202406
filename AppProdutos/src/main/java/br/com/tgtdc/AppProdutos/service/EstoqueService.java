package br.com.tgtdc.AppProdutos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tgtdc.AppProdutos.model.Estoque;
import br.com.tgtdc.AppProdutos.model.Produto;
import br.com.tgtdc.AppProdutos.repository.EstoqueRepository;
import br.com.tgtdc.AppProdutos.repository.ProdutoRepository;
import br.com.tgtdc.AppProdutos.service.interfaces.EstoqueServiceInterface;

@Service
public class EstoqueService implements EstoqueServiceInterface{

	@Autowired
	private EstoqueRepository estoqueRepository;

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	public Estoque save(Estoque estoque) {
		
		if (estoque.getProduto().getId() != null) {
			
			Optional<Produto> findProduto = produtoRepository.findById(estoque.getProduto().getId());
			
			if (!findProduto.isEmpty()) {
				estoque.setProduto(findProduto.get());
				return estoqueRepository.save(estoque);
			} else {
				System.out.println("Produto não encontrado id: " + estoque.getProduto().getId());
				return null;
			}
	
		} else {
			System.out.println("Produto não encontrado!");
			return null;
		}
	}

	@Override
	public Optional<Estoque> findById(Long id) {
		return estoqueRepository.findById(id);
	}

	@Override
	public List<Estoque> findAll() {
		return estoqueRepository.findAll();
	}

	@Override
	public Estoque update(Estoque estoque) {
		
		Optional<Estoque> findEstoque = estoqueRepository.findById(estoque.getId());
		
		if (findEstoque.isPresent()) {
			Estoque updateEstoque = findEstoque.get();
			updateEstoque.setQuantidade(estoque.getQuantidade());
			
			return estoqueRepository.save(updateEstoque);
		} else {
			return save(estoque);
		}
	}

	@Override
	public void delete(Long id) {
		estoqueRepository.deleteById(id);
	}
	
	
	
}
