package metaSema;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.Save;
import main.MainFrame;
import modeli.InformacioniResurs;

public class EditorMetaSeme extends JDialog {
	private static EditorMetaSeme instance = null;
	private JTextArea ta;
	private String entitetDodavanje;
	private InformacioniResurs resurs;

	private EditorMetaSeme() {
		initIzgled();
	}

	public void initIzgled() {
		MetaMenuBar tb = new MetaMenuBar();
		tb.setVisible(true);
		// add(tb, BorderLayout.NORTH);
		setJMenuBar(tb);

		ta = new JTextArea();
		ta.setEditable(false);
		JScrollPane pane = new JScrollPane(ta);
		add(pane);
		ta.setFont(ta.getFont().deriveFont(16f));
		JButton sacuvaj = new JButton("Save");
		add(sacuvaj, BorderLayout.SOUTH);
		sacuvaj.addActionListener(new Save(this));

		// File fajl = new File("MetaOpisMoj.txt");
		// try {
		// BufferedReader br = new BufferedReader(new FileReader(fajl));
		// String ucitaj;
		// while((ucitaj = br.readLine()) != null) {
		// ta.append(ucitaj);
		// ta.append("\n");
		// }
		// br.close();
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		resurs = new InformacioniResurs();
		// resurs.setNaziv("trubica");

		setTitle("MetaOpis");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public JTextArea getTa() {
		return ta;
	}

	public InformacioniResurs getResurs() {
		return resurs;
	}

	public void setResurs(InformacioniResurs resurs) {
		this.resurs = resurs;
	}

	public String getEntitetDodavanje() {
		return entitetDodavanje;
	}

	public void setEntitetDodavanje(String entitetDodavanje) {
		this.entitetDodavanje = entitetDodavanje;
	}

	public static EditorMetaSeme getInstance() {
		if (instance == null)
			instance = new EditorMetaSeme(); // singlton
		return instance;
	}
}
