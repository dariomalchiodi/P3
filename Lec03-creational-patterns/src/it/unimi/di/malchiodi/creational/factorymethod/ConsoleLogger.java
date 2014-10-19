package it.unimi.di.malchiodi.creational.factorymethod;

public class ConsoleLogger implements Logger {
	public void log(String msg) {
		System.out.println(msg);

	}
}
