package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import metaSema.UpdateEntitetDialog;
import metaSema.UpdateIzaberiEntitet;


public class UpdateIzaberiEntitetAkcija implements ActionListener {

	private UpdateIzaberiEntitet dialog;
	
	public UpdateIzaberiEntitetAkcija(UpdateIzaberiEntitet dialog) {
		this.dialog = dialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		UpdateEntitetDialog dialog1 = new UpdateEntitetDialog(dialog.getLista().getSelectedValue());
		dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
	}

}
