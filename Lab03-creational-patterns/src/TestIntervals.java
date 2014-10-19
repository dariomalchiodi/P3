
import it.unimi.di.malchiodi.intervals.basic.BasicInterval;
import it.unimi.di.malchiodi.intervals.enhanced.FMInterval;
import it.unimi.di.malchiodi.intervals.optimized.AbstractInterval;

import it.unimi.di.malchiodi.intervals.IntervalFactorySelector;
import it.unimi.di.malchiodi.intervals.IntervalFactory;
import it.unimi.di.malchiodi.intervals.Interval;

public class TestIntervals {
	
	public static void main(String args[]) {
		
		// BasicInterval test
		BasicInterval i = new BasicInterval(12,199);
		System.out.println(i);
		System.out.println(i.hashCode());
		
		// EnhancedInterval test
		FMInterval fmi = FMInterval.getFMInterval(3, 12);
		System.out.println(fmi);
		System.out.println(fmi.contains(11));
		
		// OptimizedInterval test
		AbstractInterval j = AbstractInterval.getInterval();
		System.out.println(j);
		System.out.println(j.length());
		
		j = AbstractInterval.getInterval(2);
		System.out.println(j.contains(6));
		
		j = AbstractInterval.getInterval(8, 12);
		System.out.println(j.hashCode());
		
		// IntervalFactory test
		IntervalFactory factory = IntervalFactorySelector.getFactory(args[0]);
		Interval k;
		k= factory.getInterval(); // Throws exception for basic and enhanced factory
		System.out.println(k);
		System.out.println(k.length());  
		//System.out.println(k.contains(4)); // Throws exception
		System.out.println("\n\n");
		
		k= factory.getInterval(7);
		System.out.println(k);
		System.out.println(k.length());
		System.out.println(k.contains(4));
		System.out.println("\n\n");
		
		k= factory.getInterval(3,124);
		System.out.println(k);
		System.out.println(k.length());
		System.out.println(k.contains(4));
		System.out.println("\n\n");
		
		
	}

}
