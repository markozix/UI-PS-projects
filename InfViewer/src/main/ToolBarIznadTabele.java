package main;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import controller.ChangeFetch;
import controller.FetchBlock;
import controller.state.AddStateAction;
import controller.state.DeleteStateAction;
import controller.state.DetailStateAction;
import controller.state.Merge;
import controller.state.RelacijaStateAction;
import controller.state.SearchStateAction;
import controller.state.SortState_Izgled;
import controller.state.UpdateStateAction;

public class ToolBarIznadTabele extends JToolBar {

	static int br = 0;
	JLabel brojac = new JLabel("0");

	public ToolBarIznadTabele() {

		JLabel blockFactor = new JLabel("f(block factor): ");
		JTextField blockTf = new JTextField("" + MainFrame.getInstance().getTrenutniEntitet().getBlockSize());
		blockTf.setMaximumSize(new Dimension(50, 25));
		JButton changeF = new JButton("Change f");
		changeF.addActionListener(new ChangeFetch(blockTf));
		JButton btnFetch = new JButton("Fetch next block");
		btnFetch.addActionListener(new FetchBlock());
		JButton dodaj = new JButton("Add");
		JButton izbrisi = new JButton("Delete");
		JButton update = new JButton("Update");
		JButton pretrazi = new JButton("Search");
		JButton btnDetail = new JButton("Detail");
		JButton brnRelation = new JButton("Relation");
		JButton btnMerge = new JButton("Merge"); // za sekvencijalne datoteke
		brojac.setText("" + MainFrame.getInstance().getTrenutniEntitet().getOpened());
		
		
		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new SortState_Izgled());

		// state akcije

		dodaj.addActionListener(new AddStateAction());
		izbrisi.addActionListener(new DeleteStateAction());
		update.addActionListener(new UpdateStateAction());
		pretrazi.addActionListener(new SearchStateAction());
		btnDetail.addActionListener(new DetailStateAction());
		brnRelation.addActionListener(new RelacijaStateAction());
		btnMerge.addActionListener(new Merge());

		// btnFetch.addActionListener(null);
		// changeF.addActionListener(null);

		add(blockFactor);
		add(blockTf);
		add(changeF);
		addSeparator();
		add(btnFetch);
		add(dodaj);
		add(izbrisi);
		add(update);
		add(pretrazi);
		add(brnRelation);
		add(btnDetail);
		add(btnMerge);
		add(btnSort);
		addSeparator();
		add(brojac);
		setFloatable(false);

	}

	public int getBr() {
		return br;
	}

	public void setBr(int br) {
		this.br = br;
	}

	public JLabel getBrojac() {
		return brojac;
	}

	public void setBrojac(JLabel brojac) {
		this.brojac = brojac;
	}

}
