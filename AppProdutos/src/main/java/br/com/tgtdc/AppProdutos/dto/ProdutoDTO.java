package br.com.tgtdc.AppProdutos.dto;

public class ProdutoDTO {

	private Long id;
	private String codigoBarras; 
	private String nome; 
	private Double preco;
	private Integer quantidade;
	
	public ProdutoDTO() {}
	
	public ProdutoDTO(Long id, String codigoBarras, String nome, Double preco, Integer quantidade) {
		this.id = id;
		this.codigoBarras = codigoBarras;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public String getNome() {
		return nome;
	}
	public Double getPreco() {
		return preco;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
}
