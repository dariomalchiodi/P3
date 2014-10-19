package it.unimi.di.malchiodi.intervals;

public interface Interval {
	
	public int length();
	public boolean contains(int p);
	public boolean equals(Object o);
	public int hashCode();
	public String toString();

}
