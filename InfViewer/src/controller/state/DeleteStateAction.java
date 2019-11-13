package controller.state;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.MainFrame;
import modeli.Atribut;

public class DeleteStateAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
MainFrame.getInstance().getTrenutniEntitet().getStateManager().setDeleteState();
		
		JPanel pan = new JPanel();
		JPanel panel = new JPanel();
		int i = MainFrame.getInstance().getTrenutniEntitet().getAtributi().size();
		
	
	
		
		JButton btnAdd = new JButton("Delete");
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