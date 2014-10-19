package it.unimi.di.malchiodi.intervals.basic;

import it.unimi.di.malchiodi.intervals.Interval;

public class BasicInterval implements Interval {
	
	final int left;
	final int right;
	
	public BasicInterval(int left, int right) {
		if(left < right) {
			this.left = left;
			this.right = right;
		}
		else throw new IllegalArgumentException("Invalid interval ([" + left + ".." + right + "])" + ": the left extreme of non-degenerate intervals must be less than the right one.");
	}
	
	public BasicInterval(int leftright) {
		this.left = this.right = leftright;
	}
	
	public int length() {
		return right - left + 1;
	}
	
	public boolean contains(int p) {
		return (left <= p) && (p <= right);
	}
	
	public boolean equals(Object o) {
		if(o == this) return true;
		if(!(o instanceof BasicInterval)) return false;
		BasicInterval i = (BasicInterval)o;
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
