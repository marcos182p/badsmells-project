package br.ufal.ic.java;

import java.util.ArrayList;
import java.util.List;

public class Method extends AbstractDeclaration {
	
	private String returnType;
	private List<ParameterMethod> parameters;
	
	private int linesCodes;
	
	private CodeBlock codeBlock;
	
	public Method() {
		parameters = new ArrayList<ParameterMethod>();
	}
	
	public String getRet() {
		return returnType;
	}

	public void setReturnType(String ret) {
		this.returnType = ret;
	}

	public void addParameter(ParameterMethod parameter){
		parameters.add(parameter);
	}

	public List<ParameterMethod> getParameters() {
		return parameters;
	}
	
	public void setParameters(List<ParameterMethod> parameters) {
		this.parameters = parameters;
	}
	
	public CodeBlock getCodeBlock() {
		return codeBlock;
	}

	public void setBody(CodeBlock codeBlock) {
		this.codeBlock = codeBlock;
	}
	
	public int getLinesCodes() {
		return linesCodes;
	}

	public void setLinesCodes(int linesCodes) {
		this.linesCodes = linesCodes;
	}

	public int getNumberParameters() {
		return parameters.size();
	}

	@Override
	public String toString() {
		return "\n Method [modifiers=" + getModifiers() + ", returnType=" + returnType + ", name="
				+ getName() + ", parameters=" + parameters + ", numberRows=" + linesCodes + "]";
	}
	
	
}
