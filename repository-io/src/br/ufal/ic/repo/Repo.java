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
    
    
}
