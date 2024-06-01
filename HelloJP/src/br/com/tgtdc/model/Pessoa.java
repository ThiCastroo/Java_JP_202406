package br.com.tgtdc.model;

public class Pessoa {

	private String nome;
	private String telefone; 
	private String email; 
	private String linkedin; 
	
	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}
	
	public String getLinkedin() {
		return linkedin;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public Pessoa(String nome, String telefone, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.linkedin = "-";
	}
	
	public Pessoa(String nome, String telefone, String email, String linkedin) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.linkedin = linkedin;
	}

	@Override
	public String toString() {
		String retorno = "[Nome: " + this.nome + ", " +
						 "Telefone: " + this.telefone + ", " +
						 "Email: " + this.email + ", " +
						 "Linkedin: " + this.linkedin + "]";
		return retorno;
	}
}
