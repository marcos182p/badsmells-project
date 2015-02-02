package br.ufal.ic.jcode.smells;

import br.ufal.ic.jcode.Classe;

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
