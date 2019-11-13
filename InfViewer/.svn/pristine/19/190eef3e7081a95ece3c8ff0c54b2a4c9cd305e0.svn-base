package workspace;

import java.io.File;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import modeli.InformacioniResurs;
import modeli.Workspace;
import modeli.Atribut;

public class WorkspaceModel extends DefaultTreeModel {
	

	public WorkspaceModel() {
		super(new Workspace());
	}

	public void add(InformacioniResurs informacioniResurs) {
		((Workspace)getRoot()).add(informacioniResurs);
	}
	
	public void remove(InformacioniResurs informacioniResurs) {
		((Workspace)getRoot()).remove(informacioniResurs);
	}

}