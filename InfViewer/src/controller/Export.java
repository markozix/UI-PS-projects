package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;

import org.json.JSONObject;

import com.cedarsoftware.util.io.JsonWriter;

import main.MainFrame;
import modeli.Atribut;
import modeli.Entitet;
import modeli.InformacioniResurs;
import modeli.Paket;
import modeli.Relacija;

public class Export implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object o = MainFrame.getInstance().getTree().getLastSelectedPathComponent();
		JSONObject sema = new JSONObject();
		if(o instanceof InformacioniResurs) {
			InformacioniResurs resurs = (InformacioniResurs)o;
			sema.put("name", resurs.getNaziv());
			for(int i = 0; i < resurs.getChildCount(); i++) {
				Paket pak = (Paket)resurs.getChildAt(i);
				JSONObject paket = new JSONObject();
				paket.put("name", pak.getNaziv());
				for(int k = 0; k < pak.getChildCount(); k++) {
					Entitet ent = (Entitet)pak.getChildAt(k);
					JSONObject entitet = new JSONObject();
					entitet.put("name", ent.getName());
					entitet.put("path", ent.getPath());
					for(int j = 0; j < ent.getChildCount(); j++) {
						Atribut atr = (Atribut)ent.getChildAt(j);
						JSONObject atribu = new JSONObject()
								.put("name", atr.getName())
								.put("isKey", atr.isKey())
								.put("length", atr.getDuzina())
								.put("type", atr.getType())
								.put("required", atr.isRequired());
						entitet.append("atributes", atribu);
					}
					for(int j = 0; j < ent.getRelacije().size(); j++) {
						Relacija rel = (Relacija)ent.getRelacije().get(j);
						JSONObject relacija = new JSONObject()
								.put("atribut1", rel.getAtribut1())
								.put("atribut2", rel.getAtribut2())
								.put("entitet", rel.getEntitet());
						entitet.append("relations", relacija);
					}
					paket.append("entities", entitet);
				}
				sema.append("paketi", paket);
			}
		}
		JFileChooser fc = new JFileChooser();
		fc.setDialogTitle("Select a location for your meta-scheme");
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int result = fc.showSaveDialog(MainFrame.getInstance());
		StringBuilder sb = new StringBuilder();
		if(result == JFileChooser.APPROVE_OPTION) {
			sb.append(fc.getSelectedFile().getAbsolutePath());
			sb.append(File.separator);
			sb.append(((InformacioniResurs)o).getNaziv());
			sb.append(".json");
		}
		String fileName = sb.toString();
		File data = new File(fileName);
		PrintWriter pw;
		if(!data.exists()) {
			try {
				data.createNewFile();
				pw = new PrintWriter(data);
				pw.write(JsonWriter.formatJson(sema.toString()));
				pw.flush();
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				pw = new PrintWriter(data);
				pw.write(JsonWriter.formatJson(sema.toString()));
				pw.flush();
				pw.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

}