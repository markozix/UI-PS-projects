package metaSema;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextArea;

import org.json.JSONObject;

import com.cedarsoftware.util.io.JsonWriter;

import controller.PotvrdiRelacija2;
import modeli.Entitet;
import modeli.InformacioniResurs;
import modeli.Paket;
import modeli.Relacija;

public class UpdateRelacijaDialog extends JDialog {

	public UpdateRelacijaDialog(Relacija rel) {
		JTextArea ta = new JTextArea();
		JButton dugme = new JButton("Izmeni");
//		dugme.addActionListener(new PotvrdiEntitet2(ta, this, ent));
		
		setTitle("MetaOpis - Relacija");
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
				for(int j = 0; j < e.getRelacije().size(); j++) {
					if(rel.equals(e.getRelacije().get(j))) {
	//					e.getRelacije().remove(j);
						entitet = e;
						break;
					}
				}
			}
		}
		dugme.addActionListener(new PotvrdiRelacija2(this, ta, entitet, rel));
		JSONObject relacija = new JSONObject()
				.put("atribut1", rel.getAtribut1())
				.put("atribut2", rel.getAtribut2())
				.put("entitet", rel.getEntitet());
		ta.setText(JsonWriter.formatJson(relacija.toString()));
	}
}
