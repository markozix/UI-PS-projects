package akcije;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;

import main.MainFrame;

public class CascadeViewAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int i = MainFrame.getInstance().getDesniDesktop().getAllFrames().length;
		for(JInternalFrame frame : MainFrame.getInstance().getDesniDesktop().getAllFrames()) {
			frame.setLocation(30 * i, 30 * i);
			frame.setSize(400, 400);
			i--;
		}
	}

}
