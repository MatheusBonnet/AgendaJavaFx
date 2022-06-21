package application.domain;

public class Pessoa {
	
	private String nome;
	
	private String sobrenome;
	
	private Contato contato;
	
	

	public Pessoa() {
		super();
	}

	public Pessoa(String nome, String sobrenome, Contato contato) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.contato = contato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public Contato getContato() {
		return contato;
	}
	
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	@Override
	public String toString() {
		// monta uma linha do nosso CSV de contatos
		StringBuilder sb = new StringBuilder();
		sb.append(nome);
		sb.append(";");
		sb.append(sobrenome);
		sb.append(";");
		sb.append(getContato());
		sb.append("\n");
		return sb.toString();
	}
}
