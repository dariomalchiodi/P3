import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.printing.PrintDialog;
import org.eclipse.swt.printing.PrinterData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.FontDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

@SuppressWarnings("unused")

public class TestDialog {

	public static void main(String[] args) {
		Shell shell = new Shell(Display.getDefault());
		
		String[] fileExtensions = { "*.*" };
		FileDialog dialog = new FileDialog(shell, SWT.OPEN);
		dialog.setText("Apri file");
		dialog.setFilterPath("~");
		dialog.setFilterExtensions(fileExtensions);
		String fileName = dialog.open();
		
		if( fileName == null ) {
			System.out.println("Operazione annullata.");
		}
		else System.out.println("File scelto: " + fileName);
		
		dialog = new FileDialog(shell, SWT.SAVE);
		dialog.setText("Salva file");
		dialog.setFilterPath("~");
		dialog.setFilterExtensions(fileExtensions);
		fileName = dialog.open();
//		
//		if( fileName == null ) 
//			System.out.println("Operazione annullata.");
//		else System.out.println("File scelto: " + fileName);
		
		
//		FontData defaultFontData[] = new FontData[] { 
//				new FontData("Courier", 12, SWT.ITALIC) };
//		FontDialog fd = new FontDialog(shell, SWT.NONE);
//		fd.setText("Scegli le proprietà del testo");
//	
//		fd.setRGB(new RGB(0, 255, 255));
//		fd.setFontList(defaultFontData);
//	
//		FontData fontData = fd.open();
//		if( fontData == null )
//			System.out.println("Operazione annullata.");
//		else {
//			System.out.println("Famiglia: " + fontData.getName());
//			System.out.println("Corpo: " + fontData.getHeight());
//			System.out.println("Stile: " + fontData.getStyle());
//			System.out.println("Colore: " + fd.getRGB());
//		}
//		
//		PrintDialog pd = new PrintDialog(shell, SWT.NONE);
//		pd.setText("Stampa");
//		pd.setScope(PrinterData.PAGE_RANGE);
//		pd.setStartPage(2);
//		pd.setEndPage(54);
//		pd.setPrintToFile(true);
//		PrinterData pdata = pd.open();
//		
//		if( pdata != null ) {
//			switch(pdata.scope) {
//			case PrinterData.ALL_PAGES:
//				System.out.println("Stampo tutte le pagine.");
//				break;
//			case PrinterData.SELECTION:
//				System.out.println("Stampo la pagina selezionata.");
//				break;
//			case PrinterData.PAGE_RANGE:
//				System.out.println("Stampo da pagina " + pdata.startPage + " a pagina " +  pdata.endPage + ".");
//				break;
//			}
//			
//			if( pdata.printToFile )
//				System.out.println("Stampo su file");
//			else System.out.println("Stampo su carta");
//			
//			if( pdata.collate )
//				System.out.println("Fascicolo.");
//			else System.out.println("Non fascicolo.");
//			
//			System.out.println("Numero di copie: " + pdata.copyCount);
//			System.out.println("Stampante selezionata: " + pdata.name);
//		}
//		
//		int[] style = {SWT.ICON_ERROR, SWT.ICON_INFORMATION, SWT.ICON_QUESTION,
//				SWT.ICON_WARNING, SWT.ICON_WORKING, SWT.OK, SWT.OK | SWT.CANCEL, 
//				SWT.YES | SWT.NO, SWT.YES | SWT.NO | SWT.CANCEL,
//				SWT.RETRY | SWT.CANCEL, SWT.ABORT | SWT.RETRY | SWT.IGNORE
//		};
//		
//		for(int s: style) {
//			MessageBox m = new MessageBox(shell, s);
//			m.setMessage("tipo " + s);
//			m.setText("Questa finestra ha come stile " + s);
//			int result = m.open();
//			System.out.println("Il risultato è " + result);
//		}
//		
	}
	
}
