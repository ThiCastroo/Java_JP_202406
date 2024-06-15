package br.com.tgtdc.AppProdutos.model;

import java.util.Objects;

public class Produto {

	private Long id;
	private String codigoBarras;
	private String nome;
	private double preco; 
	
	public Produto() {}

	public Produto(Long id, String codigoBarras, String nome, double preco) {
		super();
		this.id = id;
		this.codigoBarras = codigoBarras;
		this.nome = nome;
		this.preco = preco;
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

	public double getPreco() {
		return preco;
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

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "[id: " + this.id + ", " +
			   "codigoBarras: " + this.codigoBarras + ", " +
			   "nome: " + this.nome + ", " +
			   "preco: " + this.preco + "]";
	}
}
