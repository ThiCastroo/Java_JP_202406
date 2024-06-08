package br.com.tgtdc.model;

public class Disciplina {
	
	private String nome;
	private String periodo;
	private int cargaHoraria;
	
	public String getNome() {
		return nome;
	}

	public String getPeriodo() {
		return periodo;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Disciplina(String nome, String periodo, int cargaHoraria) {
		this.nome = nome;
		this.periodo = periodo;
		this.cargaHoraria = cargaHoraria;
	}

	public Disciplina(Builder builder) {
		this.nome = builder.nome;
		this.periodo = builder.periodo;
		this.cargaHoraria = builder.cargaHoraria;
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	public static class Builder {
		private String nome;
		private String periodo;
		private int cargaHoraria;
		
		public Builder setNome(String nome) {
			this.nome = nome;
			return this;
		}
		
		public Builder setPeriodo(String periodo) {
			this.periodo = periodo;
			return this;
		}
		
		public Builder setCargaHoraria(int cargaHoraria) {
			this.cargaHoraria = cargaHoraria;
			return this;
		}
		
		public Disciplina build() {
			return new Disciplina(this);
		}
	}
	
	@Override
	public String toString() {
		return "[Nome: " + this.nome + ", Periodo: " + this.periodo + ", Carga Horaria: " + this.cargaHoraria + "]";
	}
}
