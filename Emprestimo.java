package emprestimos;

import java.util.Scanner;

public class Emprestimo {

	Scanner leitor = new Scanner(System.in);
	Livros livro = new Livros();
	Pessoas pessoa = new Pessoas();
	String opcao;
	String resposta, nomePessoa, nomeLivro;
	int i;
	private int posicaoLivro;
	int posicaoPessoa;
	int qtdLivros = 0;
	int saldoLivro;

	public int getPosicaoLivro() {
		return posicaoLivro;
	}

	public void iniciar() {
		System.out.println("\n************ SGE - SISTEMA DE GERENCIAMENTO DE EMPRÉSTIMOS ************");
		System.out.print(
				"\nLISTAR LIVROS\nLISTAR PESSOAS\nINICIAR EMPRÉSTIMO\nREGISTRAR DEVOLUÇÃO\nSAIR\nInforme a opção desejada: ");
		opcao = leitor.nextLine();
		switch (opcao) {
		case "LISTAR LIVROS":
			System.out.println("\n********** ACERVO DE LIVROS **********\n");
			livro.imprimirLivros();
			System.out.print("\nEMPRESTAR\nVOLTAR\nInforme a opção desejada: ");
			resposta = leitor.nextLine();
			if (resposta.equals("EMPRESTAR")) {
				opcao = "INICIAR EMPRÉSTIMO";
				iniciarEmprestimo();
			} else {
				iniciar();
			}
			break;
		case "LISTAR PESSOAS":
			System.out.println("\n********** PESSOAS CADASTRADAS **********\n");
			pessoa.imprimirPessoas();
			System.out.print("\nVOLTAR\nSAIR\nInforme a opção desejada: ");
			resposta = leitor.nextLine();
			if (resposta.equals("VOLTAR")) {
				iniciar();
			} else {
				sair();
			}
			break;
		case "INICIAR EMPRÉSTIMO":
			iniciarEmprestimo();
			break;
		case "REGISTRAR DEVOLUÇÃO":
			registrarDevolucao();
			break;
		case "SAIR":
			sair();
			break;
		default:
			System.out.println("\nOPÇÃO INVÁLIDA!\n");
			iniciar();
			break;
		}
	}

	public void iniciarEmprestimo() {
		receberPessoa();
	}

	public void receberPessoa() {
		System.out.print("Informe o nome da Pessoa: ");
		nomePessoa = leitor.nextLine();
		validarPessoa();
	}

	public void validarPessoa() {

		int contador = 0;

		for (int i = 0; i < 5; i++) {
			if (nomePessoa.equals(pessoa.getNome()[i])) {
				contador++;
				posicaoPessoa = i;
				receberNomeLivro();
			}
		}
		if (contador == 0) {
			System.out.println("PESSOA NÃO ENCONTRADA!!!");
			receberPessoa();
		}
	}

	public void receberNomeLivro() {
		System.out.print("Informe o nome do livro: ");
		nomeLivro = leitor.nextLine();
		validarLivro();
	}

	public void validarLivro() {

		int contador = 0;

		if (opcao.equals("INICIAR EMPRÉSTIMO")) {
			for (int i = 0; i < 10; i++) {
				if (nomeLivro.equals(livro.getNome()[i])) {
					contador++;
					posicaoLivro = i;
					validarQuantidadeLivrosDisponiveis();
				}
			}
			if (contador == 0) {
				System.out.println("LIVRO NÃO ENCONTRADO!!!");
				receberNomeLivro();
			}
		} else if (opcao.equals("REGISTRAR DEVOLUÇÃO")) {
			for (int i = 0; i < 10; i++) {
				if (nomeLivro.equals(livro.getNome()[i])) {
					contador++;
					posicaoLivro = i;
				}
			}
			if (contador == 0) {
				System.out.println("LIVRO NÃO ENCONTRADO!!!");
				receberNomeLivro();
			}
		}
	}

	public void validarQuantidadeLivrosDisponiveis() {

		String resp = "";

		System.out.print("Informe a quantidade de exemplares que você gostaria de emprestar: ");
		qtdLivros = leitor.nextInt();
		leitor.nextLine();
		if (livro.getQuantidade()[posicaoLivro] - qtdLivros >= 0) {
			System.out.println("\nOK! Quantidade de exemplares disponível!");
			resp = "SIM";
		} else {
			System.out.println(
					"Não possuímos " + qtdLivros + " exemplar(es) do livro " + nomeLivro + " disponível(eis)!");
			System.out.println("Exemplares disponíveis: " + livro.getQuantidade()[posicaoLivro]);
			System.out.print("Gostaria de emprestar somente o(s) exemplar(es) disponível(is) (SIM/NÃO): ");
			resp = leitor.nextLine();
		}
		if (resp.equals("SIM")) {
			qtdLivros = livro.getQuantidade()[posicaoLivro];
			registrarEmprestimo();
		} else {
			iniciar();
		}
	}

	public void registrarEmprestimo() {

		String resposta;

		System.out.println("\n***** DADOS DO EMPRÉSTIMO *****");
		System.out.println("\nIDENTIFICAÇÃO DA PESSOA\nNOME: " + nomePessoa + "\nIDADE: " + pessoa.getIdade()[posicaoPessoa]);
		System.out.println("\nIDENTIFICAÇÃO DO LIVRO\nTÍTULO: " + nomeLivro + "\nAUTOR: " + livro.getAutor()[posicaoLivro]);
		System.out.print("\nConfirmar empréstimo (SIM/NÃO): ");
		resposta = leitor.nextLine();
		if (resposta.equals("SIM")) {
			sairLivro();
		} else {
			iniciar();
		}
	}

	public void sair() {
		System.out.println("PROGRAMA FINALIZADO!");
		return;
	}

	public void sairLivro() {
		for (int i = 0; i < 10; i++) {
			if (i == posicaoLivro) {
				livro.quantidade[posicaoLivro] = livro.quantidade[posicaoLivro] - qtdLivros;
			}
		}
		System.out.println("\nEMPRÉSTIMO FINALIZADO COM SUCESSO!!!\n");
		iniciar();
	}

	public void entrarLivro() {
		for (int i = 0; i < 10; i++) {
			if (i == posicaoLivro) {
				livro.quantidade[posicaoLivro] = livro.quantidade[posicaoLivro] + qtdLivros;
			}
		}
		System.out.println("\nDEVOLUÇÃO FINALIZADA COM SUCESSO!!!\n");
		iniciar();
	}

	public void registrarDevolucao() {
		
		String resposta;
		
		System.out.println("\n************ REGISTRAR DEVOLUÇÕES ************\n");
		receberPessoa();
		System.out.println("\n***** DADOS DA DEVOLUÇÃO *****");
		System.out.println(
				"\nIDENTIFICAÇÃO DA PESSOA\nNOME: " + nomePessoa + "\nIDADE: " + pessoa.getIdade()[posicaoPessoa]);
		System.out.println(
				"\nIDENTIFICAÇÃO DO LIVRO\nTÍTULO: " + nomeLivro + "\nAUTOR: " + livro.getAutor()[posicaoLivro]);
		System.out.print("\nConfirmar a devolução (SIM/NÃO): ");
		resposta = leitor.nextLine();
		if (resposta.equals("SIM")) {
			entrarLivro();
		} else {
			iniciar();
		}
	}
}
