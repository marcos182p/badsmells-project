//package br.ufal.ic.java.io;
//
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.commons.io.FileUtils;
//import org.apache.commons.lang.StringUtils;
//import org.apache.log4j.Logger;
//import org.eclipse.jdt.core.dom.AST;
//import org.eclipse.jdt.core.dom.ASTParser;
//import org.eclipse.jdt.core.dom.AbstractTypeDeclaration;
//import org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;
//import org.eclipse.jdt.core.dom.CompilationUnit;
//import org.eclipse.jdt.core.dom.EnumDeclaration;
//import org.eclipse.jdt.core.dom.FieldDeclaration;
//import org.eclipse.jdt.core.dom.ImportDeclaration;
//import org.eclipse.jdt.core.dom.MethodDeclaration;
//import org.eclipse.jdt.core.dom.Modifier;
//import org.eclipse.jdt.core.dom.PackageDeclaration;
//import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
//import org.eclipse.jdt.core.dom.Statement;
//import org.eclipse.jdt.core.dom.Type;
//import org.eclipse.jdt.core.dom.TypeDeclaration;
//import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
//
//import br.ufal.ic.java.Classe;
//import br.ufal.ic.java.CodeBlock;
//import br.ufal.ic.java.Field;
//import br.ufal.ic.java.Fragment;
//import br.ufal.ic.java.JavaProject;
//import br.ufal.ic.java.Method;
//import br.ufal.ic.java.Package;
//import br.ufal.ic.java.ParameterMethod;
//
//public class JavaProjectReaderImpl  {
//	
//	private static Logger LOG = Logger.getLogger(JavaProjectReaderImpl.class);
//
//	private String projectPath;
//
//	private JavaProject javaProject;
//
//	public JavaProjectReaderImpl(String projectPath) {
//		this.projectPath = projectPath;
//	}
//
////	@Override
//	public JavaProject read() {
//		
//		List<File> javaFiles = EclipseASTUtil.getJavaSourceFiles(projectPath);
//		
//		javaProject = new JavaProject();
//		
//		for (File javaFile : javaFiles) {
//				String sourceCode = toString(javaFile);
//				CompilationUnit sourceUnit = toCompilationUnit(sourceCode);
//				
//				convertToModel(sourceUnit);
//		}
//		
//		return javaProject;
//	}
//	
//	private String toString(File javaFile) {
//		try {
//			List<String> linesCode = FileUtils.readLines(javaFile);
//			return StringUtils.join(linesCode.toArray(new String[] {}), "\n");
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
//	}
//	
//	private CompilationUnit toCompilationUnit(String sourceCode) {
//		
//		ASTParser astParser = ASTParser.newParser(AST.JLS4);
//		astParser.setKind(ASTParser.K_COMPILATION_UNIT);
//		astParser.setSource(sourceCode.toCharArray());
//		astParser.setResolveBindings(true);
//		
//		return (CompilationUnit) astParser.createAST(null); 
//	}
//	
//	private String getPackageName(CompilationUnit sourceCodeAST) {
//		PackageDeclaration packageDeclaration = sourceCodeAST.getPackage();
//		if (packageDeclaration == null) return "default";
//		return packageDeclaration.getName().getFullyQualifiedName();
//	}
//
//	@SuppressWarnings("unchecked")
//	private void convertToModel(CompilationUnit sourceCodeAST) {
//
//		List<AbstractTypeDeclaration> sourceCodeTypes = sourceCodeAST.types();
//		
//		Package codePackage = javaProject.getPackage(getPackageName(sourceCodeAST));
//		
//		if (codePackage == null) {
//			codePackage = new Package(getPackageName(sourceCodeAST));
//			javaProject.addPackage(codePackage);
//		}
//		
//		
//		for (AbstractTypeDeclaration abstracttype : sourceCodeTypes) {
//			LOG.debug("------------ Abstract Type Declaration -----------------");
//			
//			if (abstracttype instanceof TypeDeclaration) {
//				TypeDeclaration typedecl = (TypeDeclaration) abstracttype;
//				
//				LOG.debug("------------ Type Declaration -----------------");
//				LOG.debug("=========== Type Name: " + typedecl.getName().toString() + " - lines = " + sourceCodeAST.getLineNumber(sourceCodeAST.getLength() - 1));
//				LOG.debug("=========== Modifiers: " + typedecl.modifiers());
//				
//				Classe classe = new Classe();
//				classe.setName(typedecl.getName().toString());
//				classe.addModifiers(buildModifiers(typedecl.modifiers()));
//				classe.setNumberRows(sourceCodeAST.getLineNumber(sourceCodeAST.getLength() - 1));
//				classe.setImports(getImports(sourceCodeAST.imports()));
//
//				Type type = typedecl.getSuperclassType();
//				
//				if (type != null) {
//					LOG.debug("=========== Superclass: " + typedecl.getSuperclassType().toString());
//					
//					classe.setSuperclass(typedecl.getSuperclassType().toString());
//				}
//				
//				classe.addFields(getFields(typedecl));
//				classe.addMethods(buildMethods(typedecl, sourceCodeAST));
//				codePackage.addClass(classe);
//
//			}
//			if (abstracttype instanceof EnumDeclaration) {
//				EnumDeclaration enumdecl = (EnumDeclaration) abstracttype;
//				
//				LOG.debug("------------ Enum Declaration -----------------");
//				LOG.debug("=========== Type Name: " + enumdecl.getName().toString());
//				LOG.debug("=========== Modifiers: " + enumdecl.modifiers());
//			}
//			if (abstracttype instanceof AnnotationTypeDeclaration) {
//				AnnotationTypeDeclaration annotdecl = (AnnotationTypeDeclaration) abstracttype;
//				LOG.debug("------------ Annotation Declaration -----------------");
//				LOG.debug("=========== Type Name: " + annotdecl.getName().toString());
//				LOG.debug("=========== Modifiers: " + annotdecl.modifiers());
//			}
//		}
//	}
//	
//	
//	@SuppressWarnings("rawtypes")
//	private List<String> getImports(List importsDeclaration) {
//		List<String> imports = new ArrayList<String>();
//		
//		for (Object im: importsDeclaration) {
//			ImportDeclaration importDeclaration = (ImportDeclaration) im;
//			imports.add(importDeclaration.getName().toString());
//		}
//		
//		return imports;
//		
//	}
//
//	private List<Field> getFields(TypeDeclaration typedecl) {
//		List<Field> fields = new ArrayList<Field>();
//		
//		LOG.debug("------------ Fields -----------------");
//		for (FieldDeclaration fieldDeclaration : typedecl.getFields()) {
//			LOG.debug("=========== Field ===========");
//			LOG.debug("=========== Modifiers: " + fieldDeclaration.modifiers());
//			LOG.debug("=========== Type: " + fieldDeclaration.getType());
//			
//			Field field = new Field();
//			field.addModifiers(buildModifiers(fieldDeclaration.modifiers()));
//			field.addFragments(buildFragments(fieldDeclaration));
//
//			fields.add(field);
//		}
//		return fields;
//	}
//
//	private List<Method> buildMethods(TypeDeclaration typedecl, CompilationUnit astRoot) {
//		List<Method> methods = new ArrayList<Method>();
//		
//		LOG.debug("------------ Methods -----------------");
//		for (MethodDeclaration methodDeclaration : typedecl.getMethods()) {
//			Method method = buildMethod(methodDeclaration);
//			
////			method.setNumberRows(astRoot.getLineNumber(methodDeclaration.getStartPosition() - 1) );
//			
//			int startMethod = astRoot.getLineNumber(methodDeclaration.getStartPosition());
//			int endMethod = astRoot.getLineNumber(methodDeclaration.getStartPosition() + methodDeclaration.getLength());
//			
//			method.setLinesCodes(endMethod-  startMethod);
//			methods.add(method);
//			
//		}
//		return methods;
//	}
//
//	@SuppressWarnings("unchecked")
//	private Method buildMethod(MethodDeclaration methodDeclaration) {
//		
//		
//		LOG.debug("=========== Method ===========");
//		LOG.debug("=========== Modifiers: " + methodDeclaration.modifiers());
//		LOG.debug("=========== Return: " + methodDeclaration.getReturnType2());
//		LOG.debug("=========== Name: " + methodDeclaration.getName().toString());
//
//		Method method = new Method();
//		method.addModifiers(buildModifiers(methodDeclaration.modifiers()));
//		method.setName(methodDeclaration.getName().toString());
//
//		if (methodDeclaration.getReturnType2() != null)
//			method.setReturnType(methodDeclaration.getReturnType2().toString());
//
//
//		LOG.debug("=========== Parameters =================");
//		
//		List<SingleVariableDeclaration> parameters = methodDeclaration.parameters();
//		
//		for (SingleVariableDeclaration parameterDeclaretion : parameters) {
//
//			LOG.debug("----------- Parameter Modifiers: " + parameterDeclaretion.getModifiers());
//			LOG.debug("----------- Parameter Type: " + parameterDeclaretion.getType());
//			LOG.debug("----------- Parameter Name: " + parameterDeclaretion.getName().toString());
//			
//			ParameterMethod parameter = new ParameterMethod();
//			parameter.addModifiers(buildModifiers(parameterDeclaretion.modifiers()));
//			
//			parameter.setType(parameterDeclaretion.getType().toString());
//			parameter.setName(parameterDeclaretion.getName().toString());
//
//			if (parameterDeclaretion.getInitializer() != null) {
//				LOG.debug("----------- Parameter Initializer: " + parameterDeclaretion.getInitializer().toString());
//				parameter.setInitializer(parameterDeclaretion.getInitializer().toString());
//			}
//
//			method.addParameter(parameter);
//		}
//		
//		
//		if (methodDeclaration.getBody() != null) {
//			LOG.debug("=========== Body Statements =================");
//			
//			CodeBlock body = new CodeBlock();
//			
//			List<Statement> bodyStatements = methodDeclaration.getBody().statements();
//			
//			for (Statement statement : bodyStatements) {
//				LOG.debug("Statement Type: " + EclipseASTUtil.getStatementType(statement.getNodeType()));
//				LOG.debug("Statement: " + statement.toString());
//
//				br.ufal.ic.java.CodeStatement stmt = new br.ufal.ic.java.CodeStatement();
//				stmt.setStatement(statement.toString());
//				stmt.setType(EclipseASTUtil.getStatementType(statement.getNodeType()));
//				body.addStatement(stmt);
//				
//			}
//			method.setBody(body);
//		}
//
//		
//		return method;
//	}
//
//	@SuppressWarnings("rawtypes")
//	private List<String> buildModifiers(List declarationModifiers) {
//		List<String> modifiers = new ArrayList<String>();
//		
//		for (Object modifier : declarationModifiers) {
//			if (modifier instanceof Modifier) {
//				modifiers.add(modifier.toString());
//			} else {
//				// FIXME o que fazer aqui?
//			}
//			
//		}
//		
//		return modifiers;
//	}
//	
//	@SuppressWarnings("unchecked")
//	private List<Fragment> buildFragments(FieldDeclaration fieldDeclaration) {
//		List<Fragment> fragments = new ArrayList<Fragment>();
//		List<VariableDeclarationFragment> declarationFragments = fieldDeclaration.fragments();
//		
//		for (VariableDeclarationFragment declarationFragment : declarationFragments) {
//			LOG.debug("=========== Fragments =================");
//			LOG.debug("----------- Fragment Name: " + declarationFragment.getName().toString());
//			
//			Fragment fragment = new Fragment();
//			fragment.setName(declarationFragment.getName().toString());
//
//			if (declarationFragment.getInitializer() != null) {
//				LOG.debug("----------- Fragment Initializer: " + declarationFragment.getInitializer().toString());
//				
//				fragment.setInitializer(declarationFragment.getInitializer().toString());
//			}
//			
//			fragments.add(fragment);
//		}
//		
//		return fragments;
//	}
//
//}
