package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

import main.MainFrame;
import modeli.Atribut;
import modeli.Entitet;
import modeli.InformacioniResurs;
import modeli.Relacija;

public class DodajEntitetAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = MainFrame.getInstance().getTree().getLastSelectedPathComponent();
		TreePath path = MainFrame.getInstance().getTree().getSelectionPath();
		if(o instanceof InformacioniResurs && !(o instanceof Entitet) && !(o instanceof Atribut) && !(o instanceof Relacija)) {
			Entitet ent = new Entitet();
			ent.setNaziv("Entitet");
			((InformacioniResurs)o).add(ent);
			MainFrame.getInstance().getTree().expandPath(path);
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
		}
	}

}
