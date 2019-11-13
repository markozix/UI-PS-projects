package akcije;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;

import main.MainFrame;
import model.Projekat;

public class SacuvajProjekatAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser fc = new JFileChooser();
		Projekat p = (Projekat)MainFrame.getInstance().getTree().getSelectionPath().getPathComponent(1);
		File fajl = p.getFajl();
		File fajlPravi = p.getFajl();
		if(!p.isPromenjeno()) {
			return;
		}
		if(fajl == null) {
			fc.setDialogTitle("Choose a location");
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int result = fc.showSaveDialog(MainFrame.getInstance());
			if(result == JFileChooser.APPROVE_OPTION) {
				fajl = fc.getSelectedFile();
				String fajlName = fajl.getAbsolutePath();
				StringBuilder sb = new StringBuilder();
				sb.append(fajlName);
				sb.append(File.separator);
				sb.append(p.getNaziv());
				sb.append(".gpf");
				String res = sb.toString();
				fajlPravi = new File(res);
				try {
					fajlPravi.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				return;
			}
		}
		try {
			p.setFajl(fajlPravi);
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fajlPravi));
			out.writeObject(p);
			p.setFajl(fajlPravi);
			p.setPromenjeno(false);
			out.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
