package it.unimi.di.malchiodi.serialization;

//TODO: Move example to JavaFX
/*import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;*/

public class AnimatorThread extends Thread {

//TODO: Move example to JavaFX
/*	private int animatorFrames;
	private int currentFrame;
	private ProgressBar pb;
	
	public AnimatorThread(int animatorFrames) {
		this.animatorFrames = animatorFrames;
		this.currentFrame = 0;
		Display d = Display.getDefault();
		Shell s = new Shell(d);
		GridLayout g = new GridLayout(1, false);
		s.setLayout(g);
		pb = new ProgressBar(s, SWT.HORIZONTAL);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		pb.setLayoutData(gd);
		pb.setMinimum(0);
		pb.setMaximum(100);
		pb.setSelection(0);
		
		s.pack();
		s.open();
	}
	
	public int getFrame() {
		return currentFrame;
	}
	
	public void setFrame(int f) {
		currentFrame = f;
	}
	
	public void run() {
		
		while(currentFrame < this.animatorFrames) {
			currentFrame = ++currentFrame % 101;
			pb.setSelection(currentFrame);

			Thread.yield();

		}
		
	}*/
}
