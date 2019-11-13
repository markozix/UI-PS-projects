package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import main.MainFrame;
import painter.InputOutputPainter;

public class SlotDevice extends Element {

	protected Dimension size;
	protected Point2D position;
	protected double scale;
	protected double rotation;
	protected int brIn;
	protected int brOut;
	protected ArrayList<InputOutputElement> inputs = new ArrayList<>();
	protected ArrayList<InputOutputElement> outputs = new ArrayList<>();
	
	public SlotDevice(Stroke stroke, Paint paint, Color strokeColor, Point2D postition, Dimension size, int brIn, int brOut) {
		super(stroke, paint, strokeColor);
		this.size = size;
		postition.setLocation(postition.getX() - size.getWidth() / 2, postition.getY() - size.getHeight() / 2);
		this.position = postition;
		this.brIn = brIn;
		this.brOut = brOut;
		this.strokeColor = strokeColor;
		for (int i = 0; i < brIn; i++){
			Point2D ioPos = new Point2D.Double(position.getX(), 
					                           position.getY() + (getSize().getHeight() / (getBrIn() + 1)) * (i + 1));
			inputs.add((InputOutputElement) InputOutputElement.napraviCustom(ioPos, stroke, paint, this, i + 1, 
					InputOutputElement.INPUT));
			((Slot)MainFrame.getInstance().getTree().getLastSelectedPathComponent()).getModel().addElement(inputs.get(i));
		}
		for (int i = 0; i < brOut; i++){
			Point2D ioPos = new Point2D.Double(position.getX() + size.width,
					                           position.getY() + (getSize().getHeight() / (getBrOut() + 1)) * (i + 1));
			outputs.add((InputOutputElement) InputOutputElement.napraviCustom(ioPos, stroke, paint, this, i + 1,
					InputOutputElement.OUTPUT));
			((Slot)MainFrame.getInstance().getTree().getLastSelectedPathComponent()).getModel().addElement(outputs.get(i));
      	}		
	}
	
	public SlotDevice(SlotDevice device) {
		super(device);
		this.size = device.size;
		this.position = device.position;
	}

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}

	public Point2D getPosition() {
		return position;
	}

	public void setPosition(Point2D position) {
		this.position = position;
	}

	public double getScale() {
		return scale;
	}

	public void setScale(double scale) {
		this.scale = scale;
	}

	public double getRotation() {
		return rotation;
	}

	public void setRotation(double rotation) {
		this.rotation = rotation;
	}

	public int getBrIn() {
		return brIn;
	}

	public void setBrIn(int brIn) {
		this.brIn = brIn;
	}

	public int getBrOut() {
		return brOut;
	}

	public void setBrOut(int brOut) {
		this.brOut = brOut;
	}

	public ArrayList<InputOutputElement> getInputs() {
		return inputs;
	}

	public void setInputs(ArrayList<InputOutputElement> inputs) {
		this.inputs = inputs;
	}

	public ArrayList<InputOutputElement> getOutputs() {
		return outputs;
	}

	public void setOutputs(ArrayList<InputOutputElement> outputs) {
		this.outputs = outputs;
	}
	
	public Dimension getScaledSize() {
		return null;
	}

}
