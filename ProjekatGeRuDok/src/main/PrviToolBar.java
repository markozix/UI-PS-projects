package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import akcije.DodajDokumentAction;
import akcije.DodajProjekatAction;
import akcije.UkloniDokumentAction;
import akcije.UkloniProjekatAction;

public class PrviToolBar extends JToolBar {

	private JFrame parent;
	
	public PrviToolBar() {
		
		//za svako dugme skaliranje slike 
		JButton dodajProjekat = new JButton();
		ImageIcon dP = new ImageIcon(getClass().getResource("addproject.jpg"));
		Image im = dP.getImage();
		Image im1 = im.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		dP = new ImageIcon(im1);
		dodajProjekat.setMaximumSize(new Dimension(30, 30));
		dodajProjekat.setIcon(dP);
		dodajProjekat.setBorder(null);
		dodajProjekat.addActionListener(new DodajProjekatAction());
	
		JButton dodajDokument = new JButton();
		ImageIcon dD = new ImageIcon(getClass().getResource("add document.png"));
		Image iD = dD.getImage();
		Image iD1 = iD.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		dD = new ImageIcon(iD1);
		dodajDokument.setMaximumSize(new Dimension(30, 30));
		dodajDokument.setIcon(dD);
		dodajDokument.setBorder(null);
		dodajDokument.addActionListener(new DodajDokumentAction());
		
		
		
		JButton brisiProjekat = new JButton();
		ImageIcon bP = new ImageIcon(getClass().getResource("remove project.jpg"));
		Image iBp = bP.getImage();
		Image iBp1 = iBp.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		bP = new ImageIcon(iBp1);
		brisiProjekat.setMaximumSize(new Dimension(30, 30));
		brisiProjekat.setIcon(bP);
		brisiProjekat.setBorder(null);
		brisiProjekat.addActionListener(new UkloniProjekatAction());
		
		JButton brisiDokument = new JButton();
		ImageIcon bD = new ImageIcon(getClass().getResource("remove document.png"));
		Image iB = bD.getImage();
		Image iB1 = iB.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		bD = new ImageIcon(iB1);
		brisiDokument.setMaximumSize(new Dimension(30, 30));
		brisiDokument.setIcon(bD);
		brisiDokument.setBorder(null);
		brisiDokument.addActionListener(new UkloniDokumentAction());
		
		
		
		
		
		// crta izmedju dodavanja i brisanja
		JSeparator sep = new JSeparator(SwingConstants.VERTICAL);
		sep.setBackground(Color.BLACK);
		sep.setMaximumSize(new Dimension(5,30));
		
		//dodavanje
		add(dodajProjekat);
		addSeparator(new Dimension(7,0));
		add(dodajDokument);
		addSeparator(new Dimension(7,0));
		add(sep);
		addSeparator(new Dimension(6,0));
		add(brisiProjekat);
		addSeparator(new Dimension(7,0));
		add(brisiDokument);
		
		
		
		setFloatable(false);
		
		
	}
	
	
}
