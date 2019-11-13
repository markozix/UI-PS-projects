package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Point2D;

import painter.TrougaoPainter;

public class TrougaoElement extends SlotDevice{

	public TrougaoElement(Point2D position, Dimension size, Stroke stroke, Paint paint, Color strokeColor) {
		super(stroke, paint, strokeColor, position, size, 1, 1);
		elementPainter = new TrougaoPainter(this);
	}

	public TrougaoElement(TrougaoElement trougao) {
		super(trougao);
		setNaziv("kopija");
		elementPainter = new TrougaoPainter(this);
	}
	
	public static SlotDevice napraviCustom(Point2D pos, int brElementa) {
		Point2D position = (Point2D) pos.clone();
		Paint fill = Color.WHITE;
		TrougaoElement trougao = new TrougaoElement(position, new Dimension(50, 50),
				new BasicStroke((float)2, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL), fill, Color.BLACK);
		trougao.setNaziv("Trougao " + brElementa);
		return trougao;
	}
}
