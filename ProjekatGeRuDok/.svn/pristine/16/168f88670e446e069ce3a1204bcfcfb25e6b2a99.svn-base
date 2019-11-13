package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

import event.UpdateListener;
import main.MainFrame;
import model.Slot;
import model.TekstualniSlot;

public class TekstualniSlotView extends SlotView {

	private TekstualniSlot ts;

	public TekstualniSlotView() {
		napraviSlot();
		setAlignmentX(Component.LEFT_ALIGNMENT);
	}

	public void napraviSlot() {
		JPanel panel = new JPanel();
		JTextPane text = new JTextPane();
		text.setEditable(false);

		panel.setBackground(Color.YELLOW);
		panel.setPreferredSize(new Dimension(100, 150));
		panel.add(text);

		panel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)) {

					Slot s = new Slot("Tekstualni Editor");
					EditorTView view = new EditorTView(text);
					view.setSlot(s);
					MainFrame.getInstance().getDesniDesktop().add(view);

					try {
						view.setSelected(true);
					} catch (PropertyVetoException k) {
						k.printStackTrace();
					}
				}

			}
		});

		add(panel);
	}

	public TekstualniSlot getTs() {
		return ts;
	}

	public void setTs(TekstualniSlot ts) {
		this.ts = ts;
	}

}
