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

import br.com.tgtdc.AppProdutos.model.Produto;
import br.com.tgtdc.AppProdutos.service.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoResource {

	@Autowired
	ProdutoService produtoService;
	
	@GetMapping("produto")
	public ResponseEntity<Produto> getProduto() {
		Produto produto = new Produto();
		produto.setId(1L);
		produto.setCodigoBarras("123MN213");
		produto.setNome("Fone de ouvido");
		produto.setPreco(35.0);
		return ResponseEntity.ok(produto);
	}
	
	@GetMapping("salvar")
	public ResponseEntity<Produto> save2() {
		Produto produto = new Produto();
		produto.setCodigoBarras("123MN213");
		produto.setNome("Fone de ouvido");
		produto.setPreco(35.0);
		
		Produto produtoResposta = produtoService.save(produto);
		if (produtoResposta == null) {
			ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(produtoResposta);
	}
	
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
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Produto>> findById(@PathVariable Long id) {
		Optional<Produto> produto = produtoService.findById(id);
		if (produto.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(produto);
	}
	
	@PostMapping
	public ResponseEntity<Produto> save(@RequestBody Produto produto) {
		Produto newProduto = produtoService.save(produto);
		if (newProduto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(newProduto);
	}
	
	@PutMapping
	public ResponseEntity<Produto> update(@RequestBody Produto produto) {
		Produto updateProduto = produtoService.update(produto);
		if (updateProduto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updateProduto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		produtoService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
