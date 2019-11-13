package workspace;

import java.awt.Component;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import model.Dokument;
import model.Projekat;
import model.Slot;
import model.Stranica;

public class WorkspaceTreeCellRenderer extends DefaultTreeCellRenderer {

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
			int row, boolean hasFocus) {
		
		if(value instanceof Projekat) {
			
		}
		
		if(value instanceof Dokument) {
			
		}
		
		if(value instanceof Stranica) {
			
		}
		
		if(value instanceof Slot) {
			
		}
		
		return super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
		
	}
}
