package br.ufal.ic.jcode;

import java.util.List;
import java.util.ArrayList;

public class CodeBlock extends JavaEntity {

    private List<CodeStatement> statements = new ArrayList<>();

    public CodeBlock() {
        super(EntityType.CODE_BLOCK);
    }

    public void addStatement(CodeStatement codeStatement) {
        statements.add(codeStatement);
    }

    public List<CodeStatement> getStatements() {
        return statements;
    }

    public void setStatements(List<CodeStatement> codeStatements) {
        this.statements = codeStatements;
    }

    @Override
    public String toString() {
        return "\n Body [statements=" + statements + "]";
    }

}
