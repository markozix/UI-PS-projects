package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.SwingUtilities;
import javax.swing.tree.TreeNode;

import event.UpdateEvent;
import event.UpdateListener;
import main.MainFrame;

public class Workspace implements Container, TreeNode {

	private String naziv;
	private transient ArrayList<Projekat> projekti = new ArrayList<>();
	private File fajl;
	// dodati eventualno argument za naziv ali eto ne znam kako cemo to pa neka ga
	// ovako za sad
	public Workspace(File f) {
		super();
		this.fajl = f;
	}

	@Override
	public String toString() {
		return "Workspace";
	}

	@Override
	public void add(Object dete) {
		if (dete instanceof Projekat)
			projekti.add((Projekat) dete);
	}

	@Override
	public void remove(Object dete) {
		if (dete instanceof Projekat)
			projekti.remove((Projekat) dete);

	}

	@Override
	public Enumeration children() {
		return (Enumeration<Projekat>) projekti;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return projekti.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return projekti.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		return projekti.indexOf((Projekat) node);
	}

	@Override
	public TreeNode getParent() {
		return null;
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public ArrayList<Projekat> getProjekti() {
		return projekti;
	}

	public void setProjekti(ArrayList<Projekat> projekti) {
		this.projekti = projekti;
	}

	public File getFajl() {
		return fajl;
	}

	public void setFajl(File fajl) {
		this.fajl = fajl;
	}

	
	
}
