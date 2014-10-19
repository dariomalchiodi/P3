package it.unimi.di.malchiodi.intervals;

public interface IntervalFactory {

	public Interval getInterval();
	public Interval getInterval(int leftright);
	public Interval getInterval(int left, int right);
	
}
