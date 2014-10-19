package it.unimi.di.malchiodi.creational.abstractfactory;

public class NonLuxuryVehicleFactory extends VehicleFactory {
	public Car getCar() {
		return new NonLuxuryCar("L-C");
	}
	public SUV getSUV() {
		return new NonLuxurySUV("L-S");
	}
}
