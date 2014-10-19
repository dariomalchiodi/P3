
import it.unimi.mat.serialization.PersistentAnimation;
import it.unimi.mat.serialization.PersistentAnimationCustom;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;


@SuppressWarnings("unused")
public class SerializeAnimation {

	public static void main(String args[]) throws InterruptedException {

//		PersistentAnimation anim = new PersistentAnimation(50);
		PersistentAnimationCustom anim = new PersistentAnimationCustom(50);
		
		
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream("anim.dump");
			out = new ObjectOutputStream(fos);
			out.writeObject(anim);
			out.close();
			System.out.println("ho serializzato l'oggetto");
		} catch(IOException e) {
			e.printStackTrace();
		}

	}

}

