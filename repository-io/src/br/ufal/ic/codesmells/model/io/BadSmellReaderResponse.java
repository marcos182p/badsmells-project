package br.ufal.ic.codesmells.model.io;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import br.ufal.ic.codesmells.CodeSmell;
import br.ufal.ic.codesmells.CodeSmellType;
import br.ufal.ic.java.JavaProject;

public class BadSmellReaderResponse {
	
	private JavaProject project;
	private Map<CodeSmellType, Set<CodeSmell>> badSmells;

	public BadSmellReaderResponse() {
		badSmells = new HashMap<CodeSmellType, Set<CodeSmell>>();
	}
	
	public JavaProject getProject() {
		return project;
	}
	public void setProject(JavaProject project) {
		this.project = project;
	}
	
	public void addBadSmell(CodeSmell badSmell) {
		Set<CodeSmell> badSmells = this.badSmells.get(badSmell.getBadSmellType());
		
		if (badSmells == null) {
			badSmells = new HashSet<CodeSmell>();
			this.badSmells.put(badSmell.getBadSmellType(), badSmells);	
		}
		
		badSmells.add(badSmell);
	}
	
	public Set<CodeSmell> getBadSmells(CodeSmellType badSmellType) {
		return badSmells.get(badSmellType);
	}
	
	public Collection<CodeSmellType> getBadSmellTypes() {
		return badSmells.keySet();
	}
}
