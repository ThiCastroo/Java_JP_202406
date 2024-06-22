package br.com.tgtdc.AppProdutos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tgtdc.AppProdutos.dto.ProdutoDTO;
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
		try {
			return produtoRepository.save(produto);
		} catch(Exception e) {
			System.out.println("ERR: Erro ao inserir o produto " + produto.toString() + ": " + e.getMessage());
			return null; 
		}
	}
	
	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}
	
	public Optional<Produto> findById(Long id) {
		return produtoRepository.findById(id);
	}
	
	public Produto update(Produto produto) {
		Optional<Produto> findProduto = produtoRepository.findById(produto.getId());
		
		if (findProduto.isPresent()) {
			Produto updateProduto = findProduto.get();
			updateProduto.setCodigoBarras(produto.getCodigoBarras());
			updateProduto.setNome(produto.getNome());
			updateProduto.setPreco(produto.getPreco());
			return produtoRepository.save(updateProduto);
		} 
		
		return produtoRepository.save(produto);	
	}
	
	public void delete(Long id) {
		produtoRepository.deleteById(id);
	}
	
	public List<ProdutoDTO> findProdutoAndQuantidade() {
		
		List<Object[]> listResult = produtoRepository.findProdutoAndQuantidade(); 
		List<ProdutoDTO> listProdutoDTO = new ArrayList<ProdutoDTO>();
		
		for(Object[] obj : listResult) {
			ProdutoDTO pDTO = returnBDProdutoDTO(obj);
		}
		
		return null;
	} 
	
	/**
	 * Conversão de objeto recebido do banco de dados para DTO de produtos 
	 * @param resultado objeto do BD
	 * @return objeto ProdutoDTO
	 */
	private ProdutoDTO returnBDProdutoDTO(Object[] resultado) {
		ProdutoDTO produtoDTO = new ProdutoDTO();
		if (resultado != null) {
			produtoDTO.setId(((Long)resultado[0]).longValue());
			produtoDTO.setCodigoBarras((String)resultado[1]);
			produtoDTO.setNome((String)resultado[2]);
			produtoDTO.setPreco(((Double)resultado[0]).doubleValue());
			produtoDTO.setQuantidade(((Integer)resultado[0]).intValue());
		}
		return produtoDTO;
	}
}
