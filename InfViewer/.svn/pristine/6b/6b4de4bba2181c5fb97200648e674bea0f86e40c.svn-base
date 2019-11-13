package controller;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import main.MainFrame;
import main.ToolBarIznadTabele;
import modeli.Atribut;
import modeli.Entitet;
import modeli.InformacioniResurs;
import modeli.Paket;
import modeli.Relacija;
import modeli.Tabela;
import modeli.Workspace;
import state.StateManager;

public class OsveziTrenutniEntitet implements ChangeListener {
	private JTable tabela;

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// ocisti prethodne tabove da ne bi bilo duplikata
		// nalazi odgovarajuce entitete koje treba iscrtati u donjoj tabeli
		String odabrani;
		String odabrani2;
		if (MainFrame.getInstance().getGornjiTabovi().getSelectedIndex() >= 0) {
			odabrani = MainFrame.getInstance().getGornjiTabovi()
					.getTitleAt(MainFrame.getInstance().getGornjiTabovi().getSelectedIndex());
			odabrani2 = odabrani.substring(0, odabrani.indexOf(":"));
			odabrani = odabrani.substring(odabrani.indexOf(":") + 1);
			Entitet trenutni = null;
			Paket pp = (Paket) MainFrame.getInstance().getTree().getSelectionPath().getPathComponent(2);
			Workspace ws = (Workspace) MainFrame.getInstance().getTree().getSelectionPath().getPathComponent(0);
			for (int i = 0; i < ws.getChildCount(); i++) {
				InformacioniResurs ir = (InformacioniResurs) ws.getChildAt(i);
				for (Paket px : ir.getPaketi()) {
					if (px.getNaziv().equals(odabrani2)) {
						pp = px;
						for (Entitet e : px.getEntiteti()) {
							if (e.getName().equals(odabrani)) {
								trenutni = e;
							}
						}
					}
				}
			}
			MainFrame.getInstance().setTrenutniEntitet(trenutni);
			MainFrame.getInstance().getTrenutniEntitet().setEntPaket(pp);
			MainFrame.getInstance().getTrenutniEntitet().getStateManager().setRelacijaState();
		}
	}
}
