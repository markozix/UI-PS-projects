package akcije;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

import main.MainFrame;
import model.Slot;
import model.Stranica;
import view.DokumentView;
import view.ProjekatView;
import view.SlotView;
import view.StranicaView;

public class DodajSlotAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = MainFrame.getInstance().getTree().getLastSelectedPathComponent();
		TreePath path = MainFrame.getInstance().getTree().getSelectionPath();
		if (o instanceof Stranica) {
			Slot s = new Slot("");
			int a = ((Stranica) o).getChildCount() + 1;
			s.setNaziv("Slot_" + a);
			((Stranica) o).add(s);
			MainFrame.getInstance().getTree().expandPath(path);
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
			
			
			
		}
	}

}
