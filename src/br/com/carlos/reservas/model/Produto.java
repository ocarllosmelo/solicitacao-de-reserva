package br.com.carlos.reservas.model;


public class Produto {
	
	private String nomeProduto;
	private String isbn;
	private int quantidadeProduto;
	
	public Produto(String nomeProduto, String isbn, int quantidadeProduto) {
		
		this.nomeProduto = nomeProduto;
		this.isbn = isbn;
		this.quantidadeProduto = quantidadeProduto;
		
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(int quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

}
