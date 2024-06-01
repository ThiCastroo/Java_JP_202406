package br.com.tgtdc.model;

public class Professor extends Pessoa{
	
	private String materia;
	private String formacao; 
	private int codigo;
	
	public String getMateria() {
		return materia;
	}
	
	public String getFormacao() {
		return formacao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public Professor(String nome, String telefone, String email, String materia, String formacao, int codigo) {
		super(nome, telefone, email);
		this.materia = materia;
		this.formacao = formacao;
		this.codigo = codigo;
	} 
	
	public Professor(String nome, String telefone, String email, String linkedin, String materia, String formacao, int codigo) {
		super(nome, telefone, email, linkedin);
		this.materia = materia;
		this.formacao = formacao;
		this.codigo = codigo;
	} 
	
	@Override
	public String toString() {
		return "[Nome: " + super.getNome() + ", " +
			   "Telefone: " + super.getTelefone() + ", " +
			   "Email: " + super.getEmail() + ", " +
			   "Linkedin: " + super.getLinkedin() + ", " + 
			   "Matéria: " + this.materia + ", " +
			   "Formação: " + this.formacao + ", " +
			   "Código: " + this.codigo + "]";
	}
}
