package br.ufal.ic.jcode.histo;

import br.ufal.ic.jcode.EntityType;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author marcos
 */
public class CodeChange {
    
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
    // Snapshot;Date;BugFix;Entity;Public;Code;ChangeType
    
    private String snapshot;
    
    private Date date;
    
    private boolean bugFix;
    
    private boolean publicDeclaration;
    
    private EntityType entityType;
    
    private ChangeType changeType;
    
    private String code;
    
    public CodeChange() {}
    
    public CodeChange(String snapshot, String date, boolean isBugFix, 
            boolean isPublic, EntityType entityType, ChangeType changeType,
            String code) {
        
        this.snapshot = snapshot;
        setDate(date);
        this.bugFix = isBugFix;
        this.publicDeclaration = isPublic;
        this.entityType = entityType;
        this.changeType = changeType;
        this.code = code;
        
    }

    public String getSnapshot() {
        return snapshot;
    }

    public void setSnapshot(String snapshot) {
        this.snapshot = snapshot;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public void setDate(String date) {
        try {
            this.date = DATE_FORMAT.parse(date);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean isBugFix() {
        return bugFix;
    }

    public void setBugFix(boolean isBugFix) {
        this.bugFix = isBugFix;
    }

    public boolean isPublic() {
        return publicDeclaration;
    }

    public void setPublic(boolean publicDeclaration) {
        this.publicDeclaration = publicDeclaration;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

    public ChangeType getChangeType() {
        return changeType;
    }

    public void setChangeType(ChangeType changeType) {
        this.changeType = changeType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
}
