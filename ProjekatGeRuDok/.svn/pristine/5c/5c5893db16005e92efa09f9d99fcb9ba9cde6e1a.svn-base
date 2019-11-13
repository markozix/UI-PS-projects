package view;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Iterator;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import event.UpdateEvent;
import event.UpdateListener;
import model.Element;
import model.Slot;
import model.SlotDevice;
import painter.ElementPainter;

public class EditorView extends JInternalFrame implements UpdateListener {

	static int openFrameCount = 0;

	static final int xOffset = 30, yOffset = 30;

	private Slot slot;

	private JPanel framework;

	public EditorView() {

		super("Graficki editor", true, true, true, true);
		++openFrameCount;
		setLocation(xOffset * openFrameCount, yOffset * openFrameCount);
		setSize(new Dimension(500, 500));
		setVisible(true);

		framework = new Framework();
		framework.setCursor(new Cursor(Cursor.HAND_CURSOR));
		framework.setBackground(Color.WHITE);
		add(framework, BorderLayout.CENTER);

	}

	public void setSlot(Slot slot) {
		this.slot = slot;
		this.setName(slot.getNaziv());
		this.slot.getModel().addUpdateListener(this);
		setTitle(slot.getNaziv());
	}

	public Slot getSlot() {
		return slot;
	}

	@Override
	public void updatePerformed(UpdateEvent e) {
		repaint();

	}

	private class Framework extends JPanel {

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			Graphics2D g2 = (Graphics2D) g;
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
			Iterator<Element> iter = slot.getModel().getDeviceIterator();
			while (iter.hasNext()) {
				SlotDevice s = (SlotDevice) iter.next();
				ElementPainter painter = s.getElementPainter();
				painter.paint(g2, s);
			}

		}

	}

}
