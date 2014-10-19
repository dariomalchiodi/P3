
import it.unimi.di.malchiodi.creational.abstractfactory.*;

public class AbstractFactoryTester {
	public static void main(String args[]) {

		VehicleFactory vf = VehicleFactory.getVehicleFactory(VehicleFactory.LUXURY_VEHICLE);
		//VehicleFactory vf = VehicleFactory.getVehicleFactory(VehicleFactory.NON_LUXURY_VEHICLE);
	
		Car c = vf.getCar();
		System.out.println(c);
		//System.out.println(c.getCarName());
		//System.out.println(c.getCarFeatures());
	
		SUV s = vf.getSUV();
		System.out.println(s);
		//System.out.println(s.getSUVName());
		//System.out.println(s.getSUVFeatures());
	}
	
}
