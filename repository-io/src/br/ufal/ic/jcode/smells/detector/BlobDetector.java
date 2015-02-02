package br.ufal.ic.jcode.smells.detector;
//package br.ufal.ic.model.badsmells.detector;
//import java.util.ArrayList;
//import java.util.List;
//
//import br.ufal.ic.model.badsmells.BadSmell;
//import br.ufal.ic.model.badsmells.BadSmellType;
//import br.ufal.ic.model.badsmells.io.BadSmellReader;
//
//public class BlobDetector extends GPProblem {
//
//	protected Variable numberFields;
//	protected Variable numberMethods;
//	
//	private List<BadSmell> blobClasses;
//	
//	public void initBlobClasses(List<BadSmell> blobClasses) {
//		this.blobClasses = blobClasses;
//	}
//
//	public GPGenotype create() throws InvalidConfigurationException {
//		GPConfiguration conf = getGPConfiguration();
//		
//		@SuppressWarnings("rawtypes")
//		Class[] types = { CommandGene.BooleanClass };
//		@SuppressWarnings("rawtypes")
//		Class[][] argTypes = { {} };
//		CommandGene[][] nodeSets = { {
//				numberFields = Variable.create(conf, "NAD", CommandGene.IntegerClass),
//				numberMethods = Variable.create(conf, "NMD", CommandGene.IntegerClass),
//				new Terminal(conf, CommandGene.IntegerClass, 9, 27, true),
//				new GreaterThan(conf, CommandGene.IntegerClass),
//				new LesserThan(conf, CommandGene.IntegerClass),
//				new Or(conf),
//				new And(conf)
////				new LesserThan(conf, CommandGene.IntegerClass), new And(conf), new Or(conf),
////				new Equals(conf, CommandGene.IntegerClass), new And(conf)
//		// new If(conf, CommandGene.BooleanClass),
//		// new False(conf, CommandGene.BooleanClass)
//		} };
//		return GPGenotype.randomInitialGenotype(conf, types, argTypes,
//				nodeSets, 100, true);
//	}
//
//	public String run() throws Exception {
//		GPConfiguration config = new GPConfiguration();
//		config.setMaxInitDepth(5);
//		config.setPopulationSize(800);
//		config.setFitnessFunction(new SimpleFitnessFunction());
//		config.setStrictProgramCreation(false);
//		config.setProgramCreationMaxTries(5);
//		config.setMaxCrossoverDepth(5);
//
//		config.setGPFitnessEvaluator(new DeltaGPFitnessEvaluator());
//		super.setGPConfiguration(config);
//		GPGenotype geno = create();
//		geno.setVerboseOutput(true);
//
//		config.getEventManager().addEventListener(
//				GeneticEvent.GPGENOTYPE_EVOLVED_EVENT,
//				new GeneticEventListener() {
//					public void geneticEventFired(GeneticEvent a_firedEvent) {
//						GPGenotype genotype = (GPGenotype) a_firedEvent
//								.getSource();
//						int evno = genotype.getGPConfiguration()
//								.getGenerationNr();
//						if (evno % 100 == 0) {
//							IGPProgram best = genotype.getAllTimeBest();
//							System.out.println("Evolving generation " + evno);
//							genotype.outputSolution(best);
//						}
//					}
//				});
//
//		geno.evolve(1000);
////		geno.outputSolution(geno.getAllTimeBest());
//		return geno.getAllTimeBest().toStringNorm(0);
//	}
//
//	public static String detect(String badSmellPath) {
//		try {
//		BlobDetector detector = new BlobDetector();
//		detector.initBlobClasses(new ArrayList<BadSmell>(BadSmellReader.read(badSmellPath).getBadSmells(BadSmellType.BLOB)));
//		return detector.run();
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
//	
////	public static void main(String[] args) throws Exception {
////		System.out.println(detect("src/test.bs"));
////	}
//
//	@SuppressWarnings("serial")
//	private class SimpleFitnessFunction extends GPFitnessFunction {
//		protected double evaluate(final IGPProgram ind) {
//			int error = 0;
//
//			Object[] noargs = new Object[0];
////			int maxDepth = ind.getChromosome(0).getDepth(0);
////			if (maxDepth > 10) {
////				error += maxDepth - 2;
////			}
//				for (BadSmell blob: blobClasses) {
//					numberFields.set(new Integer(blob.getClasse().getNumberFields()));
//					numberMethods.set(new Integer(blob.getClasse().getNumberMethods()));
//					
//					boolean result = ind.execute_boolean(0, noargs);
//					if (!result) {
//						error += 10;
//					}
//				}
//			return error;
//		}
//	}
//	
//}
