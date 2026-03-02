package br.com.carlos.reservas.model;

public class Cliente {
	
	private String nomeCliente;
	private String emailCliente;
	private String telefoneCliente;
	private String cpfCliente;
	
	public Cliente(String nomeCliente, String emailCliente, String telefoneCliente, String cpfCliente) {
		
		this.nomeCliente = nomeCliente;
		this.emailCliente = emailCliente;
		this.telefoneCliente = telefoneCliente;
		this.cpfCliente = cpfCliente;
		
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}
	
	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	
}
