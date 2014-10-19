
import it.unimi.di.malchiodi.serialization.PersistentAnimation;
import it.unimi.di.malchiodi.serialization.PersistentAnimationCustom;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;


public class DeserializeAnimation {

//TODO: Move example to JavaFX
/*	public static void main(String[] args) {
		FileInputStream fis = null;
		ObjectInputStream in = null;
//		PersistentAnimation anim2 = null;
//		
//		try {
//			fis = new FileInputStream("anim.dump");
//			in = new ObjectInputStream(fis);
//			anim2 = (PersistentAnimation)in.readObject();
//			System.out.println("ho de-serializzato l'oggetto");
//			in.close();
//		} catch(IOException e) {
//			e.printStackTrace();
//		} catch(ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		
		
		PersistentAnimationCustom anim2 = null;
		
		try {
			fis = new FileInputStream("anim.dump");
			in = new ObjectInputStream(fis);
			anim2 = (PersistentAnimationCustom)in.readObject();
			in.close();
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}*/

}
