package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import metaSema.UpdateAtributDialog;
import metaSema.UpdateIzaberiAtribut;

public class UpdateIzaberiAtributAkcija implements ActionListener {

	private UpdateIzaberiAtribut dialog;
	
	public UpdateIzaberiAtributAkcija(UpdateIzaberiAtribut dialog) {
		this.dialog = dialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		UpdateAtributDialog atribut = new UpdateAtributDialog(dialog.getLista().getSelectedValue());
		dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
	}

}
