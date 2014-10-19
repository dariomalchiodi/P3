package it.unimi.di.malchiodi.intervals.optimized;

public class PointInterval extends AbstractInterval {
	
	final int leftright;
	
	private final static int MAX_FLYWEIGHT = 10;
	private static PointInterval flyweight[];
	
	static {
		flyweight = new PointInterval[MAX_FLYWEIGHT+1];
		for(int i=0; i<=MAX_FLYWEIGHT; i++)
			flyweight[i] = new PointInterval(i);
	}
	
	private PointInterval(int leftright) {
		this.leftright = leftright;
	}

	protected static PointInterval getPointInterval(int leftright) {
		if( (leftright >= 0) && (leftright <=MAX_FLYWEIGHT) )
			return flyweight[leftright];
		else return new PointInterval(leftright);
	}
	
	public int left() { return leftright; }
	
	public int right() { return leftright; }
	
	public int hashCode() {
		
		int result = 11;
		result = 31 * result + leftright;
		return result;
	}
	
	public String toString() {
		return "[" + leftright + "]";
	}

}
