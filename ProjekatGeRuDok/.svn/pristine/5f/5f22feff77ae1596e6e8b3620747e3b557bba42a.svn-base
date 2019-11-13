package view;

import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import akcije.ProjekatClosedAction;
import main.MainFrame;
import model.Dokument;
import model.Projekat;

public class ProjekatView extends JInternalFrame {

	private Projekat projekat;
	private JPanel framework;
	private JTabbedPane tabovi;
	private ArrayList<DokumentView> lista;

	public ProjekatView() {
		super("", true, true, true, true);
		lista = new ArrayList<>();
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		if(MainFrame.getInstance().getMeni().getSelectedOption() != 1) {
			if(MainFrame.getInstance().getMeni().getSelectedOption() == 2) {
				setLocation((MainFrame.getInstance().getDesniDesktop().getWidth() / (getFrejmovi() + 1)) * (getFrejmovi()), 0);
				setSize(MainFrame.getInstance().getDesniDesktop().getWidth() / (getFrejmovi() + 1), MainFrame.getInstance().getDesniDesktop()
						.getHeight());
				int i = MainFrame.getInstance().getDesniDesktop().getAllFrames().length - 1;
				for(JInternalFrame frame : MainFrame.getInstance().getDesniDesktop().getAllFrames()) {
					frame.setLocation((MainFrame.getInstance().getDesniDesktop().getWidth() / (getFrejmovi() + 1)) * i, 0);
					frame.setSize(MainFrame.getInstance().getDesniDesktop().getWidth() / (getFrejmovi() + 1), MainFrame.getInstance()
							.getDesniDesktop().getHeight());
					i--;
				}
			} else {
				setLocation(0, (MainFrame.getInstance().getDesniDesktop().getHeight() / (getFrejmovi() + 1)) * getFrejmovi());
				setSize(MainFrame.getInstance().getWidth(), MainFrame.getInstance().getDesniDesktop().getHeight() / (getFrejmovi() + 1));
				int i = MainFrame.getInstance().getDesniDesktop().getAllFrames().length - 1;
				for(JInternalFrame frame : MainFrame.getInstance().getDesniDesktop().getAllFrames()) {
					frame.setLocation(0, (MainFrame.getInstance().getDesniDesktop().getHeight() / (getFrejmovi() + 1)) * i);
					frame.setSize(MainFrame.getInstance().getDesniDesktop().getWidth(), MainFrame.getInstance()
							.getDesniDesktop().getHeight() / (getFrejmovi() + 1));
					i--;
				}
			}
		} else {
			setLocation(30 * (getFrejmovi() + 1), 30 * (getFrejmovi() + 1));
			setSize(400, 400);
		}
		setVisible(true);
		tabovi = new JTabbedPane();
		this.add(tabovi);
		addInternalFrameListener(new ProjekatClosedAction());
	}

	public void dodaj(DokumentView d) {
		lista.add(d);
	}
	
	public void obrisi(DokumentView d){
		lista.remove(d);
	}

	public ArrayList<DokumentView> getLista() {
		return lista;
	}

	public void setProjekat(Projekat projekat) {
		this.projekat = projekat;
		setTitle(projekat.getNaziv());
	}

	public Projekat getProjekat() {
		return projekat;
	}

	private class Framework extends JPanel {

	}
	
	public int getFrejmovi() {
		int i = 0;
		for(JInternalFrame frame : MainFrame.getInstance().getDesniDesktop().getAllFrames()) {
			if(frame.isShowing()) {
				i++;
			}
		}
		return i;
	}

	public JTabbedPane getTabovi() {
		return tabovi;
	}

	@Override
	public String toString() {
		return projekat.toString();
	}

}
