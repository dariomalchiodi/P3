package it.unimi.di.malchiodi.intervals;

import it.unimi.di.malchiodi.intervals.optimized.AbstractInterval;

public class OptimizedIntervalFactory implements IntervalFactory {
	
	private static OptimizedIntervalFactory f;
	
	private OptimizedIntervalFactory() {
		
	}
	
	static OptimizedIntervalFactory getInstance() {
		if(f == null)
			return (f = new OptimizedIntervalFactory());
		else return f;
	}
	
	public Interval getInterval() {
		return AbstractInterval.getInterval();
	}
	
	public Interval getInterval(int leftright) {
		return AbstractInterval.getInterval(leftright);
	}
	
	public Interval getInterval(int left, int right) {
		return AbstractInterval.getInterval(left, right);
	}

}
