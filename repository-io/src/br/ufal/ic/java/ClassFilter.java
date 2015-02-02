package br.ufal.ic.java;

import java.util.ArrayList;
import java.util.List;

import br.ufal.ic.codesmells.CodeSmellType;

public class ClassFilter {
	public static List<Classe> filterByCodeSmellType(List<Classe> classes, CodeSmellType codeSmellType) {
		List<Classe> filtered = new ArrayList<Classe>();
		for (Classe classe: classes) {
			if (classe.getCodeSmells().contains(codeSmellType)) filtered.add(classe);
		}
		return filtered;
	}
}
