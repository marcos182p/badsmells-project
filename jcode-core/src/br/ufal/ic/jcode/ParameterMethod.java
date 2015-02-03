package br.ufal.ic.jcode;


public class ParameterMethod extends AbstractDeclaration {
	
	private String type;
	private String initializer;
	
	public ParameterMethod() {}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public String getInitializer() {
		return initializer;
	}
	
	public void setInitializer(String initializer) {
		this.initializer = initializer;
	}
	
	@Override
	public String toString() {
		return "\n Parameter [modifiers=" + getModifiers() + ", type=" + type
				+ ", name=" + getName() + "]";
	}
	
}
