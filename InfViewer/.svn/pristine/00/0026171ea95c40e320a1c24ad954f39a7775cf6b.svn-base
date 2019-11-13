package modeli;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

public class InformacioniResurs implements TreeNode, Container {
	private String naziv;
	private ArrayList<Paket> paketi = new ArrayList<>();
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public ArrayList<Paket> getPaket() {
		return paketi;
	}
	public void setPaket(ArrayList<Paket> entiteti) {
		this.paketi = entiteti;
	}
	@Override
	public Enumeration children() {
		return (Enumeration<Paket>) paketi;
	}
	@Override
	public boolean getAllowsChildren() {
		return true;
	}
	@Override
	public TreeNode getChildAt(int childIndex) {
		return paketi.get(childIndex);
	}
	@Override
	public int getChildCount() {
		return paketi.size();
	}
	@Override
	public int getIndex(TreeNode node) {
		return paketi.indexOf((Paket)node);
	}
	@Override
	public TreeNode getParent() {
		return null;
	}
	@Override
	public boolean isLeaf() {
		return false;
	}
	@Override
	public void add(Object dete) {
		if(dete instanceof Paket) {
			paketi.add((Paket)dete);
		}
	}
	@Override
	public void remove(Object dete) {
		if(dete instanceof Paket) {
			paketi.remove((Paket)dete);
		}
	}
	
	@Override
	public String toString() {
		return naziv;
	}
	public ArrayList<Paket> getPaketi() {
		return paketi;
	}
	public void setPaketi(ArrayList<Paket> paketi) {
		this.paketi = paketi;
	}
}
