package it.unimi.di.malchiodi.creational.factorymethod;

public class FileLogger implements Logger {
	
	private static FileLogger logger;
	
	private FileLogger() {
		
	}
	
	public static FileLogger getLogger() {
		if(logger == null)
			logger = new FileLogger();
		
		return logger;
	}
	
	
	
	void writeToFile(String fileName, String msg) {
		System.out.println("[al file " + fileName + "] " + msg);
	}
	
	public synchronized void log(String msg) {
		writeToFile("log.txt", msg);

	}
}
