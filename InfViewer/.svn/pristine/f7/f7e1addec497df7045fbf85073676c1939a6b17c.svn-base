package controller.state;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.MainFrame;
import modeli.Atribut;

public class SearchStateAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
MainFrame.getInstance().getTrenutniEntitet().getStateManager().setSearchState();
		
		if(MainFrame.getInstance().getTrenutniEntitet().getEntPaket().equals("Serijski") || 
				MainFrame.getInstance().getTrenutniEntitet().getEntPaket().equals("Sekvencijalni") ||
				MainFrame.getInstance().getTrenutniEntitet().getEntPaket().equals("Indeks-sekvencijalni")) {
			JPanel pan = new JPanel();
			JPanel panel = new JPanel();
			int i = MainFrame.getInstance().getTrenutniEntitet().getAtributi().size();
			GridLayout grid = new GridLayout(0,6);
			//velicina grida
			
			panel.setLayout(grid);
			grid.setVgap(5);
			grid.setHgap(5);
			ArrayList<JTextField> lista = new ArrayList<>();
			for(Atribut a : MainFrame.getInstance().getTrenutniEntitet().getAtributi()) {
				JLabel labela = new JLabel(a.getName());
				labela.setHorizontalAlignment(SwingConstants.RIGHT);
				JTextField tf = new JTextField("",10);
				
				lista.add(tf);
				panel.add(labela);
				panel.add(tf);
			}
			
			JButton btnAdd = new JButton("Search");
			btnAdd.addActionListener(new ButtonClick());
			//panel.add(btnAdd);
			
			MainFrame.getInstance().setLista(lista);
			panel.add(btnAdd);
			Dimension screenSize = MainFrame.getInstance().getDonji().getSize();
			//scroll.setPreferredSize(screenSize);
			//scroll.setMaximumSize(screenSize);
			//scroll.setMinimumSize(screenSize);
			//panel.setPreferredSize(screenSize);
			
			MainFrame.getInstance().getDonji().removeAll();
			MainFrame.getInstance().getDonji().add(panel, BorderLayout.NORTH);
			MainFrame.getInstance().revalidate();
			MainFrame.getInstance().repaint();
		} else {
			JPanel pan = new JPanel();
			JPanel panel = new JPanel();
			int i = MainFrame.getInstance().getTrenutniEntitet().getAtributi().size();
			GridLayout grid = new GridLayout(0,6);
			//velicina grida
			
			panel.setLayout(grid);
			grid.setVgap(5);
			grid.setHgap(5);
			ArrayList<JTextField> lista = new ArrayList<>();
			for(Atribut a : MainFrame.getInstance().getTrenutniEntitet().getAtributi()) {
				JLabel labela = new JLabel(a.getName());
				labela.setHorizontalAlignment(SwingConstants.RIGHT);
				JTextField tf = new JTextField("",10);
				
				lista.add(tf);
				panel.add(labela);
				panel.add(tf);
			}
			JPanel help = new JPanel();
			ArrayList<JComboBox<String>> operatori = new ArrayList<>();
			for(int j = 0; j < MainFrame.getInstance().getTrenutniEntitet().getChildCount() - 1; j++) {
				JComboBox<String> cb = new JComboBox<>();
				cb.addItem("AND");
				cb.addItem("OR");
				help.add(cb);
				
				operatori.add(cb);
			}
			
			JButton btnAdd = new JButton("Search");
			btnAdd.addActionListener(new ButtonClick());
			//panel.add(btnAdd);
			
			MainFrame.getInstance().setLista(lista);
			MainFrame.getInstance().setOperatori(operatori);
			panel.add(btnAdd);
			Dimension screenSize = MainFrame.getInstance().getDonji().getSize();
			//scroll.setPreferredSize(screenSize);
			//scroll.setMaximumSize(screenSize);
			//scroll.setMinimumSize(screenSize);
			//panel.setPreferredSize(screenSize);
			
			pan.add(panel, BorderLayout.NORTH);
			pan.add(help, BorderLayout.SOUTH);
			
			MainFrame.getInstance().getDonji().removeAll();
			MainFrame.getInstance().getDonji().add(pan, BorderLayout.NORTH);
			MainFrame.getInstance().revalidate();
			MainFrame.getInstance().repaint();
		}
	}

}
