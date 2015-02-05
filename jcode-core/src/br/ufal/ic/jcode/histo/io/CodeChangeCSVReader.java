package br.ufal.ic.jcode.histo.io;

import br.ufal.ic.jcode.EntityType;
import br.ufal.ic.jcode.histo.ChangeType;
import br.ufal.ic.jcode.histo.CodeChange;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author marcos
 */
public class CodeChangeCSVReader implements CodeChangeReader {
    
    public static void main(String[] args) throws IOException {
//        System.out.println(EntityType.valueOf("METHOD"));
//        System.out.println(Boolean.parseBoolean("false"));
        CodeChangeReader reader = new CodeChangeCSVReader("/home/marcos/Dropbox/Mestrado/Dados/histdata/platform_sdk/platform-sdk.csv");
        System.out.println(reader.read().size());
    }
    
    private final String fileName;
    
    public CodeChangeCSVReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<CodeChange> read() throws IOException {
        List<CodeChange> codeChanges = new ArrayList<>();
//        Iterable<CSVRecord> recorders = new CSVParser(null, CSVFormat.EXCEL)CSVFormat.EXCEL.parse(new FileReader(fileName));
        Iterable<CSVRecord> recorders = CSVFormat.EXCEL.withHeader().withDelimiter(';').parse(new FileReader(fileName));
        
        for (CSVRecord record : recorders) {
            codeChanges.add(createCodeChange(record));
        }
        
        return codeChanges;
    }
    
    private CodeChange createCodeChange(CSVRecord record) {
        CodeChange codeChange = new CodeChange();
        codeChange.setSnapshot(record.get("Snapshot"));
        codeChange.setDate(record.get("Date"));
        codeChange.setBugFix(Boolean.parseBoolean(record.get("BugFix")));;
        codeChange.setEntityType(EntityType.valueOf(record.get("Entity").toUpperCase()));
        codeChange.setPublic(Boolean.parseBoolean(record.get("Public")));
        codeChange.setCode(record.get("Code"));
        codeChange.setChangeType(ChangeType.valueOf(record.get("ChangeType").toUpperCase().replace("*", "")));
        return codeChange;
    }
    
}
