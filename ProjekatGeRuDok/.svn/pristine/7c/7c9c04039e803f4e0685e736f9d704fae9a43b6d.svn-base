package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.beans.PropertyVetoException;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.xml.ws.soap.Addressing;

import event.UpdateEvent;
import main.MainFrame;
import model.Element;
import model.GrafickiSlot;
import model.Slot;
import painter.DevicePainter;
import painter.ElementPainter;
import painter.LinijaPainter;

public class GrafickiSlotView extends SlotView {

	public GrafickiSlotView() {
		super();
		MouseController c = new MouseController();
		addMouseListener(c);
		addMouseMotionListener(c);
	}
	
	@Override
	public void updatePerformed(UpdateEvent e) {
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		for(Element dev : slot.getModel().getElementi()) {
			ElementPainter paint = dev.getElementPainter();
			if(paint instanceof DevicePainter) {
				DevicePainter dpainter = (DevicePainter)paint;
				dpainter.paint(g2d, dev);
			} else {
				LinijaPainter lpainter = (LinijaPainter)paint;
				lpainter.paint(g2d, dev);
			}
		}
		
		
		paintSelectioHandles(g2d);
		
		//iscrtavanje pravougaonika za lasso
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke((float)1, BasicStroke.CAP_SQUARE, 
				BasicStroke.JOIN_BEVEL, 1f, new float[]{(float)3, (float)6}, 0 ));
		g2d.draw(getSelectioPravougaonik());
	}
	
	private class MouseController extends MouseAdapter implements MouseMotionListener {
		@Override
		public void mousePressed(MouseEvent e) {
			setLastPos(e.getPoint());
			slot.getStateManager().getTrenutnoStanje().mousePressed(e);
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			slot.getStateManager().getTrenutnoStanje().mouseDragged(e);
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			slot.getStateManager().getTrenutnoStanje().mouseReleased(e);
		}
		
		@Override
		public void mouseMoved(MouseEvent e) {
			slot.getStateManager().getTrenutnoStanje().mouseMoved(e);
		}
	}
}
