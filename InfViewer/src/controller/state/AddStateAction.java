package controller.state;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import main.MainFrame;
import modeli.Atribut;

public class AddStateAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		MainFrame.getInstance().getTrenutniEntitet().getStateManager().setAddState();

		JPanel pan = new JPanel();
		JPanel panel = new JPanel();
		int i = MainFrame.getInstance().getTrenutniEntitet().getAtributi().size();
		GridLayout grid = new GridLayout(0, 6);
		// velicina grida

		panel.setLayout(grid);
		grid.setVgap(5);
		grid.setHgap(5);
		ArrayList<JTextField> lista = new ArrayList<>();
		for (Atribut a : MainFrame.getInstance().getTrenutniEntitet().getAtributi()) {
			JLabel labela = new JLabel(a.getName());
			labela.setHorizontalAlignment(SwingConstants.RIGHT);
			JTextField tf = new JTextField("", 10);

			lista.add(tf);
			panel.add(labela);
			panel.add(tf);
		}

		MainFrame.getInstance().setLista(lista);
		JButton btnAdd = new JButton("Dodaj");
		btnAdd.addActionListener(new ButtonClick());
		// panel.add(btnAdd);

		panel.add(btnAdd);
		Dimension screenSize = MainFrame.getInstance().getDonji().getSize();
		// scroll.setPreferredSize(screenSize);
		// scroll.setMaximumSize(screenSize);
		// scroll.setMinimumSize(screenSize);
		// panel.setPreferredSize(screenSize);

		//MainFrame.getInstance().getDonjiTabovi().removeAll();
		MainFrame.getInstance().getDonji().removeAll();
		MainFrame.getInstance().getDonji().add(panel, BorderLayout.NORTH);
		MainFrame.getInstance().revalidate();
		MainFrame.getInstance().repaint();

		
		//MainFrame.getInstance().getDonjiTabovi().removeAll();
		//MainFrame.getInstance().getDonjiTabovi().add(MainFrame.getInstance().getTrenutniEntitet().getName(), panel);
		
		

	}

}
