package br.com.carlos.reservas.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//import java.time.format.DateTimeFormatter;

public class Reservas {
	
	private static int contadorDeReservas = 1;
	private int numeroDeReservas;
	private LocalDate dataDaReserva;
	private LocalDate dataPrevistaDaEntrega;
	
	private Cliente cliente;
	private Colaborador colaborador;
	private Produto produto;
	private StatusReserva status;
	
	public Reservas(Cliente cliente, Colaborador colaborador, Produto produto) {
		this.cliente = cliente;
		this.colaborador = colaborador;
		this.produto = produto;
		this.status = StatusReserva.PENDENTE;
		this.dataDaReserva = LocalDate.now();
		this.numeroDeReservas = contadorDeReservas;
		contadorDeReservas += 1;
		
	}

	public int getNumeroDeReservas() {
		return numeroDeReservas;
	}


	public void setNumeroDeReservas(int numeroDeReservas) {
		this.numeroDeReservas = numeroDeReservas;
	}


	public LocalDate getDataDaReserva() {
		return dataDaReserva;
	}


	public void setDataDaReserva(LocalDate dataDaReserva) {
		this.dataDaReserva = dataDaReserva;
	}


	public LocalDate getDataPrevistaDaEntrega() {
		return dataPrevistaDaEntrega;
	}


	public void setDataPrevistaDaEntrega(LocalDate dataPrevistaDaEntrega) {
		this.dataPrevistaDaEntrega = dataPrevistaDaEntrega;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Colaborador getColaborador() {
		return colaborador;
	}


	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public StatusReserva getStatus() {
		return status;
	}


	public void setStatus(StatusReserva status) {
		this.status = status;
	}
	
	public String toString() {
		// Formatar data para padrão Br
		DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		return "\nReserva: " + numeroDeReservas + "\nNome do(a) cliente: " + this.cliente.getNomeCliente()
				+ "\nProduto solicitado: " + this.produto.getNomeProduto() + "\nQuantidade solicitada: " + this.produto.getQuantidadeProduto()
				+ "\nCódigo ISBN do produto: " + this.produto.getIsbn() + "\nData da reserva: " + this.dataDaReserva.format(formatarData) 
				+ "\nData prevista para a entrega: " + this.dataPrevistaDaEntrega.format(formatarData) 
				+ "\nColaborador: " + this.colaborador.getNomeColaborador() + "\nMatricula: " + this.colaborador.getMatriculaColaborador()
				+ "\nStatus: " + this.status + ".\n";

	}
	
	public void atualizarNomeReserva(String novoNome) {
		this.cliente.setNomeCliente(novoNome);
		
	}
	
	public void atualizarQuantidadeProduto(int novaQuantidade) {
		this.produto.setQuantidadeProduto(novaQuantidade);
	}
	
	public void atualizarStatus(StatusReserva novoStatus) {
		this.status = novoStatus;
	}
	
	public void dataPrevistaParaEntregar(int dataPrevista) {
		this.dataPrevistaDaEntrega = this.dataDaReserva.plusDays(dataPrevista);
		
	}

}
