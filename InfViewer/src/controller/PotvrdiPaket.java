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
import metaSema.PaketDialog;
import modeli.Atribut;
import modeli.Entitet;
import modeli.InformacioniResurs;
import modeli.Paket;
import modeli.Relacija;

public class PotvrdiPaket implements ActionListener {

	private PaketDialog dialog;
	private JTextArea ta;
	
	public PotvrdiPaket(JTextArea ta, PaketDialog dialog) {
		this.ta = ta;
		this.dialog = dialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		InformacioniResurs resurs = EditorMetaSeme.getInstance().getResurs();
		String string = ta.getText();
		String subString = StringUtils.substringBetween(string ,":", "}");
		subString = subString.replaceAll("\\s", "");
		Paket pak = new Paket();
		pak.setNaziv(subString);
		resurs.add(pak);
		JSONObject sema = new JSONObject();									//ovako sada treba da izgleda ovaj deo
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