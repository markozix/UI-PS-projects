package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.json.JSONObject;

import com.cedarsoftware.util.io.JsonWriter;

import metaSema.ResursDialog;
import modeli.Atribut;
import modeli.Entitet;
import modeli.InformacioniResurs;
import modeli.Relacija;

public class DodajInfResurs implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
//		InformacioniResurs resurs = EditorMetaSeme.getInstance().getResurs();
//		JSONObject sema = new JSONObject();
//		sema.put("name", resurs.getNaziv());
//		for(int i = 0; i < resurs.getChildCount(); i++) {
//			Entitet ent = (Entitet)resurs.getChildAt(i);
//			JSONObject entitet = new JSONObject();
//			entitet.put("name", ent.getName());
//			for(int j = 0; j < ent.getChildCount(); j++) {
//				Atribut atr = (Atribut)ent.getChildAt(j);
//				JSONObject atribut = new JSONObject()
//						.put("name", atr.getName())
//						.put("isKey", atr.isKey())
//						.put("length", atr.getDuzina())
//						.put("type", atr.getType())
//						.put("required", atr.isRequired());
//				entitet.append("atributes", atribut);
//			}
//			for(int j = 0; j < ent.getRelacije().size(); j++) {
//				Relacija rel = (Relacija)ent.getRelacije().get(j);
//				JSONObject relacija = new JSONObject()
//						.put("atribut1", rel.getAtribut1())
//						.put("atribut2", rel.getAtribut2())
//						.put("entitet", rel.getEntitet());
//				entitet.append("relations", relacija);
//			}
//			sema.append("entities", entitet);
//		}
//		EditorMetaSeme.getInstance().getTa().setText(JsonWriter.formatJson(sema.toString()));
		ResursDialog rd = new ResursDialog();
	}

}
