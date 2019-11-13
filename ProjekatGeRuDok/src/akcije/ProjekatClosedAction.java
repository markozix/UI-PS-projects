package akcije;

import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import main.MainFrame;

public class ProjekatClosedAction implements InternalFrameListener {

	@Override
	public void internalFrameActivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameClosed(InternalFrameEvent e) {
		if(MainFrame.getInstance().getMeni().getSelectedOption() != 1) {
			if(MainFrame.getInstance().getMeni().getSelectedOption() == 2) {
				int i = MainFrame.getInstance().getDesniDesktop().getAllFrames().length - 1;
				int j = i + 1;
				for(JInternalFrame frame : MainFrame.getInstance().getDesniDesktop().getAllFrames()) {
					frame.setLocation((MainFrame.getInstance().getDesniDesktop().getWidth() / j) * i, 0);
					frame.setSize(MainFrame.getInstance().getDesniDesktop().getWidth() / j, MainFrame.getInstance()
							.getDesniDesktop().getHeight());
					i--;
				}
			} else {
				int i = MainFrame.getInstance().getDesniDesktop().getAllFrames().length - 1;
				int j = i + 1;
				for(JInternalFrame frame : MainFrame.getInstance().getDesniDesktop().getAllFrames()) {
					frame.setLocation(0, (MainFrame.getInstance().getDesniDesktop().getHeight() / j) * i);
					frame.setSize(MainFrame.getInstance().getDesniDesktop().getWidth(), MainFrame.getInstance()
							.getDesniDesktop().getHeight() / j);
					i--;
				}
			}
		} else {
			int i = MainFrame.getInstance().getDesniDesktop().getAllFrames().length;
			for(JInternalFrame frame : MainFrame.getInstance().getDesniDesktop().getAllFrames()) {
				frame.setLocation(30 * i, 30 * i);
				i--;
			}
		}
	}

	@Override
	public void internalFrameClosing(InternalFrameEvent e) {
	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameIconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void internalFrameOpened(InternalFrameEvent e) {
		// TODO Auto-generated method stub
		
	}

}
