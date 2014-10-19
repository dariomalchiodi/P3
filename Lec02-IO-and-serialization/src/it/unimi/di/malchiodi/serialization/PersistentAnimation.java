package it.unimi.di.malchiodi.serialization;

import java.io.Serializable;

public class PersistentAnimation implements Serializable, Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7941587697339379694L;
	transient private AnimatorThread animator;
	private int animatorFrames;
	
	public PersistentAnimation(int animatorFrames) {
		this.animatorFrames = animatorFrames;
		animator = new AnimatorThread(this.animatorFrames);
		run();
	}
	
	public void run() {
		System.out.println("animation starting");
		animator.run();
		System.out.println("animation ending");
	}
	

}
