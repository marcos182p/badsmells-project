package br.ufal.ic.jcode.histo.io;

import br.ufal.ic.jcode.EntityType;
import br.ufal.ic.jcode.histo.ChangeType;
import br.ufal.ic.jcode.histo.CodeChange;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.opencsv.bean.MappingStrategy;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author marcos
 */
public class CodeChangeCSVReader implements CodeChangeReader {
    
    public static void main(String[] args) throws IOException {
        CodeChangeReader reader = new CodeChangeCSVReader("C:\\Dropbox\\Mestrado\\Dados\\histdata\\platform_sdk\\platform-sdk.csv");
        reader.read();
    }
    
    private final String fileName;
    
    public CodeChangeCSVReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<CodeChange> read() throws FileNotFoundException {
   
        HeaderColumnNameTranslateMappingStrategy<CodeChange> beanStrategy
                = new HeaderColumnNameTranslateMappingStrategy<>();
        
        
        Map<String, String> columnMapping = new HashMap<>();
        // Snapshot;Date;BugFix;Entity;Public;Code;ChangeType
        // snapshot, date, isBugFix, isPublic, entityType, changeType, code;
        columnMapping.put("Snapshot", "snapshot");
        columnMapping.put("Date", "date");
        columnMapping.put("BugFix", "isBugFix");
        columnMapping.put("Public", "isPublic");
        columnMapping.put("Entity", "entityType");
        columnMapping.put("Code", "code");
        columnMapping.put("ChangeType", "changeType");
        beanStrategy.setColumnMapping(columnMapping);
        
        CsvToBean<CodeChange> csvToBean = new CsvToBean<>();
        beanStrategy.setType(CodeChange.class);
        CSVReader csvReader = new CSVReader(new FileReader(fileName));
        
        return csvToBean.parse(beanStrategy, csvReader);
        
    }
    
}
