package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import model.Dokument;

public class DokumentView extends JFrame {

	public static int openFrameCount = 0;
	public static final int xOffset = 30, yOffset = 30;
	private Dokument dokument;
	private JPanel framework;
	private ArrayList<StranicaView> lista;
	private ArrayList<DokumentView> deljeni;

	public DokumentView() {
		lista = new ArrayList<>();
		deljeni = new ArrayList<>();
		openFrameCount++;
		this.setBackground(Color.GRAY);
		GridLayout gl = new GridLayout(0, 1);
		gl.setVgap(15);
		gl.setHgap(15);
		this.setLayout(gl);
	}
	
	public DokumentView(DokumentView drugi) {
		lista = new ArrayList<>();
		deljeni = new ArrayList<>();
		this.setBackground(Color.GRAY);
		GridLayout gl = new GridLayout(0, 1);
		gl.setVgap(15);
		gl.setHgap(15);
		this.setLayout(gl);
		lista.addAll(drugi.getLista());
	}

	public void dodaj(StranicaView s) {
		lista.add(s);
	}
	
	public void obrisi(StranicaView s){
		lista.remove(s);
	}

	public ArrayList<StranicaView> getLista() {
		return lista;
	}

	public Dokument getDokument() {
		return dokument;
	}

	public void setDokument(Dokument dokument) {
		this.dokument = dokument;
		// setTitle(dokument.getNaziv());
	}
	
	public ArrayList<DokumentView> getDeljeni() {
		return deljeni;
	}

	public void setDeljeni(ArrayList<DokumentView> deljeni) {
		this.deljeni = deljeni;
	}

	private class Framework extends JPanel {

	}

}
