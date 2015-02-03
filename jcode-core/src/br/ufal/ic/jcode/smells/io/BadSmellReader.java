//package br.ufal.ic.jcode.smells.io;
//
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//
//import org.apache.commons.io.FileUtils;
//
//import br.ufal.ic.jcode.Classe;
//import br.ufal.ic.jcode.JavaProject;
//import br.ufal.ic.jcode.smells.CodeSmell;
//import br.ufal.ic.jcode.smells.CodeSmellType;
//
//public class BadSmellReader {
//	
//	public static BadSmellReaderResponse read(String filePath) throws IOException {
//		List<String> fileLines = FileUtils.readLines(new File(filePath));
//		String projectPath = fileLines.remove(0);
//		
//		BadSmellReaderResponse response = new BadSmellReaderResponse();
//		
//		JavaProjectReaderImpl reader = new JavaProjectReaderImpl(projectPath);
//		JavaProject project = reader.read();
//		
//		response.setProject(project);
//		
//		for (int i = 0; i < fileLines.size(); i++) {
//			String line = fileLines.get(i);
//			response.addBadSmell(buildBadSmell(i + 1, line, project));
//		}
//		return response;
//	}
//	
//	private static CodeSmell buildBadSmell(int lineCounter, String line, JavaProject project) {
//		String[] splitedLine = line.split(",");
//		
//		if (splitedLine.length > 3) {
//			throw new RuntimeException("Linha " + lineCounter + " inv�lida. Informa��es incompletas.");
//		}
//
//		String packageName = splitedLine[0].trim();
//		String classeName = splitedLine[1].trim();
//		String blobTypeLabel = splitedLine[2].trim();
//		
//		Classe classe = project.getClasse(packageName, classeName);
//		CodeSmellType badSmellType = CodeSmellType.fromString(blobTypeLabel);
//		
//		if (classe == null) {
//			throw new RuntimeException("Linha " + lineCounter + " inv�lida. Classe n�o encontrada.");
//		}
//		
//		if (badSmellType == null) {
//			throw new RuntimeException("Linha " + lineCounter + " inv�lida. Tipo de bad smell n�o encontrado.");
//		}
//		
//		return new CodeSmell(badSmellType, classe);
//	}
//
//}
