
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Elvis implements Serializable {

	private static final long serialVersionUID = -5309249207821940130L;
	private String s;
	private static Elvis INSTANCE = null;
	
	private Elvis() {
		s = "I'm the only King of Rock'n'roll (am I?)";
	}
	
	public static Elvis getInstance() {
		if(INSTANCE == null)
			INSTANCE = new Elvis();
		return INSTANCE;
	}
	
	public String toString() {
		return s;
	}
	
	private Object readResolve() {
		System.out.println("Entro in readResolve");
		System.out.println(this);
		System.out.println(this == Elvis.getInstance());
		System.out.println("Esco da readResolve");
		return Elvis.getInstance();
	}
	
	public static void main(String args[]) {
		
		ObjectInputStream ois=null;
		ObjectOutputStream oos=null;
	
		Elvis e = Elvis.getInstance();
		System.out.println(e);
		
		try{
			oos = new ObjectOutputStream(
					new FileOutputStream("elvis.dat"));
			oos.writeObject(e);
			oos.flush();
			oos.close();
			
			ois = new ObjectInputStream(
					new FileInputStream("elvis.dat"));
			Elvis e2 = (Elvis)ois.readObject();
			System.out.println(e2);
			System.out.println(e == e2);
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				ois.close();
				oos.close();
			} catch(IOException ex) {
				System.exit(1);
			}
		}
		
	}
	
}