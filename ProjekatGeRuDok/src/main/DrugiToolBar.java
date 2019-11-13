package main;

import java.awt.Color;
import java.awt.Desktop.Action;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import akcije.CopyAction;
import akcije.CutAction;
import akcije.PasteAction;
import akcije.UmanjiAction;
import akcije.UvecajAction;
import model.Slot;
import state.StateManager;
import view.ProjekatView;

public class DrugiToolBar extends JToolBar {

	private JFrame parent;
	
	public DrugiToolBar() {

		
		
		JButton selekcija = new JButton();
		ImageIcon sel = new ImageIcon(getClass().getResource("selekcija.png"));
		Image i1 = sel.getImage();
		Image i11 = i1.getScaledInstance(45, 45, Image.SCALE_DEFAULT);
		sel = new ImageIcon(i11);
		selekcija.setMaximumSize(new Dimension(45, 45));
		selekcija.setIcon(sel);
		selekcija.setBorder(null);
		selekcija.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Slot slot = (Slot)MainFrame.getInstance().getTree().getLastSelectedPathComponent();
				slot.getStateManager().setSelectStanje();
			}
		});
		
		JButton copy = new JButton();
		ImageIcon kop = new ImageIcon(getClass().getResource("copy.png"));
		Image i2 = kop.getImage();
		Image i22 = i2.getScaledInstance(45, 45, Image.SCALE_DEFAULT);
		kop = new ImageIcon(i22);
		copy.setMaximumSize(new Dimension(45, 45));
		copy.setIcon(kop);
		copy.setBorder(null);
		copy.addActionListener(new CopyAction());
		
		JButton cut = new JButton();
		ImageIcon kat = new ImageIcon(getClass().getResource("cut.png"));
		Image i3 = kat.getImage();
		Image i33 = i3.getScaledInstance(45, 45, Image.SCALE_DEFAULT);
		kat = new ImageIcon(i33);
		cut.setMaximumSize(new Dimension(45, 45));
		cut.setIcon(kat);
		cut.setBorder(null);
		cut.addActionListener(new CutAction());
		
		JButton paste = new JButton();
		ImageIcon pas = new ImageIcon(getClass().getResource("paste.png"));
		Image i4 = pas.getImage();
		Image i44 = i4.getScaledInstance(45, 45, Image.SCALE_DEFAULT);
		pas = new ImageIcon(i44);
		paste.setMaximumSize(new Dimension(45, 45));
		paste.setIcon(pas);
		paste.setBorder(null);
		paste.addActionListener(new PasteAction());
		
		JButton undo = new JButton();
		ImageIcon un = new ImageIcon(getClass().getResource("undo.jpg"));
		Image i5 = un.getImage();
		Image i55 = i5.getScaledInstance(45, 45, Image.SCALE_DEFAULT);
		un = new ImageIcon(i55);
		undo.setMaximumSize(new Dimension(45, 45));
		undo.setIcon(un);
		undo.setBorder(null);
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Slot slot = (Slot)MainFrame.getInstance().getTree().getLastSelectedPathComponent();
				slot.getCommandManager().undoCommand();
			}
		});
		
		JButton redo = new JButton();
		ImageIcon re = new ImageIcon(getClass().getResource("redo.jpg"));
		Image i6 = re.getImage();
		Image i66 = i6.getScaledInstance(45, 45, Image.SCALE_DEFAULT);
		re = new ImageIcon(i66);
		redo.setMaximumSize(new Dimension(45, 45));
		redo.setIcon(re);
		redo.setBorder(null);
		redo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Slot slot = (Slot)MainFrame.getInstance().getTree().getLastSelectedPathComponent();
				slot.getCommandManager().doCommand();
			}
		});
		
		JButton or = new JButton();
		ImageIcon ili = new ImageIcon(getClass().getResource("ili kolo.png"));
		Image i7 = ili.getImage();
		Image i77 = i7.getScaledInstance(45, 45, Image.SCALE_DEFAULT);
		ili = new ImageIcon(i77);
		or.setMaximumSize(new Dimension(45, 45));
		or.setIcon(ili);
		or.setBorder(null);
		or.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Slot slot = (Slot)MainFrame.getInstance().getTree().getLastSelectedPathComponent();
				slot.getStateManager().setKrugStanje();
			}
		});
		
		JButton and = new JButton();
		ImageIcon i = new ImageIcon(getClass().getResource("i kolo.png"));
		Image i8 = i.getImage();
		Image i88 = i8.getScaledInstance(45, 45, Image.SCALE_DEFAULT);
		i = new ImageIcon(i88);
		and.setMaximumSize(new Dimension(45, 45));
		and.setIcon(i);
		and.setBorder(null);
		and.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Slot slot = (Slot)MainFrame.getInstance().getTree().getLastSelectedPathComponent();
				slot.getStateManager().setPravougaonikStanje();
			}
		});
		
		JButton not = new JButton();
		ImageIcon ne = new ImageIcon(getClass().getResource("not.png"));
		Image i9 = ne.getImage();
		Image i99 = i9.getScaledInstance(45, 45, Image.SCALE_DEFAULT);
		ne = new ImageIcon(i99);
		not.setMaximumSize(new Dimension(45, 45));
		not.setIcon(ne);
		not.setBorder(null);
		not.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Slot slot = (Slot)MainFrame.getInstance().getTree().getLastSelectedPathComponent();
				slot.getStateManager().setTrougaoStanje();
			}
		});
		
		JButton veza = new JButton();
		ImageIcon vez = new ImageIcon(getClass().getResource("linija.png"));
		Image i10 = vez.getImage();
		Image i110 = i10.getScaledInstance(45, 45, Image.SCALE_DEFAULT);
		vez = new ImageIcon(i110);
		veza.setMaximumSize(new Dimension(45, 45));
		veza.setIcon(vez);
		veza.setBorder(null);
		veza.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Slot slot = (Slot)MainFrame.getInstance().getTree().getLastSelectedPathComponent();
				slot.getStateManager().setLinijaStanje();
			}
		});
		
		JButton uvecaj = new JButton();
		ImageIcon ic = new ImageIcon(getClass().getResource("plus.png"));
		Image i111 = ic.getImage();
		Image i112 = i111.getScaledInstance(45, 45, Image.SCALE_DEFAULT);
		ic = new ImageIcon(i112);
		uvecaj.setMaximumSize(new Dimension(45, 45));
		uvecaj.setIcon(ic);
		uvecaj.setBorder(null);
		uvecaj.addActionListener(new UvecajAction());
		
		JButton umanji = new JButton();
		ImageIcon ic1 = new ImageIcon(getClass().getResource("minus.png"));
		Image i1111 = ic1.getImage();
		Image i1121 = i1111.getScaledInstance(45, 45, Image.SCALE_DEFAULT);
		ic1 = new ImageIcon(i1121);
		umanji.setMaximumSize(new Dimension(45, 45));
		umanji.setIcon(ic1);
		umanji.setBorder(null);
		umanji.addActionListener(new UmanjiAction());
		
		add(selekcija);
		addSeparator(new Dimension(5,0));
		add(copy);
		addSeparator(new Dimension(5,0));
		add(cut);
		addSeparator(new Dimension(5,0));
		add(paste);
		addSeparator(new Dimension(5,0));
		add(undo);
		addSeparator(new Dimension(5,0));
		add(redo);
		addSeparator(new Dimension(5,0));
		add(or);
		addSeparator(new Dimension(5,0));
		add(and);
		addSeparator(new Dimension(5,0));
		add(not);
		addSeparator(new Dimension(5,0));
		add(veza);
		addSeparator(new Dimension(5,0));
		add(uvecaj);
		addSeparator(new Dimension(5,0));
		add(umanji);
		
		setFloatable(false);
		
	}
	
	
}
