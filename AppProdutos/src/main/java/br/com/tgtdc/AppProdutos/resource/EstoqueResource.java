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

import br.com.tgtdc.AppProdutos.model.Estoque;
import br.com.tgtdc.AppProdutos.service.EstoqueService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueResource {
	
	@Autowired
	private EstoqueService estoqueService;
	
	@Operation(summary = "Grava o registro de Estoque")
	@PostMapping
	public ResponseEntity<Estoque> save(@RequestBody Estoque estoque) {
		Estoque newEstoque = estoqueService.save(estoque);
		if (newEstoque == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(newEstoque);
	}
	
	@Operation(summary = "Busca o registro de Estoque por ID")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Estoque>> findById(@PathVariable Long id) {
		Optional<Estoque> findEstoque = estoqueService.findById(id);
		if (findEstoque.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(findEstoque);
	}
	
	@Operation(summary = "Busca todos os registros de Estoques")
	@GetMapping
	public ResponseEntity<List<Estoque>> findAll() {
		List<Estoque> estoques = estoqueService.findAll();
		if (estoques.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(estoques);
	}
	
	@Operation(summary = "Atualiza o registro de Estoque. Validação por ID")
	@PutMapping
	public ResponseEntity<Estoque> update(@RequestBody Estoque estoque) {
		Estoque updEstoque = estoqueService.update(estoque);
		if (updEstoque == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updEstoque);
	}
	
	@Operation(summary = "Exclui o registro de Estoque por ID")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		estoqueService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
