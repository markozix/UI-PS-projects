package metaSema;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextArea;

import org.json.JSONObject;

import com.cedarsoftware.util.io.JsonWriter;

import controller.PotvrdiEntitet2;
import modeli.Atribut;
import modeli.Entitet;
import modeli.InformacioniResurs;
import modeli.Paket;
import modeli.Relacija;

public class UpdateEntitetDialog extends JDialog {

	public UpdateEntitetDialog(Entitet ent) {
		JTextArea ta = new JTextArea();
		JButton dugme = new JButton("Izmeni");
//		dugme.addActionListener(new PotvrdiEntitet2(ta, this, ent));
		
		setTitle("MetaOpis - Entitet");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		
		add(ta);
		add(dugme, BorderLayout.SOUTH);
		ta.setFont(ta.getFont().deriveFont(14f));
		
		Paket pak = null;
		InformacioniResurs resurs = EditorMetaSeme.getInstance().getResurs();
		for(int i = 0; i < resurs.getChildCount(); i++) {
			Paket p = (Paket)resurs.getChildAt(i);
			for(int j = 0; j < p.getChildCount(); j++) {
				if(ent.equals((Entitet)p.getChildAt(j))) {
					p.remove(ent);
					pak = p;
					break;
				}
			}
		}

		dugme.addActionListener(new PotvrdiEntitet2(ta, this, ent, pak));
		JSONObject entitet = new JSONObject();
		entitet.put("name", ent.getName());
//		for(int j = 0; j < ent.getChildCount(); j++) {
//			Atribut atr = (Atribut)ent.getChildAt(j);
//			JSONObject atribut = new JSONObject()
//					.put("name", atr.getName())
//					.put("isKey", atr.isKey())
//					.put("length", atr.getDuzina())
//					.put("type", atr.getType())
//					.put("required", atr.isRequired());
//			entitet.append("atributes", atribut);
//		}
//		for(int j = 0; j < ent.getRelacije().size(); j++) {
//			Relacija rel = (Relacija)ent.getRelacije().get(j);
//			JSONObject relacija = new JSONObject()
//					.put("atribut1", rel.getAtribut1())
//					.put("atribut2", rel.getAtribut2())
//					.put("entitet", rel.getEntitet());
//			entitet.append("relations", relacija);
//		}
		ta.setText(JsonWriter.formatJson(entitet.toString()));
//		File fajl = new File("MetaOpisMoj.txt");
//		try {
//			BufferedReader br = new BufferedReader(new FileReader(fajl));
//			ta.setEditable(true);
//			String ucitaj;
//			while((ucitaj = br.readLine()) != null) {
//				ta.append(ucitaj);
//				ta.append("\n");
//			}
//			br.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}
