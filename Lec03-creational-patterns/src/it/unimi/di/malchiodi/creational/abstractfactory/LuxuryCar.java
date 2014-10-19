package it.unimi.di.malchiodi.creational.abstractfactory;

public class LuxuryCar implements Car {
	private String name;
	
	public LuxuryCar(String name) {
		this.name = name;
	}

	public String getCarFeatures() {
		return "Luxury car features";
	}

	public String getCarName() {
		return name;
	}
}
