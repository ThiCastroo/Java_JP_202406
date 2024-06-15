package br.com.tgtdc.AppProdutos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.tgtdc.AppProdutos.model.Produto;

@SpringBootApplication
public class AppProdutosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppProdutosApplication.class, args);
		
		Produto produto = new Produto();
		produto.setId(1L);
		produto.setCodigoBarras("12MN832");
		produto.setNome("Fone de ouvido");
		produto.setPreco(30.5);
		
		System.out.println(produto.toString());
	}

}
