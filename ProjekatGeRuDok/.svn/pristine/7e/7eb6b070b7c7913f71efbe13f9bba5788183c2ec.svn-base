package akcije;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

import main.MainFrame;
import model.Dokument;
import model.DokumentSelection;
import model.Projekat;
import model.Slot;
import model.SlotSelection;
import model.Stranica;
import model.StranicaSelection;
import view.DokumentView;
import view.GrafickiSlotView;
import view.ProjekatView;
import view.SlotView;
import view.StranicaView;
import view.TekstualniSlotView;

public class CutAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		TreePath path = MainFrame.getInstance().getTree().getSelectionPath();
		Object o = MainFrame.getInstance().getTree().getLastSelectedPathComponent();

		if (o instanceof Dokument) {
			Dokument d = (Dokument) o;
			ArrayList<Dokument> tmp = new ArrayList<>();
			tmp.add(d);
			DokumentSelection content = new DokumentSelection(tmp);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(content, null);
			// brisanje
			Object o1 = path.getPathComponent(1);
			((Projekat) o1).remove(o);
			for (Component i : MainFrame.getInstance().getDesniDesktop().getComponents()) {
				if (i instanceof ProjekatView) {
					ProjekatView tmpX = (ProjekatView) i;
					if (((Projekat) o1).getNaziv().equals(tmpX.getProjekat().getNaziv())) {
						for (int j = 0; j <= tmpX.getTabovi().getTabCount(); j++) {
							String s = tmpX.getTabovi().getTitleAt(j);
							if (s.equals(((Dokument) o).getNaziv())) {
								tmpX.getTabovi().remove(j);
								for (DokumentView k : tmpX.getLista()) {
									if (k.getDokument().getNaziv().equals(((Dokument) o).getNaziv())) {
										tmpX.obrisi(k);
										break;
									}
								}
								tmpX.repaint();
								tmpX.revalidate();
								return;
							}
						}
					}
				}
			}
		}
		if (o instanceof Stranica) {
			Stranica s = (Stranica) o;
			ArrayList<Stranica> tmp = new ArrayList<>();
			tmp.add(s);
			StranicaSelection content = new StranicaSelection(tmp);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(content, null);
			//brisanje
			Object o1 = path.getPathComponent(2);
			if(o1 instanceof Dokument){
				((Dokument)o1).remove(o);
				SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
				for(Component i: MainFrame.getInstance().getDesniDesktop().getComponents()){
					if(i instanceof ProjekatView){
						ProjekatView tmpX = (ProjekatView) i;
						for(DokumentView j : tmpX.getLista()){
							if(j.getDokument().equals((Dokument)o1)){
								for(StranicaView sv : j.getLista()){
									if(sv.getStranica().getNaziv().equals(((Stranica) o).getNaziv())){
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
		if (o instanceof Slot) {
			Slot s = (Slot) o;
			ArrayList<Slot> tmp = new ArrayList<>();
			tmp.add(s);
			SlotSelection content = new SlotSelection(tmp);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(content, null);
			//brisanje
			Object o1 = path.getPathComponent(3);
			if(o1 instanceof Stranica){
				((Stranica)o1).remove(o);
				SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
				for (Component i : MainFrame.getInstance().getDesniDesktop().getComponents()) {
					if (i instanceof ProjekatView) {
						ProjekatView tmpX = (ProjekatView) i;
						for (DokumentView j : tmpX.getLista()) {
							for (StranicaView sv : j.getLista()) {
								if (sv.getStranica().equals((Stranica) o1)) {
									for (SlotView sv1 : sv.getLista()) {
										String provera = ((Slot) o).getNaziv();
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
}
