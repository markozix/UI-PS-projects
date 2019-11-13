package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Point2D;

import painter.KrugPainter;

public class KrugElement extends SlotDevice {

	public KrugElement(Point2D position, Dimension size, Stroke stroke, Paint paint, Color strokeColor) {
		super(stroke, paint, strokeColor, position, size, 2, 1);
		elementPainter = new KrugPainter(this);
	}

	public KrugElement(KrugElement krug) {
		super(krug);
		setNaziv("kopija");
		elementPainter = new KrugPainter(this);
	}
	
	public static SlotDevice napraviCustom(Point2D pos, int brElementa) {
		Point2D position = (Point2D) pos.clone();
        Paint fill = Color.WHITE;
        KrugElement krug = new KrugElement(position, new Dimension(50, 50), 
        		new BasicStroke((float)2, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL), fill, Color.BLACK); 
        krug.setNaziv("Krug " + brElementa);
        return krug;
	}
}
