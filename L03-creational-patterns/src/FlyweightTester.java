
import it.unimi.di.malchiodi.creational.flyweight.*;

import java.util.Vector;
import java.util.StringTokenizer;

public class FlyweightTester {
	private static Vector<String> initialize() {
		Vector<String> v = new Vector<String>();
		v.add("Joe Black,PhD,North");
		v.add("Jane White, ,East");
		v.add("Jack Green, ,South");
		v.add("Judy Blue,MSc,West");
		return v;
	}
	
	public static void main(String args[]) throws Exception {
		Vector<String> empList = initialize();
		DataInformationFactory factory = DataInformationFactory.getInstance();
		for(int i=0; i<empList.size(); i++) {
			String s = empList.elementAt(i);
			StringTokenizer st = new StringTokenizer(s, ",");
			String name = st.nextToken();
			String title = st.nextToken();
			String division = st.nextToken();
			Flyweight flyweight = factory.getFlyweight(division);
			
			VCard card = new VCard(name, title, flyweight);
			card.print();
		}
	}
}
