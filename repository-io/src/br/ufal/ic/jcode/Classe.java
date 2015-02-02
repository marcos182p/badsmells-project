package br.ufal.ic.jcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.ufal.ic.jcode.smells.CodeSmellType;

public class Classe extends AbstractDeclaration {
	
	private ClassMetrics metrics;
	private Set<CodeSmellType> smells;
	
	private Classe superclass;
	private List<String> imports;
	
	private List<Field> fields;
	private List<Method> methods;
	
	public Classe() {
		smells = new HashSet<>();
		fields = new ArrayList<>();
		methods = new ArrayList<>();
	}
	

	public ClassMetrics getMetrics() {
		return metrics;
	}

	public void setMetrics(ClassMetrics metrics) {
		this.metrics = metrics;
	}

	public Set<CodeSmellType> getSmells() {
		return smells;
	}

	public void setSmells(Set<CodeSmellType> smells) {
		this.smells = smells;
	}
	
	public Classe addCodeSmells(CodeSmellType newSmell) {
		this.smells.add(newSmell);
		return this;
	}

	public Classe getSuperclass() {
		return superclass;
	}

	public void setSuperclass(Classe superclass) {
		this.superclass = superclass;
	}
	
	public List<String> getImports() {
		return imports;
	}
	
	public void setImports(List<String> imports) {
		this.imports = imports;
	}

	public void addField(Field field){
		fields.add(field);
	}
	
	public void addFields(List<Field> fields) {
		this.fields.addAll(fields);
	}
	
	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	public void addMethod(Method method){
		this.methods.add(method);
	}
	
	public void addMethods(List<Method> methods) {
		this.methods.addAll(methods);
	}
	
	public List<Method> getMethods() {
		return methods;
	}

	public void setMethods(List<Method> methods) {
		this.methods = methods;
	}
	
	public int getLinesCodes() {
		return metrics.getLOC().intValue();
	}
	
	public int getNumberFields() {
		return fields.size();
	}
	
	public int getNumberMethods() {
		return methods.size();
	}

	@Override
	public String toString() {
		return "\n Classe [name=" + getName() + ", modifiers=" + getModifiers()
				+ ", superclass=" + superclass + ", fields=" + fields
				+ ", methods=" + methods + ", numberRows=" + getLinesCodes() + "]";
	}
	


}
