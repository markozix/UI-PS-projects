package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;

import metaSema.AtributDialog;
import metaSema.IzaberiEntitet;
import modeli.Entitet;

public class IzaberiEntitetAkcija implements ActionListener {

	private IzaberiEntitet dialog;
	
	public IzaberiEntitetAkcija(IzaberiEntitet dialog) {
		this.dialog = dialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		AtributDialog ad = new AtributDialog(dialog.getLista().getSelectedValue());
		dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
	}

}