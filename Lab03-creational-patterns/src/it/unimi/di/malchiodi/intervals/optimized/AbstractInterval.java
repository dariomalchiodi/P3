package it.unimi.di.malchiodi.intervals.optimized;

import it.unimi.di.malchiodi.intervals.Interval;

public abstract class AbstractInterval implements Interval {
	
	public abstract int left();
	public abstract int right();
	
	public static AbstractInterval getInterval(int left, int right) {
		return FullInterval.getFullInterval(left, right);
	}
	
	public static AbstractInterval getInterval(int leftright) {
		return PointInterval.getPointInterval(leftright);
	}
	
	public static AbstractInterval getInterval() {
		return EmptyInterval.getEmptyInterval();
	}
	
	public int length() {
		return right() - left() + 1;
	}
	public boolean contains(int p) {
		return (left() <= p) && (p <= right());
	}
	
	public boolean equals(Object o) {
		if(o == this) return true;
		if(!(o instanceof AbstractInterval)) return false;
		AbstractInterval i = (AbstractInterval)o;
		if(i.length() == 0) return false; // EmptyInterval overrides this method
		return (this.left() == i.left()) && (this.right() == i.right());
	}
	public abstract int hashCode();
	public abstract String toString();
}
