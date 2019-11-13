package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import metaSema.IzaberiEntitet2;
import metaSema.IzaberiEntitet3;
import modeli.Entitet;

public class IzaberiEntitetRelacija implements ActionListener {

	private IzaberiEntitet2 dialog;
	
	public IzaberiEntitetRelacija(IzaberiEntitet2 dialog) {
		this.dialog = dialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Entitet ent = dialog.getLista().getSelectedValue();
		dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
		IzaberiEntitet3 entitet = new IzaberiEntitet3(ent);
	}

}
