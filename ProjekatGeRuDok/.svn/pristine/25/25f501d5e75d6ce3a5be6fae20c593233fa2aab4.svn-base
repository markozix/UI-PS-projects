package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Dimension2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import event.UpdateEvent;
import event.UpdateListener;
import komande.CommandManager;
import model.Element;
import model.LinijaElement;
import model.PravougaonikElement;
import model.Slot;
import model.SlotDevice;
import model.SlotModel;
import painter.ElementPainter;
import state.StateManager;

public class SlotView extends JPanel implements UpdateListener {
	protected Slot slot;
	private JPanel framework;
	private Point2D lastPos = null;
	private Rectangle2D selectioPravougaonik = new Rectangle2D.Double();
	public static final int handleSize = 7;
	public static final int OR=1;
	public static final int AND=2;
	public static final int INPUT=3;
	public static final int CIRCLE=4;
	public static final int RECTANGLE=5;
	public static final int TROUGAO = 6;
	
	public SlotView() {
		this.setBackground(Color.GRAY);
		setMaximumSize(new Dimension(300, 400));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
//		addMouseListener(new MouseController());
	}
	
	public SlotView(SlotView sv){
		this.setBackground(Color.GRAY);
		setMaximumSize(new Dimension(300, 400));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}
	
	public Point2D getLastPos() {
		return lastPos;
	}

	public void setLastPos(Point2D lastPos) {
		this.lastPos = lastPos;
	}

	public Rectangle2D getSelectioPravougaonik() {
		return selectioPravougaonik;
	}

	public void setSelectioPravougaonik(Rectangle2D selectioPravougaonik) {
		this.selectioPravougaonik = selectioPravougaonik;
	}

	public void paste() {
		
	}
	
	public void copy() {
		
	}
	
	public void cut() {
		
	}
	
	
	public void setMouseCursor(Point2D point){
		
		Handle handle = getDeviceAndHandleForPoint(point);

		if(handle != null){
			Cursor cursor = null;
			
			switch(handle){
			case North: cursor = Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR);break;
			case South: cursor = Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR);break;
			case East: cursor = Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR);break;
			case West: cursor = Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR);break;
			case SouthEast: cursor = Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR);break;
			case NorthWest: cursor = Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR);break;
			case SouthWest: cursor = Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR);break;
			case NorthEast: cursor = Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR);break;
			}
			setCursor(cursor);
		}
		else
			setCursor(Cursor.getDefaultCursor());
	}

	@Override
	public void updatePerformed(UpdateEvent e) {
		repaint();
	}

//	@Override
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		Graphics2D g2d = (Graphics2D) g;
//		for(Element dev : slot.getModel().getElementi()) {
//			ElementPainter paint = dev.getElementPainter();
//			paint.paint(g2d, dev);
//		}
//	}
	
	public void paintSelectioHandles(Graphics2D g2) {
		Iterator<Element> it = slot.getSelectionModel().getSelectionList().iterator();
		while(it.hasNext()){
			Element element =  it.next();
			if (element instanceof SlotDevice){
				SlotDevice device=(SlotDevice)element;
				// Iscrtavanje pravougaonika sa isprekidanom linijom
				g2.setStroke(new BasicStroke((float)1, BasicStroke.CAP_SQUARE, 
						BasicStroke.JOIN_BEVEL, 1f, new float[]{3f, 6f}, 0 ));
				g2.setPaint(Color.BLACK);
			
				g2.drawRect((int)device.getPosition().getX(), (int)device.getPosition().getY(),
						(int)device.getSize().getWidth(), (int)device.getSize().getHeight());
			
				// 	Iscrtavanje hendlova
				for(Handle e: Handle.values()){
					paintSelectionHandle(g2, getHandlePoint(device.getPosition(), device.getSize(), e));
				}
			
			
			}else {
				//isrtavanje handlova za link
				LinijaElement link=(LinijaElement)element;
			

				Point2D bp=null;
				bp=link.getOutput().getPosition();
				g2.setPaint(Color.BLACK);
				g2.setStroke(new BasicStroke((float)2, BasicStroke.CAP_SQUARE, 
							BasicStroke.JOIN_BEVEL));
				
				g2.drawRect((int)bp.getX()-handleSize/2, (int)bp.getY()-handleSize/2,
						handleSize, handleSize);
	
				Iterator<Point2D> itp = link.getPoints().iterator();
				while(itp.hasNext()){
					bp = (Point2D) itp.next();
					g2.drawRect((int)bp.getX()-handleSize/2, (int)bp.getY()-handleSize/2,
							handleSize, handleSize);
				
				}
				bp=link.getInput().getPosition();
				g2.drawRect((int)bp.getX()-handleSize/2, (int)bp.getY()-handleSize/2,
						handleSize, handleSize);
			}

		}
	}
	
	public void paintSelectionHandle(Graphics2D g2, Point2D position) {
		double size = handleSize;
		g2.fill(new Rectangle2D.Double(position.getX()-size/2, position.getY()-size/2, 
				size, size));
	}
	
	public Point2D getHandlePoint(Point2D topLeft, Dimension2D size, Handle handlePosition) {
		double x=0, y=0;
		
		// Odreðivanje y koordinate
		
		// Ako su gornji hendlovi
		if(handlePosition == Handle.NorthWest || handlePosition == Handle.North || handlePosition == Handle.NorthEast){
			y = topLeft.getY();
		}
		// Ako su centralni po y osi
		if(handlePosition == Handle.East || handlePosition == Handle.West){
			y = topLeft.getY()+size.getHeight()/2;
		}
		//Ako su donji
		if(handlePosition == Handle.SouthWest || handlePosition == Handle.South || handlePosition == Handle.SouthEast){
			y = topLeft.getY() + size.getHeight();
		}

		// Odreðivanje x koordinate
		
		// Ako su levi
		if(handlePosition == Handle.NorthWest || handlePosition == Handle.West || handlePosition == Handle.SouthWest){
			x = topLeft.getX();
		}
		// ako su centralni po x osi
		if(handlePosition == Handle.North || handlePosition == Handle.South){
			x = topLeft.getX() + size.getWidth()/2;
		}
		// ako su desni
		if(handlePosition == Handle.NorthEast || handlePosition == Handle.East || handlePosition == Handle.SouthEast){
			x = topLeft.getX() + size.getWidth();
		}
		
		return new Point2D.Double(x,y);
		
	}
	
	public Handle getDeviceAndHandleForPoint(Point2D point) {
		Element element;
		
		Iterator<Element> it = slot.getSelectionModel().getSelectionList().iterator();
		while(it.hasNext()){
			element = it.next();
			return getHandleForPoint(element, point);
		}
		return null;
	}
	
	private Handle getHandleForPoint(Element element, Point2D point) {
		for(Handle h: Handle.values()){
			if(isPointInHandle(element, point, h)){
				return h;
			}
		}
		return null;
	}
	
	public boolean isPointInHandle(Element element, Point2D point, Handle handle){
		if (element instanceof SlotDevice){
			SlotDevice device=(SlotDevice)element;
			Point2D handleCenter = getHandlePoint(device.getPosition(), device.getSize(), handle);
			return ( (Math.abs(point.getX()-handleCenter.getX())<=(double)handleSize/2) && 
					(Math.abs(point.getY()-handleCenter.getY())<=(double)handleSize/2) );
		}else 
			return false;
	}
	
	public enum Direction{
		Up, Down, Left, Right
	}
	
	public enum Handle {
		North, East, South, West, NorthEast, NorthWest, SouthEast, SouthWest
	}
	
//	private class MouseController extends MouseAdapter {
//		@Override
//		public void mousePressed(MouseEvent e) {
//			slot.getStateManager().getTrenutnoStanje().mousePressed(e);
//		}
//		
//		@Override
//		public void mouseDragged(MouseEvent e) {
//			slot.getStateManager().getTrenutnoStanje().mouseDragged(e);
//		}
//		
//		@Override
//		public void mouseReleased(MouseEvent e) {
//			slot.getStateManager().getTrenutnoStanje().mouseReleased(e);
//		}
//	}
	
//	private class Framework extends JPanel {
//		@Override
//		protected void paintComponent(Graphics g) {
//			super.paintComponent(g);
//			Graphics2D g2d = (Graphics2D) g;
//			Iterator<SlotDevice> it = slot.getModel().getDeviceIterator();
//			while(it.hasNext()) {
//				SlotDevice dev = (SlotDevice) it.next();
//				ElementPainter paint = dev.getElementPainter();
//				paint.paint(g2d, dev);
//			}
//		}
//	}
}
