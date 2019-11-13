package akcije;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;

import main.MainFrame;

public class VerticalViewAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int i = MainFrame.getInstance().getDesniDesktop().getAllFrames().length - 1;
		int j = i + 1;
		for(JInternalFrame frame : MainFrame.getInstance().getDesniDesktop().getAllFrames()) {
			frame.setLocation((MainFrame.getInstance().getDesniDesktop().getWidth() / j) * i, 0);
			frame.setSize(MainFrame.getInstance().getDesniDesktop().getWidth() / j, MainFrame.getInstance()
					.getDesniDesktop().getHeight());
			i--;
		}
	}

}
