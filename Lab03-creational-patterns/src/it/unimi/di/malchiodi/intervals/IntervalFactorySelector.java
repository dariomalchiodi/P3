package it.unimi.di.malchiodi.intervals;

public class IntervalFactorySelector {
	
	private static final String BASIC_FACTORY = "Basic";
	private static final String ENHANCED_FACTORY = "Enhanced";
	private static final String OPTIMIZED_FACTORY = "Optimized";
	
	public static IntervalFactory getFactory(String name) {
		if (name.equals(BASIC_FACTORY))
			return BasicIntervalFactory.getInstance();
		else if (name.equals(ENHANCED_FACTORY))
			return EnhancedIntervalFactory.getInstance();
		else if (name.equals(OPTIMIZED_FACTORY))
			return OptimizedIntervalFactory.getInstance();
		else throw new UnsupportedOperationException(name + " is not a supported interval factory type.");
	} 

}
