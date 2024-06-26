package br.com.tgtdc.AppProdutos.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.tgtdc.AppProdutos.dto.ProdutoDTO;
import br.com.tgtdc.AppProdutos.dto.ProdutoSimplesDTO;
import br.com.tgtdc.AppProdutos.model.Produto;
import br.com.tgtdc.AppProdutos.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;
	
	@Operation(summary = "Busca todos os registros de Produtos")
	@GetMapping
	public ResponseEntity<List<Produto>> findAllProdutos() {
		List<Produto> produtos = produtoService.findAll();
		if (produtos == null) {
			return ResponseEntity.notFound().build();
		}
		if (produtos.size() == 0) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(produtos);
	}
	
	@Operation(summary = "Busca o registro de Produto por ID")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Produto>> findById(@PathVariable Long id) {
		Optional<Produto> produto = produtoService.findById(id);
		if (produto.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(produto);
	}
	
	@Operation(summary = "Grava o registro de Produto")
	@PostMapping
	public ResponseEntity<Produto> save(@RequestBody Produto produto) {
		Produto newProduto = produtoService.save(produto);
		if (newProduto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(newProduto);
	}
	
	@Operation(summary = "Atualiza o registro de Produto. Validação por ID")
	@PutMapping
	public ResponseEntity<Produto> update(@RequestBody Produto produto) {
		Produto updateProduto = produtoService.update(produto);
		if (updateProduto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updateProduto);
	}
	
	@Operation(summary = "Exclui o registro de Produto por ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		produtoService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@Operation(summary = "Pesquisa de uma lista contendo os dados de Produto e sua quantidade em Estoque")
	@GetMapping("/produto-and-quantidade") 
	public ResponseEntity<List<ProdutoDTO>> findProdutoAndQuantidade(){
		List<ProdutoDTO> produtoDtos = produtoService.findProdutoAndQuantidade();
		if(produtoDtos == null) {
			return ResponseEntity.notFound().build();
		}
		if(produtoDtos.size() == 0) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(produtoDtos);
	}
	
	@Operation(summary = "Pesquisa de uma lista contendo os dados de Produto e sua quantidade em Estoque filtrado por quantidade menor que o parâmetro")
	@GetMapping("/produto-and-quantidade/{qte}") 
	public ResponseEntity<List<ProdutoDTO>> findProdutoAndQuantidadeMenor(@PathVariable Integer qte){
		List<ProdutoDTO> produtoDtos = produtoService.findProdutoAndQuantidadeMenor(qte);
		if(produtoDtos == null) {
			return ResponseEntity.notFound().build();
		}
		if(produtoDtos.size() == 0) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(produtoDtos);
	}
	
	@Operation(summary = "Pesquisa de uma lista contendo os dados de Produto e sua quantidade em Estoque com o preço de varejo")
	@GetMapping("/produto-and-quantidade-varejo")  
	public ResponseEntity<List<ProdutoSimplesDTO>> findProdutoAndQuantidadeVarejo(){
		List<ProdutoSimplesDTO> produtoDtos = produtoService.findProdutosPrecoVarejo();
		if(produtoDtos == null) {
			return ResponseEntity.notFound().build();
		}
		if(produtoDtos.size() == 0) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(produtoDtos);
	}
}
