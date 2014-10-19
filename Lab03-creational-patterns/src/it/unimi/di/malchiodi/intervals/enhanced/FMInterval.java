package it.unimi.di.malchiodi.intervals.enhanced;

import it.unimi.di.malchiodi.intervals.Interval;

public class FMInterval implements Interval {

	final int left;
	final int right;
	private static final int MAX_FLYWEIGHT = 10;
	private static FMInterval flyweight[];
	
	static {
		flyweight = new FMInterval[MAX_FLYWEIGHT + 1];
		for(int i=0; i<= MAX_FLYWEIGHT; i++)
			flyweight[i] = new FMInterval(i);
	}
	
	private FMInterval(int left, int right) {
		this.left = left;
		this.right = right;
	}
	
	private FMInterval(int leftright) {
		this.left = this.right = leftright;
	}
	
	public static FMInterval getFMInterval(int left, int right) {
		
		if(left == right) {
			if ( (left >= 0) && (left <= MAX_FLYWEIGHT) )
				return flyweight[left];
			else return new FMInterval(left);
		}
		
		else if(left < right)
			return new FMInterval(left, right);
			else throw new IllegalArgumentException("Invalid interval ([" + left + ".." + right + "])" + ": the left extreme of non-degenerate intervals must be less than the right one.");
	}
	
	public static FMInterval getFMInterval(int leftright) {
		return getFMInterval(leftright, leftright);
	}
	
	public int length() {
		return right - left + 1;
	}
	
	public boolean contains(int p) {
		return (left <= p) && (p <= right);
	}
	
	public boolean equals(Object o) {
		if(o == this) return true;
		if(!(o instanceof FMInterval)) return false;
		FMInterval i = (FMInterval)o;
		return (i.left == this.left) && (i.right == this.right);
	}
	
	public int hashCode() {
		int result = 11;
		result = 31 * result + left;
		result = 31 * result + right;
		return result;
	}
	
	public String toString() {
		if(left == right)
			return "[" +  left + "]";
		else
			return "[" + left + ".." + right + "]";
	}
	
	public static void main(String args[]) {
		System.out.println("I'm the BasicInterval class!");
	}	
	
}
