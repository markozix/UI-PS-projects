package akcije;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.server.Operation;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;

import main.MainFrame;

public class DodajSlotProzorAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JDialog dialog = new JDialog(MainFrame.getInstance(), "Izaberite tip slota", true);
		dialog.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(0, 10, 10, 0);
		dialog.setSize(new Dimension(550, 400));
		dialog.setLocationRelativeTo(MainFrame.getInstance());

		JButton btnText = new JButton();
		btnText.setSize(250, 250);
		ImageIcon tex = new ImageIcon(getClass().getResource("text.png"));
		Image it = tex.getImage();
		Image it1 = it.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		tex = new ImageIcon(it1);
		btnText.setMaximumSize(new Dimension(250, 250));
		btnText.setIcon(tex);
		btnText.setBorder(null);
		btnText.addActionListener(new DodajTekstualniSlotAction());
		btnText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)) {
					dialog.setVisible(false);
				}
			}
		});

		JButton btnGrafika = new JButton();
		btnGrafika.setSize(250, 250);
		ImageIcon gr = new ImageIcon(getClass().getResource("grafika.png"));
		Image ir = gr.getImage();
		Image ir1 = ir.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		gr = new ImageIcon(ir1);
		btnGrafika.setMaximumSize(new Dimension(250, 250));
		btnGrafika.setIcon(gr);
		btnGrafika.setBorder(null);
		btnGrafika.addActionListener(new DodajGrafickiSlotAction());
		btnGrafika.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)) {
					dialog.setVisible(false);
				}
			}
		});

		dialog.add(btnText, c);
		dialog.add(btnGrafika, c);
		dialog.setVisible(true);

	}

}
