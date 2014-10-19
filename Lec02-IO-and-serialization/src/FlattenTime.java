
import it.unimi.mat.serialization.PersistentTime;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FlattenTime {

	public static void main(String args[]) {
		PersistentTime time = new PersistentTime();
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream("serialized-time.dump");
			out = new ObjectOutputStream(fos);
			out.writeObject(time);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				System.exit(1);
			}
		}
	}
}
