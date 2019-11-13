package akcije;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

import main.MainFrame;
import model.Dokument;
import model.Stranica;
import view.DokumentView;
import view.ProjekatView;
import view.StranicaView;

public class UkloniStranicuAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		TreePath path = MainFrame.getInstance().getTree().getSelectionPath();
		Object o1 = path.getPathComponent(2);
		Object o2 = MainFrame.getInstance().getTree().getLastSelectedPathComponent();
		if (o1 instanceof Dokument && o2 instanceof Stranica) {
			((Dokument) o1).remove(o2);
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
			for (Component i : MainFrame.getInstance().getDesniDesktop().getComponents()) {
				if (i instanceof ProjekatView) {
					ProjekatView tmp = (ProjekatView) i;
					for (DokumentView j : tmp.getLista()) {
						if (j.getDokument().equals((Dokument) o1)) {
							for (StranicaView sv : j.getLista()) {
								if (sv.getStranica().getNaziv().equals(((Stranica) o2).getNaziv())) {
									j.remove(sv);
									j.obrisi(sv);
									i.repaint();
									i.revalidate();
									return;
								}
							}
						}
					}
				}
			}
		}
	}

}
