package akcije;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StringBufferInputStream;
import java.util.MissingFormatArgumentException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import event.UpdateListener;
import main.BiranjeWorkspacea;
import main.MainFrame;
import model.Dokument;
import model.GrafickiSlot;
import model.Projekat;
import model.Stranica;
import state.StateManager;
import view.DokumentView;
import view.GrafickiSlotView;
import view.ProjekatView;
import view.StranicaView;
import workspace.WorkspaceModel;

public class OtvoriWorkspaceAction implements ActionListener {
	BiranjeWorkspacea w;

	public OtvoriWorkspaceAction(BiranjeWorkspacea w) {
		super();
		this.w = w;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
//		// zatvaramo dialog prozor za odabir workspace-a
//		try {
//			w.setVisible(false);
//		} catch (Exception e) {
//		}

		// otvaranje novog workspace
		File fajl = new File("");
		JFileChooser fc = new JFileChooser();

		fc.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
		fc.setDialogTitle("Choose a workspace");
		int result = fc.showOpenDialog(w);
//		if (fc.getSelectedFile() == null) {
//			w.setVisible(true);
//			return;
//		}
		if (result == JFileChooser.APPROVE_OPTION) {
			fajl = fc.getSelectedFile();
		} else if (result == JFileChooser.CANCEL_OPTION) {
		}
		BiranjeWorkspacea.setFajl(fajl);
		BiranjeWorkspacea.getTf().setText(fajl.getAbsolutePath());
		Projekat p = null;

//		w.setVisible(true);

	}

}
