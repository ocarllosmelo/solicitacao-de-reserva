package br.com.carlos.reservas.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
//import java.time.format.DateTimeFormatter;

public class Reservas {
	
	private static int contadorDeReservas = 1;
	private int numeroDeReservas;
	private LocalDate dataDaReserva;
	private LocalDate dataPrevistaDaEntrega;
	
	private Cliente cliente;
	private Colaborador colaborador;
	private ArrayList<Produto> listaProdutos;
	private StatusReserva status;
	
	
	
	public Reservas(Cliente cliente, Colaborador colaborador) {
	    this.cliente = cliente;
	    this.colaborador = colaborador;
	    this.listaProdutos = new ArrayList<>(); // Inicializa a lista vazia
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
	
	public ArrayList<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(ArrayList<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public StatusReserva getStatus() {
		return status;
	}


	public void setStatus(StatusReserva status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
	    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    String nomesProdutos = "";
	    
	    for(Produto p : listaProdutos) {
	        nomesProdutos += "\n   - " + p.getNomeProduto() + " (Quantidade: " + p.getQuantidadeProduto() + " unidade(s).)";
	    }
	    
	    return "\n===============================" +
	           "\nRESERVA Nº: " + numeroDeReservas + 
	           "\nCliente: " + this.cliente.getNomeCliente() + " (CPF: " + this.cliente.getCpfCliente() + ")" +
	           "\nColaborador: " + this.colaborador.getNomeColaborador() +
	           "\nData da Reserva: " + this.dataDaReserva.format(fmt) +
	           "\nPrevisão de Entrega: " + (dataPrevistaDaEntrega != null ? dataPrevistaDaEntrega.format(fmt) : "A definir") +
	           "\nStatus: " + this.status +
	           "\nProdutos Solicitados:" + nomesProdutos +
	           "\n===============================";
	}
	
	public void atualizarNomeReserva(String novoNome) {
		this.cliente.setNomeCliente(novoNome);
		
	}
	
	/*public void atualizarQuantidadeProduto(int novaQuantidade) {
		this.produto.setQuantidadeProduto(novaQuantidade);
	}*/
	
	public void atualizarStatus(StatusReserva novoStatus) {
		this.status = novoStatus;
	}
	
	public void dataPrevistaParaEntregar(int dataPrevista) {
		this.dataPrevistaDaEntrega = this.dataDaReserva.plusDays(dataPrevista);
		
	}
	
	public void adicionarProduto(Produto produto) {
	    this.listaProdutos.add(produto);
	}
	
	public void removerProduto(Produto produto) {
	    this.listaProdutos.remove(produto);
	}
	
	public void removerProdutoPorIndice(int indice) {
		if (indice >= 0 && indice < this.listaProdutos.size()) {
			this.listaProdutos.remove(indice);
		} else {
			System.out.println("\nErro: Item inválido!");
		}

	}

}
