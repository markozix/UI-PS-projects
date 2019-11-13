package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import metaSema.EntitetDialog;
import metaSema.IzaberiPaket;

public class IzaberiPaketAkcija implements ActionListener {

	private IzaberiPaket dialog;

	public IzaberiPaketAkcija(IzaberiPaket dialog) {
		super();
		this.dialog = dialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		EntitetDialog ed = new EntitetDialog(dialog.getLista().getSelectedValue());
		dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
	}
	
}
