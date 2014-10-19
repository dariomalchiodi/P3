package it.unimi.di.malchiodi.intervals;

import it.unimi.di.malchiodi.intervals.enhanced.FMInterval;

public class EnhancedIntervalFactory implements IntervalFactory {

	private static EnhancedIntervalFactory f;
	
	private EnhancedIntervalFactory() {
		
	}
	
	static EnhancedIntervalFactory getInstance() {
		if(f == null)
			return (f = new EnhancedIntervalFactory());
		else return f;
	}

	public Interval getInterval() {
		throw new UnsupportedOperationException("The BasicIntervalFactory does not implement empty intervals.");
	}	
	
	public Interval getInterval(int leftright) {
		return FMInterval.getFMInterval(leftright);
	}
	
	public Interval getInterval(int left, int right) {
		return FMInterval.getFMInterval(left, right);
	}
	
}
