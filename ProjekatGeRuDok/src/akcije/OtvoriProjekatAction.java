package akcije;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;

import event.UpdateListener;
import komande.CommandManager;
import main.MainFrame;
import model.Dokument;
import model.GrafickiSlot;
import model.Projekat;
import model.Slot;
import model.Stranica;
import model.TekstualniSlot;
import state.StateManager;
import view.DokumentView;
import view.GrafickiSlotView;
import view.ProjekatView;
import view.SlotView;
import view.StranicaView;
import view.TekstualniSlotView;

public class OtvoriProjekatAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new SlotFileFilter());
		fc.setDialogTitle("Choose a project");
		int result = fc.showOpenDialog(MainFrame.getInstance());
		if(result == JFileChooser.APPROVE_OPTION) {
			Projekat p = null;
			try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(fc.getSelectedFile()));
				p = (Projekat)in.readObject();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			MainFrame.getInstance().getTree().addProjekat(p);
			ProjekatView pview = new ProjekatView();
			pview.setProjekat(p);
			MainFrame.getInstance().getDesniDesktop().add(pview);
			for(int i = 0; i < p.getChildCount(); i++) {
				Dokument d = (Dokument)p.getChildAt(i);
				DokumentView dview = new DokumentView();
				dview.setDokument(d);
				pview.dodaj(dview);
				pview.getTabovi().addTab(d.getNaziv(), dview.getContentPane());
				for(int j = 0; j < d.getChildCount(); j++) {
					Stranica s = (Stranica)d.getChildAt(j);
					StranicaView sview = new StranicaView();
					sview.setStranica(s);
					dview.add(sview);
					dview.dodaj(sview);
					for(int k = 0; k < s.getChildCount(); k++) {
						if(s.getChildAt(k) instanceof GrafickiSlot) {
							GrafickiSlot gsl = (GrafickiSlot)s.getChildAt(k);
							GrafickiSlotView gslview = new GrafickiSlotView();
							StateManager sm = new StateManager(gsl);
							CommandManager cm = new CommandManager();
							gsl.setCommandManager(cm);
							gsl.setStateManager(sm);
							gsl.getModel().getListenerList().add(UpdateListener.class, (UpdateListener)gslview);
							gsl.getSelectionModel().getListaListenera().add(UpdateListener.class, (UpdateListener)gslview);
							gslview.setSlot(gsl);
							sview.add(gslview);
							sview.dodaj(gslview);
						} else {
							TekstualniSlot tsl = (TekstualniSlot)s.getChildAt(k);
							TekstualniSlotView tslview = new TekstualniSlotView();
							tslview.setTs(tsl);
							tsl.getModel().getListenerList().add(UpdateListener.class, (UpdateListener)tslview);
							sview.add(tslview);
							sview.dodaj(tslview);
						}
					}
				}
			}
		}
	}

}
