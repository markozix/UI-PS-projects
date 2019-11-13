package controller.state;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import main.MainFrame;
import modeli.Atribut;

public class DetailStateAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame.getInstance().getTrenutniEntitet().getStateManager().setDetailState();
		
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
		
		MainFrame.getInstance().setLista(lista);
		MainFrame.getInstance().getTrenutnaTabela().addMouseListener(new FieldSelected());
		JButton btnAdd = new JButton("Detail");
		btnAdd.addActionListener(new ButtonClick());
		//panel.add(btnAdd);
		
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
	}

}
