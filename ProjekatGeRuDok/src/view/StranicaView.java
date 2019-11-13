package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Stranica;

public class StranicaView extends JPanel {

	private Stranica stranica;
	private ArrayList<SlotView> lista;
	private ArrayList<StranicaView> deljeni = new ArrayList<>();

	public StranicaView() {
		lista = new ArrayList<>();
		this.setBackground(Color.blue);
		this.setPreferredSize(new Dimension(200, 200));
		this.setLayout(new GridLayout(3, 1, 30, 20));
		this.setAlignmentX(Component.LEFT_ALIGNMENT);

	}

	public StranicaView(StranicaView sv) {
		lista = sv.lista;
		this.setBackground(Color.blue);
		this.setPreferredSize(new Dimension(200, 200));
		this.setLayout(new GridLayout(3, 1, 30, 20));
		this.setAlignmentX(Component.LEFT_ALIGNMENT);
	}

	public void dodaj(SlotView sw) {
		lista.add(sw);
	}

	public void obrisi(SlotView sw) {
		lista.remove(sw);
	}

	public ArrayList<SlotView> getLista() {
		return lista;
	}

	public void setStranica(Stranica stranica) {
		this.stranica = stranica;
	}

	public Stranica getStranica() {
		return stranica;
	}

	public void setLista(ArrayList<SlotView> lista) {
		this.lista = lista;
	}

	public ArrayList<StranicaView> getDeljeni() {
		return deljeni;
	}

	public void setDeljeni(ArrayList<StranicaView> deljeni) {
		this.deljeni = deljeni;
	}

}
