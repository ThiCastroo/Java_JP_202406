package br.com.tgtdc;

public class Carro {

	//Atributos 
	private String cor;
	private String marca; 
	private String modelo; 
	private String cambio;
	
	//Getters and Setters
	protected void setCor(String cor) {
		this.cor = cor;
	}
	
	public String getCor() {
		return this.cor;
	}
	
	protected void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getMarca() {
		return this.marca;
	}
	
	protected void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getModelo() {
		return this.modelo;
	}
	
	protected void setCambio(String cambio) {
		this.cambio = cambio;
	}
	
	public String getCambio() {
		return this.cambio;
	}
	
	public Carro() {}
	
	//Construtor 
	public Carro(String cor, String marca, String modelo) {
		this.cor = cor;
		this.marca = marca; 
		this.modelo = modelo;
		this.cambio = "Manual";
	}
	
	//Sobrecarga de método
	public Carro(String cor, String marca, String modelo, String cambio) {
		this.cor = cor;
		this.marca = marca; 
		this.modelo = modelo;
		this.cambio = cambio;
	}
	
	public Carro(String cor, String marca, String modelo, boolean cambio) {
		this.cor = cor;
		this.marca = marca; 
		this.modelo = modelo;
		if (cambio == true) {
			this.cambio = "Manual";
		} else {
			this.cambio = "Automático";
		}
	}

	//Métodos - Ações
	public void andar() {
		System.out.println("Andando...");
	}
	
	public void parar() {
		System.out.println("Parado!");
	}
	
	@Override
	public String toString() {
		String retorno = "[Cor: " + this.cor + ", " +
						 "Marca: " + this.marca + ", " +
						 "Modelo: " + this.modelo + ", " +
						 "Câmbio: " + this.cambio + "]";
		return retorno;
	}
}
