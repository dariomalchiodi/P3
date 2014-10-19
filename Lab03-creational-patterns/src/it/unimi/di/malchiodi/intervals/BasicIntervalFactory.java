package it.unimi.di.malchiodi.intervals;

import it.unimi.di.malchiodi.intervals.basic.*;

public class BasicIntervalFactory implements IntervalFactory {
	
	private static BasicIntervalFactory f;
	
	private BasicIntervalFactory() {
		
	}
	
	static BasicIntervalFactory getInstance() {
		if(f == null)
			return (f = new BasicIntervalFactory());
		else return f;
	}
	
	public Interval getInterval() {
		throw new UnsupportedOperationException("The BasicIntervalFactory does not implement empty intervals.");
	}

	public Interval getInterval(int leftright) {
		return new BasicInterval(leftright);
	}
	
	public Interval getInterval(int left, int right) {
		return new BasicInterval(left, right);
	}
	
}
