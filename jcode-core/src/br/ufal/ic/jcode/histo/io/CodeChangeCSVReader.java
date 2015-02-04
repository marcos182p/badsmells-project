package br.ufal.ic.jcode.histo.io;

import br.ufal.ic.jcode.histo.CodeChange;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author marcos
 */
public class CodeChangeCSVReader implements CodeChangeReader {
    
    private String fileName;
    
    public CodeChangeCSVReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<CodeChange> read() throws FileNotFoundException {
   
        HeaderColumnNameTranslateMappingStrategy<CodeChange> beanStrategy
                = new HeaderColumnNameTranslateMappingStrategy<>();
        
        Map<String, String> columnMapping = new HashMap<>();
        columnMapping.put(fileName, fileName);
        beanStrategy.setColumnMapping(columnMapping);
        
        CsvToBean<CodeChange> csvToBean = new CsvToBean<>();
        CSVReader csvReader = new CSVReader(new FileReader(fileName));
        
        return csvToBean.parse(beanStrategy, csvReader);
        
    }
    
}
