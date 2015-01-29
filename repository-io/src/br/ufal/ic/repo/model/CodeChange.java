package br.ufal.ic.repo.model;

import java.util.Date;

/**
 *
 * @author marcos
 */
public class CodeChange {
    // Snapshot;Date;BugFix;Entity;Public;Code;ChangeType
    
    private String snapshot;
    
    private Date date;
    
    private boolean isBugFix;
    
    private boolean isPublic;
    
    private EntityType entityType;
    
    private ChangeType changeType;
    
    private String code;
}
