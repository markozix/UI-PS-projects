package akcije;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.tree.TreePath;

import main.MainFrame;
import model.Projekat;
import model.Workspace;
import view.ProjekatView;
import workspace.WorkspaceModel;
import workspace.WorkspaceTree;

public class SacuvajWorkspaceAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {

		TreePath path = MainFrame.getInstance().getTree().getSelectionPath();
		Object o1 = path.getPathComponent(0);
		Workspace ws = (Workspace) o1;
		File fajl = ws.getFajl();

		try {
			PrintWriter pw = new PrintWriter(fajl);
			WorkspaceModel wm = MainFrame.getInstance().getWm();

			Workspace w = (Workspace) wm.getRoot();
			for (Projekat p : w.getProjekti()) {

				pw.println(p.getFajl().getAbsolutePath());

			}

			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
