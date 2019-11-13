package model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.SwingUtilities;
import javax.swing.tree.TreeNode;

import event.UpdateEvent;
import event.UpdateListener;
import main.MainFrame;

public class Projekat implements Container, TreeNode, Serializable, UpdateListener {

	private String naziv;
	private ArrayList<Dokument> dokumenti;
	private transient boolean promenjeno;
	private File fajl;

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public ArrayList<Dokument> getDokumenti() {
		return dokumenti;
	}

	public void setDokumenti(ArrayList<Dokument> dokumenti) {
		this.dokumenti = dokumenti;
	}

	public Projekat(String naziv) {
		this.naziv = naziv;
		dokumenti = new ArrayList<>();
		promenjeno = false;
	}

	public Projekat(Projekat p) {
		this.naziv = p.naziv;
		dokumenti = p.dokumenti;
		promenjeno = p.promenjeno;
	}

	@Override
	public void add(Object dete) {
		if (dete instanceof Dokument) {
			dokumenti.add((Dokument) dete);
		}

	}

	@Override
	public void remove(Object dete) {
		if (dete instanceof Dokument) {
			dokumenti.remove((Dokument) dete);
		}

	}

	@Override
	public Enumeration children() {
		return (Enumeration<Dokument>) dokumenti;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return dokumenti.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return dokumenti.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		return dokumenti.indexOf((Dokument) node);
	}

	@Override
	public TreeNode getParent() {
		return null;
	}

	@Override
	public boolean isLeaf() {
		return dokumenti.isEmpty();
	}

	public boolean isPromenjeno() {
		return promenjeno;
	}

	public void setPromenjeno(boolean promenjeno) {
		this.promenjeno = promenjeno;
	}

	public File getFajl() {
		return fajl;
	}

	public void setFajl(File fajl) {
		this.fajl = fajl;
	}

	@Override
	public String toString() {
		return ((promenjeno ? "* " : "") + naziv);
	}

	@Override
	public void updatePerformed(UpdateEvent e) {
		if (!promenjeno) {
			promenjeno = true;
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
		}
	}

}
