package akcije;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JTextPane;

public class TekstOkAction implements ActionListener {

	private JTextPane tp, tp2;
	private JInternalFrame if1;

	public TekstOkAction(JTextPane tp, JTextPane tp2, JInternalFrame if1) {
		this.tp = tp;
		this.tp2 = tp2;
		this.if1 = if1;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		tp.setDocument(tp2.getDocument());
		if1.setVisible(false);
	}

}
