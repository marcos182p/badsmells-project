package br.ufal.ic.jcode;

import java.util.ArrayList;
import java.util.List;

public class Method extends JavaEntity {

    private String returnType;
    private List<ParameterMethod> parameters;

    private Declaration declaration;
    
    private int linesCodes;

    private CodeBlock codeBlock;

    public Method() {
        super(EntityType.METHOD);
        parameters = new ArrayList<>();
    }

    public String getRet() {
        return returnType;
    }

    public void setReturnType(String ret) {
        this.returnType = ret;
    }

    public void addParameter(ParameterMethod parameter) {
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
        return "\n Method [modifiers=" + declaration.getModifiers() + ", returnType=" + returnType + ", name="
                + declaration.getName() + ", parameters=" + parameters + ", numberRows=" + linesCodes + "]";
    }

}
