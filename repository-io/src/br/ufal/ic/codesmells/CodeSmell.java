package br.ufal.ic.codesmells;

import br.ufal.ic.java.Classe;

public class CodeSmell {
	
	private CodeSmellType badSmellType;
	
	private Classe classe;
	
	public CodeSmell(CodeSmellType badSmellType, Classe classe) {
		this.badSmellType = badSmellType;
		this.classe = classe;
	}

	public CodeSmellType getBadSmellType() {
		return badSmellType;
	}

	public Classe getClasse() {
		return classe;
	}

	@Override
	public String toString() {
		return "BadSmell [badSmellType=" + badSmellType + ", classe=" + classe.getName()
				+ "]";
	}
	
	
}
