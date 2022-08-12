package emprestimos;

public class Pessoas {

	Emprestimo emprestimo;
	private String nome[] = {"MAYSA REZENDE", "ENZO OLIVEIRA", "LUIGI PIRES", "JONAS DA MAIA", "ANA MAIA"};
	private int idade[] = {27, 19, 45, 59, 31};

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public String[] getNome() {
		return nome;
	}

	public void setNome(String[] nome) {
		this.nome = nome;
	}

	public int[] getIdade() {
		return idade;
	}

	public void setIdade(int[] idade) {
		this.idade = idade;
	}
	
	public void imprimirPessoas() {
		for(int i = 0; i < 5; i++) {
			System.out.println("NOME: " + nome[i]);
			System.out.println("IDADE: " + idade[i] + "\n");
		}
	}
}
