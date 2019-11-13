package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.json.JSONObject;
import org.json.JSONTokener;

import main.MainFrame;
import modeli.Atribut;
import modeli.Entitet;
import modeli.InformacioniResurs;
import modeli.Paket;
import modeli.Relacija;


public class Import implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON", "json");
		fc.setFileFilter(filter);
		fc.setDialogTitle("Select the meta-scheme you would like to import");
		int result = fc.showDialog(MainFrame.getInstance(), "Choose");
		if(result == JFileChooser.APPROVE_OPTION) {
			File fajl = new File(fc.getSelectedFile().getAbsolutePath());
			BufferedReader br;
			try {
				br = new BufferedReader(new InputStreamReader(new FileInputStream(fajl)));
				JSONTokener tokener = new JSONTokener(br);
				JSONObject inf = new JSONObject(tokener);
				br.close();
				InformacioniResurs resurs = new InformacioniResurs();
				resurs.setNaziv(inf.getString("name"));
				MainFrame.getInstance().getTree().addInformacioniResurs(resurs);
				if(inf.has("paketi")) {
					for(int k = 0; k < inf.getJSONArray("paketi").length(); k++) {
						JSONObject pak = inf.getJSONArray("paketi").getJSONObject(k);
						Paket paket = new Paket();
						paket.setNaziv(pak.getString("name"));
						if(pak.has("entities")) {
							for(int i = 0; i < pak.getJSONArray("entities").length(); i++) {
								JSONObject ent = pak.getJSONArray("entities").getJSONObject(i);
								Entitet entitet = new Entitet();
								entitet.setPath(ent.getString("path"));
								entitet.setName(ent.getString("name"));
								if(ent.has("atributes")) {
									for(int j = 0; j < ent.getJSONArray("atributes").length(); j++) {
										JSONObject atr = ent.getJSONArray("atributes").getJSONObject(j);
										Atribut atribut = new Atribut();
										atribut.setName(atr.getString("name"));
										atribut.setDuzina(atr.getInt("length"));
										atribut.setKey(atr.getBoolean("isKey"));
										atribut.setType(atr.getString("type"));
										atribut.setRequired(atr.getBoolean("required"));
										entitet.add(atribut);
									}
								}
								if(ent.has("relations")) {
									for(int j = 0; j < ent.getJSONArray("relations").length(); j++) {
										JSONObject rel = ent.getJSONArray("relations").getJSONObject(j);
										Relacija relacija = new Relacija();
										relacija.setAtribut1(rel.getString("atribut1"));
										relacija.setAtribut2(rel.getString("atribut2"));
										relacija.setEntitet(rel.getString("entitet"));
										entitet.getRelacije().add(relacija);
									}
								}
								paket.add(entitet);
							}
						}
						resurs.add(paket);
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
