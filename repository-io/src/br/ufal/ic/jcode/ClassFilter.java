package br.ufal.ic.jcode;

import java.util.ArrayList;
import java.util.List;

import br.ufal.ic.jcode.smells.CodeSmellType;

public class ClassFilter {
	public static List<Classe> filterByCodeSmellType(List<Classe> classes, CodeSmellType codeSmellType) {
		List<Classe> filtered = new ArrayList<Classe>();
		for (Classe classe: classes) {
			if (classe.getSmells().contains(codeSmellType)) filtered.add(classe);
		}
		return filtered;
	}
}
