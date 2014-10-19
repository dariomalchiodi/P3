package it.unimi.di.malchiodi.creational.abstractfactory;

public class NonLuxuryCar implements Car {
	private String name;
	
	public NonLuxuryCar(String name) {
		this.name = name;
	}

	public String getCarFeatures() {
		return "Non-luxury car features";
	}

	public String getCarName() {
		return name;
	}
}
