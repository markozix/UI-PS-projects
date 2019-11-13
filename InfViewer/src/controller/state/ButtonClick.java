package controller.state;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MainFrame;

public class ButtonClick implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame.getInstance().getTrenutniEntitet().getStateManager().getTrenutnoStanje().pressButton(e);
	}

}
