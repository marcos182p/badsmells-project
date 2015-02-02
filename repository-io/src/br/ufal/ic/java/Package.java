package br.ufal.ic.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Package {
	
	private String name;
	
	private Map<String, Classe> classes; 
	
	public Package() {
		this ("default");
	}
	
	public Package(String name) {
		this.name = name;
		classes = new HashMap<String, Classe>();
	}
	
	public String getName() {
		return name;
	}
	
	public List<Classe> getClasses() {
		return new ArrayList<Classe>(classes.values());
	}
	
	public Classe getClasse(String classeName) {
		return classes.get(classeName.trim());
	}
	
	public void addClass(Classe classe){
		classes.put(classe.getName(), classe);
	}
	
	

	@Override
	public String toString() {
		return "Package [name=" + name + ", classes=" + classes + "]";
	}
}
