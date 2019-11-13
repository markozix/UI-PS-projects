package akcije;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

import event.UpdateListener;
import main.MainFrame;
import model.Dokument;
import model.Stranica;
import view.DokumentView;
import view.ProjekatView;
import view.StranicaView;

public class DodajStranicuAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = MainFrame.getInstance().getTree().getLastSelectedPathComponent();
		TreePath path = MainFrame.getInstance().getTree().getSelectionPath();
		if (o instanceof Dokument) {
			Stranica s = new Stranica("");
			int a = ((Dokument) o).getChildCount() + 1;
			s.setNaziv("Stranica_" + a);
			((Dokument) o).add(s);
			s.getListenerList().add(UpdateListener.class, (UpdateListener)path.getPathComponent(1));
			s.fireUpdatePerformed();
			MainFrame.getInstance().getTree().expandPath(path);
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
			StranicaView view = new StranicaView();
			view.setStranica(s);
			for (Component i : MainFrame.getInstance().getDesniDesktop().getComponents()) {
				if (i instanceof ProjekatView) {
					ProjekatView tmp = (ProjekatView) i;
					for (DokumentView j : tmp.getLista()) {
						if (j.getDokument().equals((Dokument) o)) {
							j.add(view);
							j.dodaj(view);
							i.repaint();
							i.revalidate();
							for(DokumentView dview : j.getDeljeni()) {
								StranicaView pomocni = new StranicaView();
								pomocni.setStranica(s);
								dview.add(pomocni);
								dview.dodaj(pomocni);
								dview.repaint();
								dview.revalidate();
//								view.getDeljeni().add(pomocni);
							}
							return;
						}
					}
				
				}
				
			}
		}
	}
	

}
