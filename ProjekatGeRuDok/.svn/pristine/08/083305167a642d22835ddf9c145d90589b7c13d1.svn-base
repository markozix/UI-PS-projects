package projectTree;

import javax.swing.JTree;
import javax.swing.SwingUtilities;

import model.Dokument;

public class PomocniTree extends JTree {

	public PomocniTree() {
		setEditable(true);
	}
	
	public void addDokument(Dokument dokument) {
		((PomocniModel)getModel()).add(dokument);
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	public void removeDokument(Dokument dokument) {
		((PomocniModel)getModel()).remove(dokument);
		SwingUtilities.updateComponentTreeUI(this);
	}
}
