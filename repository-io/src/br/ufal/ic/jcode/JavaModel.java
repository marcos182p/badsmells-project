package br.ufal.ic.jcode;

import java.util.ArrayList;
import java.util.List;

public class JavaModel {

	private List<JavaProject> projects;
	
	public JavaModel() {
		this.projects = new ArrayList<JavaProject>();
	}

	public void setProject(JavaProject project){
		projects.clear();
		projects.add(project);
	}

	public JavaProject getJavaProject() {
		return !projects.isEmpty() ? projects.get(0) : null;
	}

	@Override
	public String toString() {
		return "Model [projects=" + projects + "]";
	}
	
}
