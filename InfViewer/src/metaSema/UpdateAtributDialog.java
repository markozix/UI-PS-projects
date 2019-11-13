package metaSema;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextArea;

import org.json.JSONObject;

import com.cedarsoftware.util.io.JsonWriter;

import controller.PotvrdiAtribut2;
import modeli.Atribut;
import modeli.Entitet;
import modeli.InformacioniResurs;
import modeli.Paket;

public class UpdateAtributDialog extends JDialog {

	public UpdateAtributDialog(Atribut atr) {
		JTextArea ta = new JTextArea();
		JButton dugme = new JButton("Izmeni");
//		dugme.addActionListener(new PotvrdiEntitet2(ta, this, ent));
		
		setTitle("MetaOpis - Atribut");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		
		add(ta);
		add(dugme, BorderLayout.SOUTH);
		ta.setFont(ta.getFont().deriveFont(14f));
		
		Entitet entitet = null;
		InformacioniResurs resurs = EditorMetaSeme.getInstance().getResurs();
		for(int i = 0; i < resurs.getChildCount(); i++) {
			Paket p = (Paket)resurs.getChildAt(i);
			for(int k = 0; k < p.getChildCount(); k++) {
				Entitet e = (Entitet)p.getChildAt(k);
				for(int j = 0; j < e.getChildCount(); j++) {
					if(atr.equals((Atribut)e.getChildAt(j))) {
						e.remove(atr);
						entitet = e;
						break;
					}
				}
			}
		}
		dugme.addActionListener(new PotvrdiAtribut2(this, ta, entitet, atr));
		JSONObject atribut = new JSONObject()
				.put("name", atr.getName())
				.put("isKey", atr.isKey())
				.put("length", atr.getDuzina())
				.put("type", atr.getType())
				.put("required", atr.isRequired());
		ta.setText(JsonWriter.formatJson(atribut.toString()));
	}
}
