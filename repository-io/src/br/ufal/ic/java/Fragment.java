package br.ufal.ic.java;

public class Fragment {
	
	private String name;
	private String initializer;

	public Fragment() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInitializer() {
		return initializer;
	}

	public void setInitializer(String initializer) {
		this.initializer = initializer;
	}

	@Override
	public String toString() {
		return "\n Fragment [name=" + name + ", initializer=" + initializer + "]";
	}
	
	

}
