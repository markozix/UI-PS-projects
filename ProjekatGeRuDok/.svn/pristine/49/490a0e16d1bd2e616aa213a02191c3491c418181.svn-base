package akcije;

import java.awt.Component;
import java.awt.MenuComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

import main.MainFrame;
import model.Dokument;
import model.Projekat;
import view.DokumentView;
import view.ProjekatView;

public class UkloniDokumentAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		TreePath path = MainFrame.getInstance().getTree().getSelectionPath();
		Object o1 = path.getPathComponent(1);
		Object o2 = MainFrame.getInstance().getTree().getLastSelectedPathComponent();
		if (o1 instanceof Projekat && o2 instanceof Dokument) {
			((Projekat) o1).remove(o2);
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
			for (Component i : MainFrame.getInstance().getDesniDesktop().getComponents()) {
				if (i instanceof ProjekatView) {
					ProjekatView tmp = (ProjekatView) i;
					if (((Projekat) o1).getNaziv().equals(tmp.getProjekat().getNaziv())) {
						for (int j = 0; j <= tmp.getTabovi().getTabCount(); j++) {
							String s = tmp.getTabovi().getTitleAt(j);
							if (s.equals(((Dokument) o2).getNaziv())) {
								tmp.getTabovi().remove(j);
								for (DokumentView k : tmp.getLista()) {
									if (k.getDokument().getNaziv().equals(((Dokument) o2).getNaziv())) {
										tmp.obrisi(k);
										break;
									}
								}
								tmp.repaint();
								tmp.revalidate();
								return;
							}
						}
					}
				}
			}
		}
	}
}
