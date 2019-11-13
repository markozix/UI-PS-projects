package workspace;

import javax.swing.CellRendererPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;

import modeli.InformacioniResurs;

public class WorkspaceTree extends JTree {
	
	public WorkspaceTree() {
		setCellRenderer(new WorkspaceTreeCellRenderer());
		setEditable(false);
	}
	
	public void addInformacioniResurs(InformacioniResurs informacioniResurs) {
		((WorkspaceModel)getModel()).add(informacioniResurs);
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	public void removeInformacioniResurs(InformacioniResurs informacioniResurs) {
		((WorkspaceModel)getModel()).remove(informacioniResurs);
		SwingUtilities.updateComponentTreeUI(this);
	}

}
