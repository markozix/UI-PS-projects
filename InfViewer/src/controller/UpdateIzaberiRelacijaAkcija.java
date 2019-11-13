package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import metaSema.UpdateIzaberiRelacija;
import metaSema.UpdateRelacijaDialog;

public class UpdateIzaberiRelacijaAkcija implements ActionListener {

	private UpdateIzaberiRelacija dialog;
	
	public UpdateIzaberiRelacijaAkcija(UpdateIzaberiRelacija dialog) {
		this.dialog = dialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		UpdateRelacijaDialog relacija = new UpdateRelacijaDialog(dialog.getLista().getSelectedValue());
		dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
	}

}
