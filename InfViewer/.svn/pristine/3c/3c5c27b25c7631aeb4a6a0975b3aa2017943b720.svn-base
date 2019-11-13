package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.SwingUtilities;

import main.MainFrame;
import metaSema.EditorMetaSeme;
import modeli.InformacioniResurs;
import modeli.Workspace;

public class Save implements ActionListener {

	private JDialog dialog;
	
	public Save(JDialog dialog) {
		this.dialog = dialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Workspace work = (Workspace)MainFrame.getInstance().getTree().getModel().getRoot();
		for(int i = 0; i < work.getChildCount(); i++) {
			if(((InformacioniResurs)work.getChildAt(i)).toString().equals(EditorMetaSeme.getInstance().getResurs().toString())) {
				InformacioniResurs ir = (InformacioniResurs)work.getChildAt(i);
				work.remove(ir);
				work.add(EditorMetaSeme.getInstance().getResurs());
				return;
			}
		}
		work.add(EditorMetaSeme.getInstance().getResurs());
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
		InformacioniResurs novi = new InformacioniResurs();
		EditorMetaSeme.getInstance().setResurs(novi);
		dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
	}

}
