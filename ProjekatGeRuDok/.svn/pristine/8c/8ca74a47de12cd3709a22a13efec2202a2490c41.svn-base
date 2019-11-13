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
import view.GrafickiSlotView;
import view.ProjekatView;
import view.SlotView;
import view.StranicaView;
import view.TekstualniSlotView;

public class UkloniSlotAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		TreePath path = MainFrame.getInstance().getTree().getSelectionPath();
		Object o1 = path.getPathComponent(3);
		Object o2 = MainFrame.getInstance().getTree().getLastSelectedPathComponent();
		if (o1 instanceof Stranica && o2 instanceof Slot) {
			((Stranica) o1).remove(o2);
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
			for (Component i : MainFrame.getInstance().getDesniDesktop().getComponents()) {
				if (i instanceof ProjekatView) {
					ProjekatView tmp = (ProjekatView) i;
					for (DokumentView j : tmp.getLista()) {
						for (StranicaView sv : j.getLista()) {
							if (sv.getStranica().equals((Stranica) o1)) {
								for (SlotView sv1 : sv.getLista()) {
									String provera = ((Slot) o2).getNaziv();
									if (sv1 instanceof GrafickiSlotView) {
										if (provera.equals(((GrafickiSlotView) sv1).getSlot().getNaziv())) {
											sv.remove(sv1);
											sv.obrisi(sv1);
											i.repaint();
											i.revalidate();
											return;
										}
									} else if (sv1 instanceof TekstualniSlotView) {
										if (provera.equals(((TekstualniSlotView) sv1).getTs().getNaziv())) {
											sv.remove(sv1);
											sv.obrisi(sv1);
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
	}
}
