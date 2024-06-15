package br.com.tgtdc.AppProdutos.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ResponseEntity<Produto> save() {
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
	
}
