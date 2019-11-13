package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import metaSema.IzaberiEntitet3;
import metaSema.RelacijaDialog;
import modeli.Entitet;

public class IzaberiEntitetRelacija2 implements ActionListener {

	private IzaberiEntitet3 dialog;
	private Entitet entitet1;
	
	public IzaberiEntitetRelacija2(IzaberiEntitet3 dialog, Entitet entitet1) {
		this.dialog = dialog;
		this.entitet1 = entitet1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		RelacijaDialog rd = new RelacijaDialog(entitet1, dialog.getLista().getSelectedValue());
		dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
	}

}
