package br.ufal.ic.jcode.repo.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import br.ufal.ic.jcode.smells.CodeSmellType;
import br.ufal.ic.jcode.ClassMetrics;
import br.ufal.ic.jcode.Classe;

public class MetricsReaderUtil {

    public static List<Classe> readClasses(String metricsFile, String codeSmellsFile) {
        List<Classe> classes = new ArrayList<>();

        Map<String, Set<CodeSmellType>> codeSmellsByClass = readCodeSmells(codeSmellsFile);

        for (String line : readLines(metricsFile)) {

            Classe classe = new Classe();
            classe.setMetrics(new ClassMetrics(line.split(";")));
            classe.setName(classe.getMetrics().getClassName());
            Set<CodeSmellType> codeSmells = codeSmellsByClass.get(classe.getName());
            if (codeSmells != null) {
                classe.setSmells(codeSmells);
            }

            classes.add(classe);
        }

        return classes;

    }

    public static Map<String, ClassMetrics> readMetrics(String metricsFile) {
        Map<String, ClassMetrics> result = new HashMap<String, ClassMetrics>();
        for (String line : readLines(metricsFile)) {
            ClassMetrics classMetrics = new ClassMetrics(line.split(";"));
            result.put(classMetrics.getClassName(), classMetrics);
        }

        return result;
    }

    public static Map<String, Set<CodeSmellType>> readCodeSmells(String codeSmellsFile) {
        List<String> lines = readLines(codeSmellsFile);
        Map<String, Set<CodeSmellType>> codeSmells = new HashMap<String, Set<CodeSmellType>>();

        for (String line : lines) {
            String[] lineSplited = line.split(",");
            String className = lineSplited[0].trim();
            codeSmells.put(className, getCodeSmells(lineSplited));
        }

        return codeSmells;
    }

    private static List<String> readLines(String fileName) {
        List<String> lines = null;
        try {
            lines = FileUtils.readLines(new File(fileName));
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return lines;
    }

    private static Set<CodeSmellType> getCodeSmells(String[] splitedLine) {
        Set<CodeSmellType> codeSmells = new HashSet<CodeSmellType>();
        if (splitedLine[1].trim().equals("1")) {
            codeSmells.add(CodeSmellType.ANTI_SINGLETON);
        }
        if (splitedLine[2].trim().equals("1")) {
            codeSmells.add(CodeSmellType.BLOB);
        }
        if (splitedLine[3].trim().equals("1")) {
            codeSmells.add(CodeSmellType.CLASS_DATA_SHOULD_BE_PRIVATE);
        }
        if (splitedLine[4].trim().equals("1")) {
            codeSmells.add(CodeSmellType.COMPLEX_CLASS);
        }
        if (splitedLine[5].trim().equals("1")) {
            codeSmells.add(CodeSmellType.LARGE_CLASS);
        }
        if (splitedLine[6].trim().equals("1")) {
            codeSmells.add(CodeSmellType.LAZY_CLASS);
        }
        if (splitedLine[7].trim().equals("1")) {
            codeSmells.add(CodeSmellType.LONG_METHOD);
        }
        if (splitedLine[8].trim().equals("1")) {
            codeSmells.add(CodeSmellType.LONG_PARAMETER_LIST);
        }
        if (splitedLine[9].trim().equals("1")) {
            codeSmells.add(CodeSmellType.MESSAGE_CHAINS);
        }
        if (splitedLine[10].trim().equals("1")) {
            codeSmells.add(CodeSmellType.REFUSED_PARENT_BEQUEST);
        }
        if (splitedLine[11].trim().equals("1")) {
            codeSmells.add(CodeSmellType.SPECULATIVE_GENERALITY);
        }
        if (splitedLine[12].trim().equals("1")) {
            codeSmells.add(CodeSmellType.SWISS_ARMY_KNIFE);
        }

        return codeSmells;
    }

}
