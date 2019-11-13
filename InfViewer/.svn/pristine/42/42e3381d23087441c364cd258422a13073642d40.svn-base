package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;

import main.MainFrame;
import modeli.InformacioniResurs;

public class DodajInfResursAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		InformacioniResurs infResurs = new InformacioniResurs();
		infResurs.setNaziv("InfResurs");
		MainFrame.getInstance().getTree().addInformacioniResurs(infResurs);
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
	}
	
}
