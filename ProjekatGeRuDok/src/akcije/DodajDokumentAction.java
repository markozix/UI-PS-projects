package akcije;

import java.awt.Component; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

import event.UpdateListener;
import main.MainFrame;
import model.Dokument;
import model.Projekat;
import view.DokumentView;
import view.ProjekatView;

public class DodajDokumentAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object o = MainFrame.getInstance().getTree().getLastSelectedPathComponent();
		TreePath path = MainFrame.getInstance().getTree().getSelectionPath();
		if (o instanceof Projekat) {
			Dokument d = new Dokument("");
			int a = ((Projekat) o).getChildCount() + 1;
			d.setNaziv("Dokument_" + a);
			((Projekat) o).add(d);
			d.getListenerList().add(UpdateListener.class, (UpdateListener)o);
			d.fireUpdatePerformed();
			MainFrame.getInstance().getTree().expandPath(path);
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
			DokumentView view = new DokumentView();
			view.setDokument(d);
//			ProjekatView view2 = new ProjekatView();
			for (Component i : MainFrame.getInstance().getDesniDesktop().getComponents()) {
				if (i instanceof ProjekatView) {
					ProjekatView tmp = (ProjekatView) i;
					if (o.toString().equals(tmp.getProjekat().toString())) {
//						view2 = tmp;
						tmp.dodaj(view);
						tmp.getTabovi().addTab(d.getNaziv(), view.getContentPane());
						return;
					}
				}
			}
//			view2.dodaj(view);
//			view2.getTabovi().addTab(d.getNaziv(), view.getContentPane());
		}
	}
}
