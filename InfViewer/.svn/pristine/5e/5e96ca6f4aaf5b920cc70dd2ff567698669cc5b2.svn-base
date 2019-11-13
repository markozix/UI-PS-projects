package modeli;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

public class Paket extends InformacioniResurs {

	private String naziv;
	private ArrayList<Entitet> entiteti = new ArrayList<>();
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public ArrayList<Entitet> getEntiteti() {
		return entiteti;
	}
	public void setEntiteti(ArrayList<Entitet> entiteti) {
		this.entiteti = entiteti;
	}
	@Override
	public Enumeration children() {
		return (Enumeration<Entitet>) entiteti;
	}
	@Override
	public boolean getAllowsChildren() {
		return true;
	}
	@Override
	public TreeNode getChildAt(int childIndex) {
		return entiteti.get(childIndex);
	}
	@Override
	public int getChildCount() {
		return entiteti.size();
	}
	@Override
	public int getIndex(TreeNode node) {
		return entiteti.indexOf((Entitet)node);
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
		if(dete instanceof Entitet) {
			entiteti.add((Entitet)dete);
		}
	}
	@Override
	public void remove(Object dete) {
		if(dete instanceof Entitet) {
			entiteti.remove((Entitet)dete);
		}
	}
	
	@Override
	public String toString() {
		return naziv;
	}
}
