package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;

import painter.InputOutputPainter;


public class InputOutputElement extends Element {

	public static final int INPUT = 0;
	public static final int OUTPUT = 1;
	protected Point2D position;
	protected SlotDevice device;
	protected int broj;
	protected int type;

	public InputOutputElement(Point2D position, Dimension size, Stroke stroke, Paint paint, Color strokeColor,
            SlotDevice device, int broj, int type) {
		super(stroke, paint, strokeColor);
		this.device = device;
		this.broj = broj;
		this.type = type;
		this.position = position;
		elementPainter = new InputOutputPainter(this);
	}
	
	public InputOutputElement(InputOutputElement element, SlotDevice device) {
		super(element);
	}
	
	public static Element napraviCustom(Point2D pos, Stroke stroke, Paint paint, SlotDevice device, int broj, int type) {
		Point2D position = (Point2D) pos.clone();
		position.setLocation(position.getX(), position.getY());
		InputOutputElement io = new InputOutputElement(position, new Dimension(40, 25), stroke, paint, Color.BLUE,
				device, broj, type);
		io.setNaziv("IO " + broj);
		return io;
	}

	public Point2D getPosition() {
		return position;
	}

	public void setPosition(Point2D position) {
		this.position = position;
	}

	public SlotDevice getDevice() {
		return device;
	}

	public void setDevice(SlotDevice device) {
		this.device = device;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	
}

