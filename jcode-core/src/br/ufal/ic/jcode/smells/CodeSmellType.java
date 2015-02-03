package br.ufal.ic.jcode.smells;

public enum CodeSmellType {
	ANTI_SINGLETON("antiSingleton"), 
	BLOB("blob"), 
	CLASS_DATA_SHOULD_BE_PRIVATE("classDataShouldBePrivate"), 
	COMPLEX_CLASS("ComplexClass"),
	LARGE_CLASS("largeClass"),
	LAZY_CLASS("lazyClass"),
	LONG_METHOD("longMethod"),
	LONG_PARAMETER_LIST("longParameterList"),
	MESSAGE_CHAINS("messageChains"),
	REFUSED_PARENT_BEQUEST("refusedParentBequest"),
	SPECULATIVE_GENERALITY("speculativeGenerality"),
	SWISS_ARMY_KNIFE("swissArmyKnife"),
	
	NONE("NONE");
	
	
	

	// SMELLS,HASS,CHANGES,HASC,BUGS,HASB,FILE
	private String value;

	private CodeSmellType(String value) {
		this.value = value;
	}

	public static CodeSmellType fromString(String value) {
		
		if (value != null) {
			for (CodeSmellType bst : CodeSmellType.values()) {
				if (value.equalsIgnoreCase(bst.value)) {
					return bst;
				}
			}
		}
		return null;
	}
}
