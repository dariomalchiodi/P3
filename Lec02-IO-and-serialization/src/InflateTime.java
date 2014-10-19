
import it.unimi.mat.serialization.PersistentTime;

import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;

public class InflateTime {

	public static void main(String args[]) {
		PersistentTime time = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		
		try {
			fis = new FileInputStream("serialized-time.dump");
			in = new ObjectInputStream(fis);
			time = (PersistentTime)in.readObject();
			in.close();
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("flattened time: " + time.getTime());
		System.out.println("current time: " + Calendar.getInstance().getTime());
	}
	
}
