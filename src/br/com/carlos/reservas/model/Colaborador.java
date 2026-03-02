package br.com.carlos.reservas.model;

public class Colaborador {
	
	private String nomeColaborador;
	private String matriculaColaborador;

	public Colaborador(String nomeColaborador, String matriculaColaborador) {
		
		this.nomeColaborador = nomeColaborador;
		this.matriculaColaborador = matriculaColaborador;
	}

	public String getNomeColaborador() {
		return nomeColaborador;
	}

	public void setNomeColaborador(String nomeColaborador) {
		this.nomeColaborador = nomeColaborador;
	}

	public String getMatriculaColaborador() {
		return matriculaColaborador;
	}

	public void setMatriculaColaborador(String matriculaColaborador) {
		this.matriculaColaborador = matriculaColaborador;
	}

}
