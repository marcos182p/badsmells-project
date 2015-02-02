package br.ufal.ic.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.ufal.ic.codesmells.CodeSmellType;

public class Classe extends AbstractDeclaration {
	
	private ClassMetrics classMetrics;
	private Set<CodeSmellType> codeSmells;
	
	private String superclass;
	private List<String> imports;
	
	private List<Field> fields;
	private List<Method> methods;
	
	private int linesCodes;
	

	public Classe() {
		codeSmells = new HashSet<CodeSmellType>();
		fields = new ArrayList<Field>();
		methods = new ArrayList<Method>();
	}
	

	public ClassMetrics getClassMetrics() {
		return classMetrics;
	}

	public void setClassMetrics(ClassMetrics classMetrics) {
		this.classMetrics = classMetrics;
	}

	public Set<CodeSmellType> getCodeSmells() {
		return codeSmells;
	}

	public void setCodeSmells(Set<CodeSmellType> codeSmells) {
		this.codeSmells = codeSmells;
	}
	
	public Classe addCodeSmells(CodeSmellType newCodeSmell) {
		this.codeSmells.add(newCodeSmell);
		return this;
	}




	public String getSuperclass() {
		return superclass;
	}

	public void setSuperclass(String superclass) {
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
	
	public void setNumberRows(int numberRows) {
		this.linesCodes = numberRows;
	}
	
	public int getLinesCodes() {
		return linesCodes;
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
				+ ", methods=" + methods + ", numberRows=" + linesCodes + "]";
	}
	


}
