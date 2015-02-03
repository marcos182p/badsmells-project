package br.ufal.ic.jcode.repo.io;

//package br.ufal.ic.java.io;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.commons.io.FilenameUtils;
//import org.eclipse.jdt.core.dom.Statement;
//
//
//
//public class EclipseASTUtil {
//	
//	public static String JAVA_EXTENSION = "java";
//	
//	private static Map<Integer, String> statementsType = new HashMap<Integer, String>();
//	
//	static {
//		statementsType.put(Statement.ANNOTATION_TYPE_DECLARATION, "ANNOTATION_TYPE_DECLARATION");
//		statementsType.put(Statement.ANNOTATION_TYPE_MEMBER_DECLARATION, "ANNOTATION_TYPE_MEMBER_DECLARATION");
//		statementsType.put(Statement.ANONYMOUS_CLASS_DECLARATION, "ANONYMOUS_CLASS_DECLARATION");
//		statementsType.put(Statement.ARRAY_ACCESS, "ARRAY_ACCESS");
//		statementsType.put(Statement.ARRAY_CREATION, "ARRAY_CREATION");
//		statementsType.put(Statement.ARRAY_INITIALIZER, "ARRAY_INITIALIZER");
//		statementsType.put(Statement.ARRAY_TYPE, "ARRAY_TYPE");
//		statementsType.put(Statement.ASSERT_STATEMENT, "ASSERT_STATEMENT");
//		statementsType.put(Statement.ASSIGNMENT,"ASSIGNMENT");
//		statementsType.put(Statement.BLOCK, "BLOCK");
//		statementsType.put(Statement.BLOCK_COMMENT, "BLOCK_COMMENT");
//		statementsType.put(Statement.BOOLEAN_LITERAL, "BOOLEAN_LITERAL");
//		statementsType.put(Statement.BREAK_STATEMENT, "BREAK_STATEMENT");
//		statementsType.put(Statement.CAST_EXPRESSION, "CAST_EXPRESSION");
//		statementsType.put(Statement.CATCH_CLAUSE, "CATCH_CLAUSE");
//		statementsType.put(Statement.CHARACTER_LITERAL, "CHARACTER_LITERAL");
//		statementsType.put(Statement.CLASS_INSTANCE_CREATION, "CLASS_INSTANCE_CREATION");
//		statementsType.put(Statement.COMPILATION_UNIT, "COMPILATION_UNIT");
//		statementsType.put(Statement.CONDITIONAL_EXPRESSION, "CONDITIONAL_EXPRESSION");
//		statementsType.put(Statement.CONSTRUCTOR_INVOCATION, "CONSTRUCTOR_INVOCATION");
//		statementsType.put(Statement.CONTINUE_STATEMENT, "CONTINUE_STATEMENT");
//		statementsType.put(Statement.DO_STATEMENT, "DO_STATEMENT");
//		statementsType.put(Statement.EMPTY_STATEMENT, "EMPTY_STATEMENT");
//		statementsType.put(Statement.ENHANCED_FOR_STATEMENT, "ENHANCED_FOR_STATEMENT");
//		statementsType.put(Statement.ENUM_CONSTANT_DECLARATION, "ENUM_CONSTANT_DECLARATION");
//		statementsType.put(Statement.ENUM_DECLARATION, "ENUM_DECLARATION");
//		statementsType.put(Statement.EXPRESSION_STATEMENT, "EXPRESSION_STATEMENT");
//		statementsType.put(Statement.FIELD_ACCESS, "FIELD_ACCESS");
//		statementsType.put(Statement.FIELD_DECLARATION, "FIELD_DECLARATION");
//		statementsType.put(Statement.FOR_STATEMENT, "FOR_STATEMENT");
//		statementsType.put(Statement.IF_STATEMENT, "IF_STATEMENT");
//		statementsType.put(Statement.IMPORT_DECLARATION, "IMPORT_DECLARATION");
//		statementsType.put(Statement.INFIX_EXPRESSION, "INFIX_EXPRESSION");
//		statementsType.put(Statement.INITIALIZER, "INITIALIZER");
//		statementsType.put(Statement.INSTANCEOF_EXPRESSION, "INSTANCEOF_EXPRESSION");
//		statementsType.put(Statement.JAVADOC, "JAVADOC");
//		statementsType.put(Statement.LABELED_STATEMENT, "LABELED_STATEMENT");
//		statementsType.put(Statement.MARKER_ANNOTATION, "MARKER_ANNOTATION");
//		statementsType.put(Statement.MEMBER_REF, "MEMBER_REF");
//		statementsType.put(Statement.MEMBER_VALUE_PAIR, "MEMBER_VALUE_PAIR");
//		statementsType.put(Statement.METHOD_DECLARATION, "METHOD_DECLARATION");
//		statementsType.put(Statement.METHOD_INVOCATION, "METHOD_INVOCATION");
//		statementsType.put(Statement.METHOD_REF, "METHOD_REF");
//		statementsType.put(Statement.METHOD_REF_PARAMETER, "METHOD_REF_PARAMETER");
//		statementsType.put(Statement.MODIFIER, "MODIFIER");
//		statementsType.put(Statement.NORMAL_ANNOTATION, "NORMAL_ANNOTATION");
//		statementsType.put(Statement.NULL_LITERAL, "NULL_LITERAL");
//		statementsType.put(Statement.PACKAGE_DECLARATION, "PACKAGE_DECLARATION");
//		statementsType.put(Statement.PARAMETERIZED_TYPE, "PARAMETERIZED_TYPE");
//		statementsType.put(Statement.PARENTHESIZED_EXPRESSION, "PARENTHESIZED_EXPRESSION");
//		statementsType.put(Statement.POSTFIX_EXPRESSION, "POSTFIX_EXPRESSION");
//		statementsType.put(Statement.PREFIX_EXPRESSION, "PREFIX_EXPRESSION");
//		statementsType.put(Statement.PRIMITIVE_TYPE, "PRIMITIVE_TYPE");
//		statementsType.put(Statement.QUALIFIED_NAME, "QUALIFIED_NAME");
//		statementsType.put(Statement.QUALIFIED_TYPE, "QUALIFIED_TYPE");
//		statementsType.put(Statement.RETURN_STATEMENT, "RETURN_STATEMENT");
//		statementsType.put(Statement.SIMPLE_NAME, "SIMPLE_NAME");
//		statementsType.put(Statement.SIMPLE_TYPE, "SIMPLE_TYPE");
//		statementsType.put(Statement.SINGLE_MEMBER_ANNOTATION, "SINGLE_MEMBER_ANNOTATION");
//		statementsType.put(Statement.SINGLE_VARIABLE_DECLARATION, "SINGLE_VARIABLE_DECLARATION");
//		statementsType.put(Statement.STRING_LITERAL, "STRING_LITERAL");
//		statementsType.put(Statement.SUPER_CONSTRUCTOR_INVOCATION, "SUPER_CONSTRUCTOR_INVOCATION");
//		statementsType.put(Statement.SUPER_FIELD_ACCESS, "SUPER_FIELD_ACCESS");
//		statementsType.put(Statement.SUPER_METHOD_INVOCATION, "SUPER_METHOD_INVOCATION");
//		statementsType.put(Statement.SWITCH_CASE, "SWITCH_CASE");
//		statementsType.put(Statement.SWITCH_STATEMENT, "SWITCH_STATEMENT");
//		statementsType.put(Statement.SYNCHRONIZED_STATEMENT, "SYNCHRONIZED_STATEMENT");
//		statementsType.put(Statement.TAG_ELEMENT, "TAG_ELEMENT");
//		statementsType.put(Statement.TEXT_ELEMENT, "TEXT_ELEMENT");
//		statementsType.put(Statement.THIS_EXPRESSION, "THIS_EXPRESSION");
//		statementsType.put(Statement.THROW_STATEMENT, "THROW_STATEMENT");
//		statementsType.put(Statement.TRY_STATEMENT, "TRY_STATEMENT");
//		statementsType.put(Statement.TYPE_DECLARATION, "TYPE_DECLARATION");
//		statementsType.put(Statement.TYPE_DECLARATION_STATEMENT, "TYPE_DECLARATION_STATEMENT");
//		statementsType.put(Statement.TYPE_LITERAL, "TYPE_LITERAL");
//		statementsType.put(Statement.TYPE_PARAMETER, "TYPE_PARAMETER");
//		statementsType.put(Statement.UNION_TYPE, "UNION_TYPE");
//		statementsType.put(Statement.VARIABLE_DECLARATION_EXPRESSION, "VARIABLE_DECLARATION_EXPRESSION");
//		statementsType.put(Statement.VARIABLE_DECLARATION_FRAGMENT, "VARIABLE_DECLARATION_FRAGMENT");
//		statementsType.put(Statement.VARIABLE_DECLARATION_STATEMENT, "VARIABLE_DECLARATION_STATEMENT");
//		statementsType.put(Statement.WHILE_STATEMENT, "WHILE_STATEMENT");
//		statementsType.put(Statement.WILDCARD_TYPE, "WILDCARD_TYPE");	
//	}
//
//	public static String getStatementType(int nodeType) {
//		return statementsType.get(nodeType);
//	}
//	
//	public static List<File> getJavaSourceFiles(String javaProjectPath) {
//		List<File> javaFiles = new ArrayList<File>();
//		
//		findJavaFiles(new File(javaProjectPath), javaFiles);
//		
//		return javaFiles;
//	}
//
//	private static void findJavaFiles(File file, Collection<File> javaFiles) {
//		File[] filesChildren = file.listFiles();
//		
//		if (filesChildren != null) {
//			for (File fileChild : filesChildren) {
//				
//				String filePath = fileChild.getAbsolutePath();
//				String fileExtension = FilenameUtils.getExtension(filePath);
//				
//				if (JAVA_EXTENSION.equals(fileExtension)) {
//					javaFiles.add(fileChild);
//				}
//				
//				findJavaFiles(fileChild, javaFiles);
//			}
//		}
//		
//	}
//	
//}
