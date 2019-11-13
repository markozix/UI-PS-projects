package controller.state;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JDialog;

public class SaveFajl implements ActionListener {

	private String[][] matrica;
	private JDialog dialog;
	private static int br = 0;
	private int counter;
	
	public SaveFajl(String[][] matrica, JDialog dialog, int counter) {
		this.matrica = matrica;
		this.dialog = dialog;
		this.counter = counter;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		File f = new File("Results" + br + ".txt");
		br++;
		try {
			PrintWriter pw = new PrintWriter(f.getName());
			for(int i = 0; i < counter; i++) {
				String niz[] = matrica[i];
				StringBuilder sb = new StringBuilder();
				for(int j = 0; j < niz.length; j++) {
					sb.append(niz[j]);
				}
				System.out.println(sb.toString());
				pw.println(sb.toString());
			}
			pw.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
	}

}
