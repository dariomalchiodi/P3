
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class BadlySerializedElvis implements Serializable {

	private static final long serialVersionUID = 5661314080476272822L;
	private String s;
	private static BadlySerializedElvis INSTANCE = null;
	
	private BadlySerializedElvis() {
		s = "I'm the only King of Rock'n'roll (am I?)";
	}
	
	public static BadlySerializedElvis getInstance() {
		if(INSTANCE == null)
			INSTANCE = new BadlySerializedElvis();
		return INSTANCE;
	}
	
	public String toString() {
		return s;
	}
	
	public static void main(String args[]) {
		
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
	
		BadlySerializedElvis e = BadlySerializedElvis.getInstance();
		System.out.println(e);
		
		try{
			oos = new ObjectOutputStream(
					new FileOutputStream("elvis.dat"));
			oos.writeObject(e);
			oos.flush();
			oos.close();
			
			ois = new ObjectInputStream(
					new FileInputStream("elvis.dat"));
			BadlySerializedElvis e2 = (BadlySerializedElvis)ois.readObject();
			System.out.println(e2);
			System.out.println(e == e2);
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			try {
				ois.close();
				oos.close();
			} catch (IOException ex) {
				System.exit(1);
			}
		}
		
	}
	
}
