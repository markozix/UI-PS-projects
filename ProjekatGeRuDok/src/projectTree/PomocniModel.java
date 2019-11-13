package projectTree;

import javax.swing.tree.DefaultTreeModel;

import model.Dokument;

public class PomocniModel extends DefaultTreeModel {

	public PomocniModel() {
		super(new PomocniProjekat());
	}

	public void add(Dokument dokument) {
		((PomocniProjekat)getRoot()).add(dokument);
	}
	
	public void remove(Dokument dokument) {
		((PomocniProjekat)getRoot()).remove(dokument);
	}
}
