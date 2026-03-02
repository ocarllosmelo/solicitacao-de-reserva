package br.com.carlos.reservas.app;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.carlos.reservas.model.Cliente;
import br.com.carlos.reservas.model.Colaborador;
import br.com.carlos.reservas.model.Produto;
import br.com.carlos.reservas.model.Reservas;
import br.com.carlos.reservas.model.StatusReserva;

public class PainelDeReservas {

	static Scanner sc = new Scanner(System.in);
	static ArrayList<Reservas> reserva;

	public static void main(String[] args) {
		reserva = new ArrayList<Reservas>();

		while (true) {
			operacoes();
		}
	}

	// Método operações, pede que o user informe qual operação ele deseja realizar;
	public static void operacoes() {

		try {
			System.out.println("\n-- Bem-vindo(a)s ao Sistema de Cadastro de Reservas! --");
			System.out.println("-------------------------------------------------------");
			System.out.println("******* Digite a operação que deseja realizar: ********");
			System.out.println("-------------------------------------------------------");
			System.out.println("|          Opção 1 - Cadastrar nova reserva           |");
			System.out.println("|          Opção 2 - Alterar reserva                  |");
			System.out.println("|      	   Opção 3 - Listar reservas                  |");
			System.out.println("|          Opção 4 - Remover reserva                  |");
			System.out.println("|          Opção 5 - Sair                             |");
			System.out.println("-------------------------------------------------------\n");

			int operacao = sc.nextInt();
			sc.nextLine();

			switch (operacao) {

			case 1:
				cadastrarReserva();
				break;

			case 2:
				alterarReserva();
				break;

			case 3:
				listarReserva();
				break;
				
			case 4:
				removerReserva();
				break;

			case 5:
				System.out.println("\nObrigado por usar o nosso Sistema de Cadastro de Reservas, até mais!");
				System.exit(0);

			default:
				System.out.println("\nOpção inválida! Digite novamente!");
			}

		} catch (Exception e) {
			System.out.println("\nOpção inválida! Digite apenas números!");
			sc.nextLine();
		}
	}

	// Método para cadastrar uma reserva;
	public static void cadastrarReserva() {

		// Dados do Cliente
		System.out.println("\nNome do cliente: ");
		String nomeCliente = sc.nextLine().toUpperCase();
		System.out.println("\nTelefone: ");
		String telefoneCliente = sc.nextLine().toUpperCase();
		System.out.println("\nE-mail:");
		String emailCliente = sc.nextLine();
		System.out.println("\nCPF:");
		String cpfCliente = sc.nextLine();

		Cliente cliente = new Cliente(nomeCliente, telefoneCliente, emailCliente, cpfCliente);

		// Dados do Produto
		System.out.println("\nNome do produto:");
		String nomeProduto = sc.nextLine().toUpperCase();
		System.out.println("\nCódigo ISBN do produto:");
		String isbn = sc.nextLine();
		System.out.println("\nQuantidade do produto:");
		int quantidadeProduto = sc.nextInt();
		sc.nextLine();

		Produto produto = new Produto(nomeProduto, isbn, quantidadeProduto);

		// Dados do Colaborador
		System.out.println("\nNome do colaborador:");
		String nomeColaborador = sc.nextLine().toUpperCase();
		System.out.println("\nMatricula:");
		String matricula = sc.nextLine();

		Colaborador colaborador = new Colaborador(nomeColaborador, matricula);

		System.out.println("\nPrevisão, em dias, para entrega: ");
		int dataPrevista = sc.nextInt();
		sc.nextLine();

		// Adicionando a Reserva
		Reservas novaReserva = new Reservas(cliente, colaborador, produto);
		novaReserva.dataPrevistaParaEntregar(dataPrevista);
		reserva.add(novaReserva);
		System.out.println("\nReserva criada com sucesso!");

	}

	// Método para alterar alguma informação da reserva;
	public static void alterarReserva() {

		System.out.println("\n**** Digite a opção que deseja alterar: ****");
		System.out.println("--------------------------------------------");
		System.out.println("|       1 - Nome do cliente                |");
		System.out.println("|       2 - Quantidade do produto          |");
		System.out.println("|       3 - Status da reserva              |");
		System.out.println("|       4 - Data prevista                  |");
		System.out.println("|       5 - Voltar                         |");
		System.out.println("--------------------------------------------\n");

		int escolha;

		try {
			escolha = sc.nextInt();
			sc.nextLine();

		} catch (Exception e) {
			System.out.println("\nOpção inválida! Digite apenas números!");
			sc.nextLine();
			return;
		}

		if (escolha == 5) {
			return;
		}

		if (escolha < 1 || escolha > 4) {
			System.out.println("\nOpção inválida! Digite novamente.");
			return;
		}

		System.out.println("\nDigite o CPF do cliente que deseja atualizar: ");
		Reservas reservaEncontrada = encontrarReservaPorCpf(sc.nextLine());

		if (reservaEncontrada == null) {
			System.out.println("\nCliente não encontrado na lista de reservas.");
			return;
		}

		switch (escolha) {
		case 1:
			System.out.println("\nDigite o novo nome: ");
			reservaEncontrada.atualizarNomeReserva(sc.nextLine().toUpperCase());
			System.out.println("\nNome atualizado com sucesso!");
			break;

		case 2:
			System.out.println("\nDigite a nova quantidade: ");
			reservaEncontrada.atualizarQuantidadeProduto(sc.nextInt());
			sc.nextLine();
			System.out.println("\nQuantidade atualizada com sucesso!");
			break;

		case 3:
			// Reservas reservaEncontradaStatus = encontrarReservaPorNome(sc.nextLine());

			if (reservaEncontrada != null) {
				System.out.println("\nReserva encontrada! Status atual: " + reservaEncontrada.getStatus());
				System.out.println("\nSelecione o novo status para atualizar a reserva: ");
				System.out.println("1 - CONFIRMADA");
				System.out.println("2 - CANCELADA");
				System.out.println("3 - CONCLUIDA\n");

				int opcaoStatus;

				try {
					opcaoStatus = sc.nextInt();
					sc.nextLine();

				} catch (Exception e) {
					System.out.println("\nOpção inválida! Digite apenas números!");
					sc.nextLine();
					return;

				}

				switch (opcaoStatus) {

				case 1:
					reservaEncontrada.atualizarStatus(StatusReserva.CONFIRMADA);
					break;

				case 2:
					reservaEncontrada.atualizarStatus(StatusReserva.CANCELADA);
					break;

				case 3:
					reservaEncontrada.atualizarStatus(StatusReserva.CONCLUIDA);
					break;

				default:
					System.out.println("\nOpção inválida! Status não alterado!");
					return;
				}
				System.out.println("\nStatus atualizado com sucesso!");
			}
			break;

		case 4:
			System.out.println("\nDigite a nova previsão, em dias, para a entrega: ");
			reservaEncontrada.dataPrevistaParaEntregar(sc.nextInt());
			sc.nextLine();
			System.out.println("\nPrevisão de entrega atualizada com sucesso!");
			break;

		default:
			System.out.println("\nOpção inválida! Digite novamente.");
		}
	}

	// Método que busca uma reserva por CPF;
	public static Reservas encontrarReservaPorCpf(String cpfDoCliente) {
		for (Reservas r : reserva) {

			if (r.getCliente().getCpfCliente().equalsIgnoreCase(cpfDoCliente))
				return r;
		}
		return null;
	}

	// Método que lista todas as reservas.
	public static void listarReserva() {
		if (reserva.isEmpty()) {
			System.out.println("\nNenhuma reserva cadastrada no momento!");
		} else {
			System.out.println("\n======= Lista de Reservas =======");
			for (Reservas r : reserva) {
				System.out.println(r);
				System.out.println("-------------------------------");
			}
		}
	}

	public static void removerReserva() {
		System.out.println("\nDigite o CPF do cliente: ");
		Reservas encontrada = encontrarReservaPorCpf(sc.nextLine());

		if (encontrada != null) {
			reserva.remove(encontrada);
			System.out.println("\nReserva removida com sucesso!");
		} else {
			System.out.println("\nCliente não encontrado(a) na lista de reservas!");
		}
	}
}
