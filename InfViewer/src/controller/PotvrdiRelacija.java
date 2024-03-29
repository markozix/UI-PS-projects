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

public class PotvrdiRelacija implements ActionListener {

	private JDialog dialog;
	private JTextArea ta;
	private Entitet ent1;
	private Entitet ent2;
	
	public PotvrdiRelacija(JDialog dialog, JTextArea ta, Entitet ent1, Entitet ent2) {
		this.dialog = dialog;
		this.ta = ta;
		this.ent1 = ent1;
		this.ent2 = ent2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String string = ta.getText();
		String prvi = StringUtils.substringBetween(string, ":", "\"");
		String drugi = StringUtils.substringBetween(string, "atribut2\":", "}");
		prvi = prvi.replaceAll("\\s", "");
		drugi = drugi.replaceAll("\\s", "");
		InformacioniResurs resurs = EditorMetaSeme.getInstance().getResurs();
		Relacija relacija1 = new Relacija();
		Relacija relacija2 = new Relacija();
		relacija1.setAtribut1(prvi);
		relacija1.setAtribut2(drugi);
		relacija1.setEntitet(ent2.toString());
		relacija2.setAtribut1(drugi);
		relacija2.setAtribut2(prvi);
		relacija2.setEntitet(ent1.toString());
		ent1.getRelacije().add(relacija1);
		ent2.getRelacije().add(relacija2);
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
