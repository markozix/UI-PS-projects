package akcije;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

import event.UpdateListener;
import main.MainFrame;
import model.GrafickiSlot;
import model.Projekat;
import model.Stranica;
import model.TekstualniSlot;
import view.DokumentView;
import view.GrafickiSlotView;
import view.ProjekatView;
import view.StranicaView;
import view.TekstualniSlotView;

public class DodajDeljeniAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = MainFrame.getInstance().getTree().getLastSelectedPathComponent();
		TreePath path = MainFrame.getInstance().getTree().getSelectionPath();
		if(o instanceof Projekat) {
			((Projekat)o).add(MainFrame.getInstance().getDokumentZaDeljenje());
			MainFrame.getInstance().getDokumentZaDeljenje().getListenerList().add(UpdateListener.class,
					(UpdateListener)o);
			MainFrame.getInstance().getDokumentZaDeljenje().fireUpdatePerformed();
			MainFrame.getInstance().getTree().expandPath(path);
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
			DokumentView view = new DokumentView();
			MainFrame.getInstance().getViewZaDeljenje().getDeljeni().add(view);
			view.getDeljeni().add(MainFrame.getInstance().getViewZaDeljenje());
			view.setDokument(MainFrame.getInstance().getDokumentZaDeljenje());
			ProjekatView view2 = new ProjekatView();
			for (Component i : MainFrame.getInstance().getDesniDesktop().getComponents()) {
				if (i instanceof ProjekatView) {
					ProjekatView tmp = (ProjekatView) i;
					if (o.toString().equals(tmp.getProjekat().toString())) {
						view2 = tmp;
					}
				}
			}
			view2.dodaj(view);
			view2.getTabovi().addTab(MainFrame.getInstance().getDokumentZaDeljenje().getNaziv(), 
					view.getContentPane());
			for(int j = 0; j < MainFrame.getInstance().getDokumentZaDeljenje().getChildCount(); j++) {
				StranicaView sview = new StranicaView();
				Stranica s = (Stranica)MainFrame.getInstance().getDokumentZaDeljenje().getChildAt(j);
				sview.setStranica(s);
				view.add(sview);
				view.dodaj(sview);
				for(int k = 0; k < s.getChildCount(); k++) {
					if(s.getChildAt(k) instanceof GrafickiSlot) {
						GrafickiSlot gsl = (GrafickiSlot)s.getChildAt(k);
						GrafickiSlotView gslview = new GrafickiSlotView();
						gslview.setSlot(gsl);
						sview.add(gslview);
						sview.dodaj(gslview);
					} else {
						TekstualniSlot tsl = (TekstualniSlot)s.getChildAt(k);
						TekstualniSlotView tslview = new TekstualniSlotView();
						tslview.setTs(tsl);
						sview.add(tslview);
						sview.dodaj(tslview);
					}
				}
			}
		}
	}

}
