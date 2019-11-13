package akcije;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

import org.w3c.dom.views.DocumentView;

import event.UpdateListener;
import main.MainFrame;
import model.Element;
import model.GrafickiSlot;
import model.Slot;
import model.Stranica;
import view.DokumentView;
import view.GrafickiSlotView;
import view.ProjekatView;
import view.SlotView;
import view.StranicaView;

public class DodajGrafickiSlotAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		Object o = MainFrame.getInstance().getTree().getLastSelectedPathComponent();
		TreePath path = MainFrame.getInstance().getTree().getSelectionPath();
			if(o instanceof Stranica) {
				GrafickiSlot s1 = new GrafickiSlot("");
				int a = ((Stranica) o).getChildCount() + 1;
				s1.setNaziv("Element_Grafika_" + a);
				((Stranica) o).add(s1);
				s1.getListenerList().add(UpdateListener.class, (UpdateListener)path.getPathComponent(1));
				s1.fireUpdatePerformed();
				MainFrame.getInstance().getTree().expandPath(path);
				SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
//				
				
				GrafickiSlotView sw = new GrafickiSlotView();
				sw.setSlot(s1);
				s1.getModel().getListenerList().add(UpdateListener.class, (UpdateListener)sw);
				s1.getSelectionModel().getListaListenera().add(UpdateListener.class, (UpdateListener)sw);
				
				for(Component i : MainFrame.getInstance().getDesniDesktop().getComponents()){
					if(i instanceof ProjekatView){
						ProjekatView tmp = (ProjekatView) i;
						for(DokumentView j : tmp.getLista()){
							DokumentView tmp2 = j;
							for(DokumentView dview : j.getDeljeni()) {
								for(StranicaView sview : dview.getLista()) {
									if(sview.getStranica().equals((Stranica)o)) {
										GrafickiSlotView pomocni = new GrafickiSlotView();
										pomocni.setSlot(s1);
										sview.add(pomocni);
										sview.dodaj(pomocni);
										dview.repaint();
										dview.revalidate();
									}
								}
							}
							for (StranicaView k : tmp2.getLista()) {
								if (k.getStranica().equals((Stranica) o)) {
									k.add(sw);
									k.dodaj(sw);
									i.repaint();
									i.revalidate();
									// for(StranicaView sview : k.getDeljeni()) {
									// System.out.println("Usao");
									// GrafickiSlotView pomocni = new
									// GrafickiSlotView();
									// pomocni.setGs(s1);
									// sview.add(pomocni);
									// sview.dodaj(pomocni);
									// sview.repaint();
									// sview.revalidate();
									// }
									return;
								}
						}
					}
				}
			}

		}
	}
}
