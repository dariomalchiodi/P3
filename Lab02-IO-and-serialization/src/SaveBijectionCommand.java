
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;


public class SaveBijectionCommand {
	
	BijectionShell shell;
	
	public SaveBijectionCommand(BijectionShell s) {
		shell = s;
	}
	
	public void execute() {
		FileDialog dialog = new FileDialog(shell, SWT.SAVE);
		dialog.setText("Salva file");
		final String fileName = dialog.open();
		
		if( fileName == null ) {
			System.out.println("Registrazione file annullata.");
			return;
		}
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fos);
			out.writeObject(shell.bhm);
			out.close();
		} catch (IOException ex) {
			System.out.println("Non ho potuto salvare l'oggetto (errore nel filesystem).");
		}
	}
}
