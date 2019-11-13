package controller.state;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;

public class SearchPrvi implements ActionListener {

	private JDialog dialog;
	
	public SearchPrvi(JDialog dialog) {
		this.dialog = dialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
		ChooseVrstaPretrage pre = new ChooseVrstaPretrage(true);
	}

}
