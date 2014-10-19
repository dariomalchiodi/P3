package it.unimi.di.malchiodi.intervals.optimized;

public class EmptyInterval extends AbstractInterval {
	
	private static EmptyInterval e;
	
	private EmptyInterval() {
	}
	
	protected static EmptyInterval getEmptyInterval() {
		if(e == null)
			return (e = new EmptyInterval());
		else return e;
	}
	
	public int left() {
		throw new UnsupportedOperationException("The empty interval has no left extreme.");
	}
	
	public int right() {
		throw new UnsupportedOperationException("The empty interval has no right extreme.");
	}
	
	public int length() {
		return 0;
	}
	
	public boolean equals(Object o) {
		return o instanceof EmptyInterval;
	}
	
	public int hashCode() {
		return 0;
	}
	
	public String toString() {
		return "[]";
	}

}
