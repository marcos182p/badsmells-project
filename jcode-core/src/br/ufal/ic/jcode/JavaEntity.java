package br.ufal.ic.jcode;

public abstract class JavaEntity {

    private int id;
    private String code;
    private final EntityType entityType;

    public JavaEntity(EntityType entityType) {
        this.entityType = entityType;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    @Override
    public int hashCode() {
        return 83 * 5 + this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JavaEntity other = (JavaEntity) obj;
        return this.id == other.id;
    }
    

}
