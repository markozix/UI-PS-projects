package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Point2D;

import painter.DevicePainter;
import painter.PravougaonikPainter;

public class PravougaonikElement extends SlotDevice {

	public PravougaonikElement(Point2D position, Dimension size, Stroke stroke, Paint paint, Color strokeColor) {
		super(stroke, paint, strokeColor, position, size, 2, 1);
		elementPainter = new PravougaonikPainter(this);
	}

	public PravougaonikElement(PravougaonikElement pravougaonik) {
		super(pravougaonik);
		setNaziv("kopija");
		elementPainter = new PravougaonikPainter(this);
	}

	public static SlotDevice napraviCustom(Point2D pos, int brElementa) {
		Point2D position = (Point2D) pos.clone();
		Paint fill = Color.WHITE;
		PravougaonikElement pravougaonik = new PravougaonikElement(position, new Dimension(80, 40),
				new BasicStroke((float)2, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL), fill, Color.BLACK);
		pravougaonik.setNaziv("Pravougaonik " + brElementa);
		return pravougaonik;
	}

}
