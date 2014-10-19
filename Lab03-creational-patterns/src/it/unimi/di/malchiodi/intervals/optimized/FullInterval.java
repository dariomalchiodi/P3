package it.unimi.di.malchiodi.intervals.optimized;

public class FullInterval extends AbstractInterval {
	final int left;
	final int right;
	
	private FullInterval(int left, int right) {
		this.left = left;
		this.right = right;
	}
	
	protected static FullInterval getFullInterval(int left, int right) {
		if(left > right)
			throw new IllegalArgumentException("Invalid interval ([" + left + ".." + right + "])" + ": the left extreme of non-degenerate intervals must be less than the right one.");
		
		return new FullInterval(left, right);
	}
	
	public int left() { return left; }
	
	public int right() { return right; }
	
	public int hashCode() {
		int result = 11;
		result = 31 * result + left;
		result = 31 * result + right;
		return result;
	}
	
	public String toString() {
		return "[" + left + ".." + right + "]";
	}

}
