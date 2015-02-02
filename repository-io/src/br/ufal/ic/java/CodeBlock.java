package br.ufal.ic.java;

import java.util.ArrayList;
import java.util.List;

public class CodeBlock {
	
	private List<CodeStatement> statements = new ArrayList<CodeStatement>();

	public CodeBlock() {
	}

	public void addStatement (CodeStatement codeStatement){
		statements.add(codeStatement);
	}
	
	public List<CodeStatement> getStatements() {
		return statements;
	}
	
	public void setStatements(List<CodeStatement> codeStatements) {
		this.statements = codeStatements;
	}

	@Override
	public String toString() {
		return "\n Body [statements=" + statements + "]";
	}

}
