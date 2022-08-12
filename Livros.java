package emprestimos;

public class Livros {

	Emprestimo emprestimo;

	private String[] nome = { "ORGULHO E PRECONCEITO", "DOM  QUIXOTE DE LA MANCHA", "O PEQUENO PRÍNCIPE",
			"DOM CASMURRO", "O CONDE DE MONTE CRISTO", "O PROCESSO", "EU, ROBÔ", "O SENHOR DOS ANÉIS", "GUERRA E PAZ",
			"GRANDE SERTÃO VEREDAS: VEREDAS" };
	private String[] autor = { "JANE AUSTEN", "MIGUEL DE CERVANTES", "ANTOINE DE SAINT-EXUPÉRY", "MACHADO DE ASSIS",
			"ALEXANDRE DUMAS", "FRANZ KAFKA", "ISAAC ASIMOV", "J. R. R. TOLKIEN", "LEO TOLSTÓI",
			"JOÃO GUIMARÃES ROSA" };
	int[] quantidade = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };

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

	public String[] getAutor() {
		return autor;
	}

	public void setAutor(String[] autor) {
		this.autor = autor;
	}

	public int[] getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int[] quantidade) {
		this.quantidade = quantidade;
	}

	public void imprimirLivros() {
		for (int i = 0; i < 10; i++) {
			System.out.println("LIVRO: " + nome[i]);
			System.out.println("AUTOR: " + autor[i]);
			System.out.println("EXEMPLARES DISPONÍVEIS: " + quantidade[i] + "\n");
		}
	}
}
