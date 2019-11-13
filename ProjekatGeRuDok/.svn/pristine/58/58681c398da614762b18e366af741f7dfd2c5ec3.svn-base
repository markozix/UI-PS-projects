package workspace;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;

import model.Dokument;
import model.Projekat;
import model.Slot;
import model.Stranica;

public class WorkspaceTreeEditor extends DefaultTreeCellEditor implements ActionListener {
	private Object stavka = null;
	private JTextField edit = null;
	
	public WorkspaceTreeEditor(JTree tree, DefaultTreeCellRenderer renderer) {
		super(tree, renderer);
	}
	
	@Override
	public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded,
			boolean leaf, int row) {
		stavka = value;
		
		edit = new JTextField(value.toString());
		edit.addActionListener(this);
		return edit;
	}
	
	@Override
	public boolean isCellEditable(EventObject event) {
		if(event instanceof MouseEvent) {
			if(((MouseEvent)event).getClickCount() == 2)
				return true;
		}
		return false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(stavka instanceof Projekat) {
			String pomocni = ((Projekat)stavka).getNaziv();
			((Projekat)stavka).setNaziv(e.getActionCommand());
			if(((Projekat)stavka).getNaziv().contains(" ")) {
				((Projekat)stavka).setNaziv(pomocni);
			}
		} else if(stavka instanceof Dokument) {
			((Dokument)stavka).setNaziv(e.getActionCommand());
		} else if(stavka instanceof Stranica) {
			((Stranica)stavka).setNaziv(e.getActionCommand());
		} else if(stavka instanceof Slot) {
			((Slot)stavka).setNaziv(e.getActionCommand());
		}
	}

}
