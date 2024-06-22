package br.com.tgtdc.AppProdutos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tgtdc.AppProdutos.dto.ProdutoDTO;
import br.com.tgtdc.AppProdutos.dto.ProdutoSimplesDTO;
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
	
	public List<ProdutoDTO> findProdutoAndQuantidade(){
		
		List<Object[]> listResult = produtoRepository.findProdutoAndQuantidade();
		List<ProdutoDTO> listProdutoDTO = new ArrayList<ProdutoDTO>();
		
		for(Object[] obj : listResult) {
			ProdutoDTO pDTO = returnBDProdutoDTO(obj);
			listProdutoDTO.add(pDTO);
		}
		
		return listProdutoDTO;
		
	}
	
	/**
	 * Consulta em banco de dados, onde retorna o Produto com sua respectiva 
	 * quantidade que seja <span>menor</span> que o parametro passado 
	 * @param qtde quantidade a ser comparada 
	 * @return lista de ProdutoDTO
	 */
	public List<ProdutoDTO> findProdutoAndQuantidadeMenor(Integer qtde) {
		
		List<Object[]> listResult = produtoRepository.findProdutoAndQuantidadeMenor(qtde);
		List<ProdutoDTO> listProdutoDTO = new ArrayList<ProdutoDTO>();
		
		for(Object[] obj : listResult) {
			ProdutoDTO pDTO = returnBDProdutoDTO(obj);
			listProdutoDTO.add(pDTO);
		}
		
		return listProdutoDTO;
	}
	
	public List<ProdutoSimplesDTO> findProdutosPrecoVarejo() {
		
		List<Object[]> listResult = produtoRepository.findProdutoAndQuantidade();
		List<ProdutoSimplesDTO> listProdutoSimplesDTOs = new ArrayList<ProdutoSimplesDTO>();
		
		/*
		for (Object[] obj : listResult) {
			ProdutoSimplesDTO pSimplesDTO = returnBDProdutoSimplesDTO(obj);
			listProdutoSimplesDTOs.add(pSimplesDTO);
		}
		*/
		
		//Usando a lógica acima, utilizamos o conceito de lambda e stream: 
		listResult.forEach(pSimplesDTO -> {
			listProdutoSimplesDTOs.add(returnBDProdutoSimplesDTO(pSimplesDTO));
		});
		
		return listProdutoSimplesDTOs;
	}
	
	/**
	 * Conversão de objeto recebido do banco de dados para DTO de produtos
	 * @param resultado objeto do BD
	 * @return objeto ProdutoDTO
	 */
	private ProdutoDTO returnBDProdutoDTO(Object[] resultado) {
		ProdutoDTO produtoDTO = new ProdutoDTO();
		if(resultado != null) {
			produtoDTO.setId(((Long)resultado[0]).longValue()   );
			produtoDTO.setCodigoBarras((String)resultado[1]);
			produtoDTO.setNome((String)resultado[2]);
			produtoDTO.setPreco(((Double)resultado[3]).doubleValue());
			produtoDTO.setQuantidade(((Integer)resultado[4]).intValue());
		}
		return produtoDTO;
	}
	
	private ProdutoSimplesDTO returnBDProdutoSimplesDTO(Object[] resultado) {
		if (resultado != null) {
			ProdutoSimplesDTO produtoSimplesDTO = new ProdutoSimplesDTO(
					((Long)resultado[0]).longValue(), 
					((String)resultado[1]), 
					((Double)resultado[3]).doubleValue(),
					(((Double)resultado[3]).doubleValue()*1.02), 
					((Integer)resultado[4]).intValue());
			return produtoSimplesDTO;
		} else {
			return null;
		}
	}
	
}
