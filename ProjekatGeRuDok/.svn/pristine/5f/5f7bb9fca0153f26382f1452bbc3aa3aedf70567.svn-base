package akcije;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;

import main.MainFrame;

public class HorizontalViewAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int i = MainFrame.getInstance().getDesniDesktop().getAllFrames().length - 1;
		int j = i + 1;
		for(JInternalFrame frame : MainFrame.getInstance().getDesniDesktop().getAllFrames()) {
			frame.setLocation(0, (MainFrame.getInstance().getDesniDesktop().getHeight() / j) * i);
			frame.setSize(MainFrame.getInstance().getDesniDesktop().getWidth(), MainFrame.getInstance()
					.getDesniDesktop().getHeight() / j);
			i--;
		}
	}

}
