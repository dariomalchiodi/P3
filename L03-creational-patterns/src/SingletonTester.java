
import it.unimi.di.malchiodi.creational.singleton.FileLogger;

public class SingletonTester {
	
	public static void main(String args[]) {
		FileLogger fl = FileLogger.getFileLogger();
		fl.log("ciao");
	}
	
}
