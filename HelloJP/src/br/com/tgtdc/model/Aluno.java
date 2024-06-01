package br.com.tgtdc.model;

public class Aluno extends Pessoa{
	
	private String matricula;
	private int anoMatricula;
	
	public String getMatricula() {
		return matricula;
	}

	public int getAnoMatricula() {
		return anoMatricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setAnoMatricula(int anoMatricula) {
		this.anoMatricula = anoMatricula;
	}
	
	public Aluno(String nome, String telefone, String email, String matricula, int anoMatricula) {
		super(nome, telefone, email);
		this.matricula = matricula;
		this.anoMatricula = anoMatricula;
	}

	@Override
	public String toString() {
		return "[Nome: " + super.getNome() + ", " +
			   "Telefone: " + super.getTelefone() + ", " +
			   "Email: " + super.getEmail() + ", " +
			   "Matrícula: " + this.matricula + ", " +
	           "Ano da matrícula: " + this.anoMatricula + "]";
	}

}
