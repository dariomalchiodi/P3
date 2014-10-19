package it.unimi.di.malchiodi.creational.flyweight;

public class VCard {
	String name;
	String title;
	Flyweight objFW;
	
	public VCard(String name, String title, Flyweight fw) {
		this.name = name;
		this.title = title;
		this.objFW = fw;
	}
	
	public void print() {
		System.out.println(name);
		System.out.println(title);
		System.out.println(objFW.getAddress() + " - " + objFW.getCity() + " - " + objFW.getState() + " - " + objFW.getZip());
		System.out.println("---------");
	}
}
