package controller.state;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import main.MainFrame;
import modeli.Atribut;

public class SortState_Izgled implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		JPopupMenu jp = new JPopupMenu();
		JMenuItem opadajuce = new JMenuItem("Opadajuce");
		JMenuItem rastuce = new JMenuItem("Rastuce");
		
		//treba dodati funkcionalnosti
		opadajuce.addActionListener(new SortActionOpadajuce());
		rastuce.addActionListener(new SortActionRastuce());
		jp.add(opadajuce);
		jp.add(rastuce);	

		
		
		
		MainFrame.getInstance().getTrenutnaTabela().setColumnSelectionAllowed(true);
		MainFrame.getInstance().getTrenutnaTabela().addMouseListener(new MouseAdapter(){
			
			
			public void mouseClicked(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e)) {
					jp.show(MainFrame.getInstance().getTrenutnaTabela(), e.getX(), e.getY());
				}
			}
			
			
			
		});
	
			
			
		MainFrame.getInstance().revalidate();
		MainFrame.getInstance().repaint();
		
	}
}


