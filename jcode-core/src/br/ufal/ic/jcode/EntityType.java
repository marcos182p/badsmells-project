package br.ufal.ic.jcode;

/**
 *
 * @author marcos
 */
public enum EntityType {
    CLASS("class"), FIELD("field"), PARAMETER("parameter"), METHOD("method"), SOURCE_FILE("source_file"), CODE_BLOCK("code_block"), STATEMENT("statement");
    private String nameType;
    
    private EntityType(String nameType) {
        this.nameType = nameType;
    }
//    public 
    
            
}
