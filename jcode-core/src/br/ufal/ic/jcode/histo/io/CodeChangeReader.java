package br.ufal.ic.jcode.histo.io;

import br.ufal.ic.jcode.histo.CodeChange;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author marcos
 */
public interface CodeChangeReader {
    
    List<CodeChange> read() throws IOException;
}
