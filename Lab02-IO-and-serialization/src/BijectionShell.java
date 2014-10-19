
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


public class BijectionShell extends Shell {

	@Override
	protected void checkSubclass() {}
	
	BijectiveHashMap<String, String> bhm;
	private final Text tKey;
	private final Text tValue;
	private final List lBijection;
	private Display display;
	private boolean saved;
	
	public BijectionShell(Display d, BijectiveHashMap<String, String> b) {
		super(d);
		display = d;
		bhm = b;
		saved = (bhm.size() == 0);
		setLayout( new GridLayout( 3, true ) );
		tKey = new Text(this, SWT.NONE);
		tValue = new Text(this, SWT.NONE);
		GridData gFillH = new GridData(GridData.FILL_HORIZONTAL);
		tKey.setLayoutData(gFillH);
		tValue.setLayoutData(gFillH);

		Button bAdd = new Button(this, SWT.PUSH);
		bAdd.setText("Add");
		bAdd.addSelectionListener(
			new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					String key = tKey.getText();
					String value = tValue.getText();
					try {
						bhm.put(key, value);
						refresh();
					} catch(IllegalStateException ex) {
						MessageBox m = new MessageBox(BijectionShell.this, SWT.ICON_WARNING);
						m.setMessage("La coppia viola l'integrità della biiezione");
						m.setText("Errore");
						m.open();
					}
				}
			}
		);
		
		lBijection = new List(this, SWT.MULTI | SWT.V_SCROLL);	
		GridData gFill = new GridData(GridData.FILL_BOTH);
		gFill.horizontalSpan = 2;
		lBijection.setLayoutData(gFill);
		refresh();
		
		Composite c = new Composite(this, SWT.NONE);
		FillLayout f = new FillLayout(SWT.VERTICAL);
		c.setLayout(f);
		
		Button bRemove = new Button(c, SWT.PUSH);
		bRemove.setText("Remove");
		bRemove.addSelectionListener(
			new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					String[] selection = lBijection.getSelection();
					for(String pair : selection) {
						String key = pair.substring(0, pair.indexOf(" <-> "));
						bhm.remove(key);
					}
					refresh();
					saved = false;
				}
			}
		);
		Button bClear = new Button(c, SWT.PUSH);
		bClear.setText("Clear");
		bClear.addSelectionListener(
			new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					bhm.clear();
					refresh();
					saved = false;
				}
			}
		);
		
		Menu menu = new Menu(this, SWT.BAR);
		this.setMenuBar(menu);
		MenuItem file = new MenuItem(menu, SWT.CASCADE);
		file.setText("File");
		
		Menu fileMenu = new Menu(this, SWT.DROP_DOWN);
		file.setMenu(fileMenu);
		
		MenuItem load = new MenuItem(fileMenu, SWT.PUSH);
		load.setText("&Carica...\tCtrl+C");
		load.setAccelerator(SWT.CTRL+'C');
		load.addSelectionListener(
			new SelectionAdapter() {
				@SuppressWarnings("unchecked")
				public void widgetSelected(SelectionEvent e) {
					checkSaved();
					FileDialog dialog = new FileDialog(BijectionShell.this, SWT.OPEN);
					dialog.setText("Apri file");
					String fileName = dialog.open();
					
					if( fileName == null ) {
						System.out.println("Apertura file annullata.");
						return;
					}
					
					FileInputStream fis = null;
					ObjectInputStream in = null;
					
					try {
						fis = new FileInputStream(fileName);
						in = new ObjectInputStream(fis);
						bhm = (BijectiveHashMap<String, String>)in.readObject();
						refresh();
						saved = true;
						in.close();
						fis.close();
					} catch(IOException ex1) {
						System.out.println("Non ho potuto caricare l'oggetto (errore nel filesystem).");
					} catch(ClassNotFoundException ex2) {
						System.out.println("Il contenuto del file è corrotto.");
					}	
					
				
				}
			}
		);
		Image iLoad = new Image(display, "serialization-laboratorio/load.jpeg");
		Image iLoadScaled = new Image(display, iLoad.getImageData().scaledTo(30, 20));
		load.setImage(iLoadScaled);
		iLoad.dispose();
		
		@SuppressWarnings("unused")
		MenuItem sep = new MenuItem(fileMenu, SWT.SEPARATOR);
		
		MenuItem save = new MenuItem(fileMenu, SWT.PUSH);
		save.setText("&Salva...\tCtrl+S");
		save.setAccelerator(SWT.CTRL+'S');
		save.addSelectionListener(
			new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					new SaveBijectionCommand(BijectionShell.this).execute();
					saved = true;
				}

			}
		);
		Image iSave = new Image(display, "serialization-laboratorio/save.jpeg");
		Image iSaveScaled = new Image(display, iSave.getImageData().scaledTo(30, 20));
		save.setImage(iSaveScaled);
		iSave.dispose();
	}
	
	void refresh() {
		System.out.println("in refresh");
		lBijection.setItems(new String[] {});
		for(Map.Entry<String, String> me : bhm.entrySet())
			lBijection.add(me.getKey() + " <-> " + me.getValue());
	}
	
	private void checkSaved() {
		if(!saved) {
			MessageBox m = new MessageBox(this, SWT.ICON_WARNING | SWT.YES | SWT.NO);
			m.setMessage("La biiezione non è stata salvata. Vuoi salvarla?");
			m.setText("Verifica salvataggio");
			int result = m.open();
			if( result == SWT.YES )
				new SaveBijectionCommand(this).execute();
		}
	}
	
	
	public static void main(String args[]) {
		Display display = Display.getDefault();
		
		BijectiveHashMap<String, String> bhm =
			new BijectiveHashMap<String, String>();
		Date d1 = new Date( 100000 );
		Date d2 = new Date( 200000 );
		Date d3 = new Date( 300000 );

		String s1 = new String( "Consiglio di dipartimento" );
		String s2 = new String( "Consiglio di facoltà" );
		String s3 = new String( "Consiglio del corso di laurea" );

		bhm.put( d1.toString(), s1 );
		bhm.put( d2.toString(), s2 );
		bhm.put( d3.toString(), s3 );
		
		BijectionShell bs = new BijectionShell(display, bhm);
		
		bs.pack();
		bs.open();
		
		while ( !bs.isDisposed() ) {
			if ( !display.readAndDispatch() )
				display.sleep();
		}
	}
	
}
