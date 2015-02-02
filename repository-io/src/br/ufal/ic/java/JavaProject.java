package br.ufal.ic.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaProject {

	private String name;
	private Map<String, Package> packages;
	
	public JavaProject() {
		this ("projeto");
	}
	
	public JavaProject(String name) {
		this.name = name;
		packages = new HashMap<String, Package>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addPackage(Package pack){
		packages.put(pack.getName(), pack);
	}
	
	public List<Package> getPackages() {
		return new ArrayList<Package>(packages.values());
	}
	
	public Package getPackage(String name) {
		return packages.get(name);
	}
	
	public Classe getClasse(String packageName, String classeName) {
		return getPackage(packageName).getClasse(classeName);
	}

	@Override
	public String toString() {
		return "Project [name=" + name + ", packages=" + packages.values() + "]";
	}
	
}
