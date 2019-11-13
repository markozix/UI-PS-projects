package controller.state;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import main.MainFrame;
import main.ToolBarIznadTabele;

public class SaveTabela implements ActionListener {

	private String[][] matrica;
	private JDialog dialog;
	private Object[] heder;
	
	public SaveTabela(String[][] matrica, JDialog dialog, Object[] heder) {
		this.matrica = matrica;
		this.dialog = dialog;
		this.heder = heder;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
		int zaBrisanje = -1;
		for (int i = 0; i < MainFrame.getInstance().getGornjiTabovi().getTabCount(); i++) {
			if (MainFrame.getInstance().getGornjiTabovi().getTitleAt(i)
					.equals(MainFrame.getInstance().getTrenutniEntitet().getEntPaket().getNaziv() + ":"
							+ MainFrame.getInstance().getTrenutniEntitet().getName())) {
				zaBrisanje = i;
				break;
			}
		}
		JPanel panel = new JPanel();
		BorderLayout bl = new BorderLayout();
		panel.setLayout(bl);
		JTable tabela = new JTable(matrica, heder);
		MainFrame.getInstance().setTrenutnaTabela(tabela);
		JScrollPane scroll = new JScrollPane(tabela);
		ToolBarIznadTabele toolbar = new ToolBarIznadTabele();
		Dimension screenSize = MainFrame.getInstance().getGornji().getSize();
		scroll.setPreferredSize(screenSize);
		scroll.setMaximumSize(screenSize);
		scroll.setMinimumSize(screenSize);
		tabela.setFillsViewportHeight(true);
		panel.add(toolbar, BorderLayout.NORTH);
		panel.add(scroll);
		MainFrame.getInstance().getGornjiTabovi().removeChangeListener(MainFrame.getInstance().getOr());
		MainFrame.getInstance().getGornjiTabovi().remove(zaBrisanje);
		MainFrame.getInstance().getGornjiTabovi().addChangeListener(MainFrame.getInstance().getOr());
		MainFrame.getInstance().getGornjiTabovi()
				.addTab(MainFrame.getInstance().getTrenutniEntitet().getEntPaket().getNaziv() + ":"
						+ MainFrame.getInstance().getTrenutniEntitet().getName(), panel);
		MainFrame.getInstance().getGornjiTabovi()
				.setSelectedIndex(MainFrame.getInstance().getGornjiTabovi().getTabCount() - 1);
		MainFrame.getInstance().getTrenutniEntitet().getStateManager().setSearchState();
	}

}
