package br.ufal.ic.repo;

import br.ufal.ic.repo.histo.CodeChange;
import java.util.Set;

/**
 *
 * @author marcos
 */
public class Repo {
    
    private String path;
    private String currentSnapshot;
    
    private Set<CodeChange> codeChanges;
    
    public Repo(String path, String currentSnapshot) {
        this.path = path;
        this.currentSnapshot = currentSnapshot;
    }
    
    public String getPath() {
        return this.path;
    }
    
    public String currentSnapshot() {
        return this.currentSnapshot;
    }
    
    public void setCodeChanges(Set<CodeChange> codeChange) {
        this.codeChanges = codeChange;
    }
    
    public Set<CodeChange> getCodeChanges() {
        return this.codeChanges;
    }
    
    
}
