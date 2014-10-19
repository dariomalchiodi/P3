package it.unimi.di.malchiodi.creational.factorymethod;


public class LoggerFactory {
	public boolean isFileLoggingEnabled() {
		// per ora non complichiamoci la vita
		return true;
	}
	
	public Logger getLogger() {
		if(isFileLoggingEnabled()) {
			return FileLogger.getLogger();
		} else {
			return new ConsoleLogger();
		}
	}
}
