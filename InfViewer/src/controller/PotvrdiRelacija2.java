package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JTextArea;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

import com.cedarsoftware.util.io.JsonWriter;

import metaSema.EditorMetaSeme;
import modeli.Atribut;
import modeli.Entitet;
import modeli.InformacioniResurs;
import modeli.Paket;
import modeli.Relacija;

public class PotvrdiRelacija2 implements ActionListener {

	private JDialog dialog;
	private JTextArea ta;
	private Entitet entitet;
	private Relacija relacija;
	
	public PotvrdiRelacija2(JDialog dialog, JTextArea ta, Entitet entitet, Relacija relacija) {
		this.dialog = dialog;
		this.ta = ta;
		this.entitet = entitet;
		this.relacija = relacija;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String string = ta.getText();
		String[] niz = StringUtils.substringsBetween(string, ":", "\"");
		for(int i = 0; i < niz.length; i++) {
			niz[i] = niz[i].replaceAll("\\s", "");
		}
		String poslednji = StringUtils.substringBetween(string, "entitet\":", "}");
		poslednji = poslednji.replaceAll("\\s", "");
		InformacioniResurs resurs = EditorMetaSeme.getInstance().getResurs();
		for(int i = 0; i < resurs.getChildCount(); i++) {
			Paket p = (Paket)resurs.getChildAt(i);
			for(int k = 0; k < p.getChildCount(); k++) {
				Entitet ent = (Entitet)p.getChildAt(k);
				if(ent.getName().equals(relacija.getEntitet())) {
					for(int j = 0; j < ent.getRelacije().size(); j++) {
						if(ent.getRelacije().get(j).getEntitet().toString().equals(entitet.toString())) {
							ent.getRelacije().remove(j);
							break;
						}
					}
				}
			}
		}
		relacija.setAtribut1(niz[0]);
		relacija.setAtribut2(niz[1]);
		relacija.setEntitet(poslednji);
//		entitet.add(relacija);
		Relacija relacija2 = new Relacija();
		relacija2.setAtribut1(niz[1]);
		relacija2.setAtribut2(niz[0]);
		relacija2.setEntitet(entitet.toString());
		for(int i = 0; i < resurs.getChildCount(); i++) {
			Paket p = (Paket)resurs.getChildAt(i);
			for(int j = 0; j < p.getChildCount(); j++) {
				Entitet ent = (Entitet)p.getChildAt(j);
				if(ent.getName().equals(poslednji)) {
					ent.getRelacije().add(relacija2);
					break;
				}
			}
		}
		JSONObject sema = new JSONObject();
		sema.put("name", resurs.getNaziv());
		for(int i = 0; i < resurs.getChildCount(); i++) {
			Paket pake = (Paket)resurs.getChildAt(i);
			JSONObject paket = new JSONObject();
			paket.put("name", pake.getNaziv());
			for(int l = 0; l < pake.getChildCount(); l++) {
				Entitet ent = (Entitet)pake.getChildAt(l);
				JSONObject entitet = new JSONObject();
				entitet.put("name", ent.getName());
				entitet.put("path", ent.getPath());
				for(int j = 0; j < ent.getChildCount(); j++) {
					Atribut atr = (Atribut)ent.getChildAt(j);
					JSONObject atribut = new JSONObject()
							.put("name", atr.getName())
							.put("isKey", atr.isKey())
							.put("length", atr.getDuzina())
							.put("type", atr.getType())
							.put("required", atr.isRequired());
					entitet.append("atributes", atribut);
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
		EditorMetaSeme.getInstance().getTa().setText(JsonWriter.formatJson(sema.toString()));
		dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
	}

}
