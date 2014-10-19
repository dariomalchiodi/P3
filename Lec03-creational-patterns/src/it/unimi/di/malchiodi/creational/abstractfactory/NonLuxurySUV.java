package it.unimi.di.malchiodi.creational.abstractfactory;

public class NonLuxurySUV implements SUV {
	private String name;
	
	public NonLuxurySUV(String name) {
		this.name = name;
	}

	public String getSUVFeatures() {
		return "Non-luxury SUV features";
	}

	public String getSUVName() {
		return name;
	}
}
