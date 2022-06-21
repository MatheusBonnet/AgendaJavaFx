package application.domain;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

	private static List<Pessoa> contatos = new ArrayList<Pessoa>();
	
	private static Integer indexPessoaStage;

	public Agenda() {
		
	}

	public static List<Pessoa> getContatos() {
		return contatos;
	}

	public void setContatos(List<Pessoa> contatos) {
		this.contatos = contatos;
	}
	
	public static Integer getIndexPessoaStage() {
		return indexPessoaStage;
	}

	public static void setIndexPessoaStage(Integer indexPessoaStage) {
		Agenda.indexPessoaStage = indexPessoaStage;
	}
	
	public static Pessoa getPessoa(Integer index) {
		return contatos.get(index);
	}
	
	@Override
	public String toString() {
		return "Agenda" + contatos + "\n";
	}

}
