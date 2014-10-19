package it.unimi.di.malchiodi.creational.singleton;

public class FileLogger {
	
	private static FileLogger logger;
	
	private FileLogger() {
		
	}
	
	public static FileLogger getFileLogger() {
		if(logger == null) {
			logger = new FileLogger();
		}
		return logger;
	}

	private void writeToFile(String fileName, String msg) {
		System.out.println("[al file " + fileName + "] " + msg);
	}
	
	public synchronized void log(String msg) {
		writeToFile("log.txt", msg);
	}

}
