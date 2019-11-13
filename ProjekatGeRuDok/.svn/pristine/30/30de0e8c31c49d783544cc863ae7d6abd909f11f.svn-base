package akcije;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

import event.UpdateListener;
import komande.CommandManager;
import main.BiranjeWorkspacea;
import main.Main;
import main.MainFrame;
import model.Dokument;
import model.GrafickiSlot;
import model.Projekat;
import model.Stranica;
import model.Workspace;
import state.StateManager;
import view.DokumentView;
import view.GrafickiSlotView;
import view.ProjekatView;
import view.StranicaView;
import workspace.WorkspaceModel;
import workspace.WorkspaceTree;

public class OWSokAction implements ActionListener {
	BiranjeWorkspacea w;

	public OWSokAction(BiranjeWorkspacea w) {
		this.w = w;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (BiranjeWorkspacea.getTf().getText().isEmpty()) {
			System.out.println("Niste izabrali workspace");
			System.exit(0);
		} else if (!BiranjeWorkspacea.getTf().getText().substring(BiranjeWorkspacea.getTf().getText().length() - 3)
				.equals("txt")) {
			System.out.println("Niste izabrali odgovarajuci tip fajla");
			System.exit(0);
		} else {
			File fajl = BiranjeWorkspacea.getFajl();
			Main.uradi();
			Projekat p = null;
			if (fajl != null) {
				try {
					Scanner sc = new Scanner(fajl);

					while (sc.hasNextLine()) {

						ObjectInputStream in = new ObjectInputStream(new FileInputStream(sc.nextLine()));
						p = (Projekat) in.readObject();

						MainFrame.getInstance().getTree().addProjekat(p);
						ProjekatView pview = new ProjekatView();
						pview.setProjekat(p);
						MainFrame.getInstance().getDesniDesktop().add(pview);
						for (int i = 0; i < p.getChildCount(); i++) {
							Dokument d = (Dokument) p.getChildAt(i);
							DokumentView dview = new DokumentView();
							dview.setDokument(d);
							pview.dodaj(dview);
							pview.getTabovi().addTab(d.getNaziv(), dview.getContentPane());
							for (int j = 0; j < d.getChildCount(); j++) {
								Stranica s = (Stranica) d.getChildAt(j);
								StranicaView sview = new StranicaView();
								sview.setStranica(s);
								dview.add(sview);
								dview.dodaj(sview);
								for (int k = 0; k < s.getChildCount(); k++) {
									if (s.getChildAt(k) instanceof GrafickiSlot) {
										GrafickiSlot gsl = (GrafickiSlot) s.getChildAt(k);
										GrafickiSlotView gslview = new GrafickiSlotView();
										StateManager sm = new StateManager(gsl);
										CommandManager cm = new CommandManager();
										gsl.setStateManager(sm);
										gsl.setCommandManager(cm);
										gsl.getModel().getListenerList().add(UpdateListener.class,
												(UpdateListener) gslview);
										gsl.getSelectionModel().getListaListenera().add(UpdateListener.class, (UpdateListener)gslview);
										gslview.setSlot(gsl);
										sview.add(gslview);
										sview.dodaj(gslview);
									}
								}
							}
						}
					}

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			w.setVisible(false);

		}
	}

}
