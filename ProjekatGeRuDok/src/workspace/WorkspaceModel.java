package workspace;

import java.io.File;

import javax.swing.tree.DefaultTreeModel;

import model.Projekat;
import model.Workspace;

public class WorkspaceModel extends DefaultTreeModel{
	
	public WorkspaceModel(File f) {
		super(new Workspace(f));
	}

	public void add(Projekat projekat) {
		((Workspace)getRoot()).add(projekat);
	}
	
	public void remove(Projekat projekat) {
		((Workspace)getRoot()).remove(projekat);
	}
}
