package br.ufal.ic.java;

public class CodeStatement {
	
	private String type ;
	private String statement = new String();

	public CodeStatement() {
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	@Override
	public String toString() {
		return "\n Statement [type=" + type + ", statement=" + statement + "]";
	}

}
