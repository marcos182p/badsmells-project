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
    
    private boolean isBugFix;
    
    private boolean isPublic;
    
    private EntityType entityType;
    
    private ChangeType changeType;
    
    private String code;
    
    public CodeChange(String snapshot, String date, boolean isBugFix, 
            boolean isPublic, EntityType entityType, ChangeType changeType,
            String code) {
        
        this.snapshot = snapshot;
        try {
            this.date = DATE_FORMAT.parse(date);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
        this.isBugFix = isBugFix;
        this.isPublic = isPublic;
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

    public boolean isIsBugFix() {
        return isBugFix;
    }

    public void setIsBugFix(boolean isBugFix) {
        this.isBugFix = isBugFix;
    }

    public boolean isIsPublic() {
        return isPublic;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
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
