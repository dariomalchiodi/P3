
import it.unimi.di.malchiodi.creational.factorymethod.LoggerFactory;
import it.unimi.di.malchiodi.creational.factorymethod.Logger;

public class LoggerTester {
	public static void main(String args[]) {
		LoggerFactory factory = new LoggerFactory();
		Logger logger = factory.getLogger();
		
		logger.log("A message to log");
	}
}
