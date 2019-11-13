package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import painter.LinijaPainter;

public class LinijaElement extends Element {

	protected SlotDevice pocetni;
	protected InputOutputElement input;
	protected SlotDevice kranji;
	protected InputOutputElement output;
	protected ArrayList<Point2D> points=new ArrayList<Point2D>();
	
	public LinijaElement(SlotDevice pocetni, InputOutputElement input, Stroke stroke, Paint paint, Color strokeColor) {
		super(stroke, paint, strokeColor);
		this.pocetni = pocetni;
		this.output = input;
		this.kranji = pocetni;
		this.input = new InputOutputElement(new Point2D.Double(output.getPosition().getX(), output.getPosition().getY()),
				new Dimension(0, 0), new BasicStroke(1F), Color.WHITE, Color.BLACK, null, 0, 0);
		elementPainter = new LinijaPainter(this);
	}
	
	public LinijaElement(LinijaElement linija) {
		super(linija);
	}
	
	public static Element napraviCustom(SlotDevice pocetni, InputOutputElement input, int brElementa) {
		Paint fill = Color.WHITE;
		LinijaElement linija = new LinijaElement(pocetni, input, new BasicStroke((float)2, BasicStroke.CAP_SQUARE,
				BasicStroke.JOIN_BEVEL), fill, Color.BLUE);
		linija.setNaziv("LINK " + brElementa);
		return linija;
	}

	public SlotDevice getPocetni() {
		return pocetni;
	}

	public void setPocetni(SlotDevice pocetni) {
		this.pocetni = pocetni;
	}

	public InputOutputElement getInput() {
		return input;
	}

	public void setInput(InputOutputElement input) {
		this.input = input;
	}

	public SlotDevice getKranji() {
		return kranji;
	}

	public void setKranji(SlotDevice kranji) {
		this.kranji = kranji;
	}

	public InputOutputElement getOutput() {
		return output;
	}

	public void setOutput(InputOutputElement output) {
		this.output = output;
	}

	public ArrayList<Point2D> getPoints() {
		return points;
	}

	public void setPoints(ArrayList<Point2D> points) {
		this.points = points;
	}
	
	public void setPainter(Element linija) {
		elementPainter = new LinijaPainter(linija);
	}

}
