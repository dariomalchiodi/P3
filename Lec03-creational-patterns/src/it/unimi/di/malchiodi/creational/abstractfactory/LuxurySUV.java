package it.unimi.di.malchiodi.creational.abstractfactory;

public class LuxurySUV implements SUV {
	private String name;
	
	public LuxurySUV(String name) {
		this.name = name;
	}

	public String getSUVFeatures() {
		return "Luxury SUV features";
	}

	public String getSUVName() {
		return name;
	}
}
