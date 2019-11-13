package workspace;

import java.awt.Component;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

import modeli.Atribut;
import modeli.Entitet;
import modeli.InformacioniResurs;



public class WorkspaceTreeCellRenderer extends DefaultTreeCellRenderer {

	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
			int row, boolean hasFocus) {
		
		if(value instanceof InformacioniResurs) {
			
		}
		
		if(value instanceof Entitet) {
			
		}
		
		if(value instanceof Atribut) {
			
		}
	
		return super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
		
	}
	

}
