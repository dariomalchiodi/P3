
package it.unimi.di.malchiodi.serialization;

import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

@SuppressWarnings("unused")
public class PersistentAnimationCustom implements Serializable, Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3431619493963253518L;
	/**
	 * 
	 */
	
	transient private AnimatorThread animator;
	private int currentFrame;
	private int animatorFrames;
	private int nuovocampo = 0;
	
	public PersistentAnimationCustom(int animatorFrames) {
		this.animatorFrames = animatorFrames;
		this.currentFrame = 0;
		animator = new AnimatorThread(this.animatorFrames);
		startAnimation();
	}
	
	public void run() {
		startAnimation();
	}
	
	private void startAnimation() {
		
		System.out.println("animation starting");
		animator.run();
		System.out.println("animation ending");
	}
	

	
	private void writeObject(ObjectOutputStream out) throws IOException {
//		currentFrame = animator.getFrame();
		out.defaultWriteObject();
	}
	
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		animator = new AnimatorThread(this.animatorFrames);
//		animator.setFrame(currentFrame);
		
		startAnimation();
	}

}
