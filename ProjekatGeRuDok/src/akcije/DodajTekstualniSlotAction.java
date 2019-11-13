package akcije;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

import event.UpdateListener;
import main.MainFrame;
import model.Projekat;
import model.Stranica;
import model.TekstualniSlot;
import view.DokumentView;
import view.ProjekatView;
import view.StranicaView;
import view.TekstualniSlotView;

public class DodajTekstualniSlotAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {

		Object o = MainFrame.getInstance().getTree().getLastSelectedPathComponent();
		TreePath path = MainFrame.getInstance().getTree().getSelectionPath();
		if (o instanceof Stranica) {
			TekstualniSlot s1 = new TekstualniSlot("");
			int a = ((Stranica) o).getChildCount() + 1;
			s1.setNaziv("Element_Tekst_" + a);
			((Stranica) o).add(s1);
			s1.getListenerList().add(UpdateListener.class, (UpdateListener) path.getPathComponent(1));
			s1.fireUpdatePerformed();
			MainFrame.getInstance().getTree().expandPath(path);
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
			s1.getListenerList().add(UpdateListener.class, (UpdateListener) path.getPathComponent(1));
			s1.fireUpdatePerformed();
			s1.getModel().getListenerList().add(UpdateListener.class, (UpdateListener) path.getPathComponent(1));

			TekstualniSlotView sw = new TekstualniSlotView();
			sw.setTs(s1);
			s1.getModel().getListenerList().add(UpdateListener.class, (UpdateListener) sw);

			for (Component i : MainFrame.getInstance().getDesniDesktop().getComponents()) {
				if (i instanceof ProjekatView) {
					ProjekatView tmp = (ProjekatView) i;
					Projekat tmpX = (Projekat) path.getPathComponent(1);
					if (tmpX.equals(tmp.getProjekat())) {
						for (DokumentView j : tmp.getLista()) {
							DokumentView tmp2 = j;
							for (DokumentView dview : j.getDeljeni()) {
								for (StranicaView sview : dview.getLista()) {
									if (sview.getStranica().equals((Stranica) o)) {
										TekstualniSlotView pomocni = new TekstualniSlotView();
										pomocni.setTs(s1);
										sview.add(pomocni);
										sview.dodaj(pomocni);
										dview.repaint();
										dview.revalidate();
									}
								}
							}
							for (StranicaView k : tmp2.getLista()) {
								System.out.println("Stigao");
								if (k.getStranica().equals(((Stranica) o))) {
									System.out.println(k.getStranica().getNaziv());
									k.add(sw);
									k.dodaj(sw);
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
