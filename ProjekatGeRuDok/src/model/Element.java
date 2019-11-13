package model;

import java.awt.Color;
import java.awt.Paint;
import java.awt.Stroke;
import java.io.Serializable;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

import painter.ElementPainter;
import serijalizacija.SerializableStrokeAdapter;

public abstract class Element implements TreeNode, Serializable{

	protected String naziv;
	protected Paint paint;
	protected SerializableStrokeAdapter strokeAdapter;
	protected Color strokeColor;
	protected ElementPainter elementPainter;
	
	public Element(Stroke stroke, Paint paint, Color strokeColor) {
		strokeAdapter = new SerializableStrokeAdapter(stroke);
		this.paint = paint;
		this.strokeColor = strokeColor;
	}
	
	public Element(Element drugi) {
		this.naziv = drugi.naziv;
		this.paint = drugi.paint;
		this.strokeAdapter = drugi.strokeAdapter;
		this.strokeColor = drugi.strokeColor;
		this.elementPainter = drugi.elementPainter;
	}
	@Override
	public Enumeration children() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIndex(TreeNode node) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Paint getPaint() {
		return paint;
	}

	public void setPaint(Paint paint) {
		this.paint = paint;
	}

	public SerializableStrokeAdapter getStrokeAdapter() {
		return strokeAdapter;
	}

	public void setStrokeAdapter(Stroke stroke) {
		this.strokeAdapter = new SerializableStrokeAdapter(stroke);
	}

	public Color getStrokeColor() {
		return strokeColor;
	}

	public void setStrokeColor(Color strkeColor) {
		this.strokeColor = strkeColor;
	}

	public ElementPainter getElementPainter() {
		return elementPainter;
	}

	public void setElementPainter(ElementPainter elementPainter) {
		this.elementPainter = elementPainter;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
}
