package br.ufal.ic.jcode;

public class CodeStatement extends JavaEntity {
	
	private String type ;
	private String statement = new String();

	public CodeStatement() {
            super(EntityType.STATEMENT);
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
