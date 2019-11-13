package modeli;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;
import modeli.InformacioniResurs;

public class Workspace implements TreeNode, Container {
	private String naziv;
	private ArrayList<InformacioniResurs> informacioniResursi = new ArrayList<>();
	
	@Override
	public Enumeration children() {
		return (Enumeration<InformacioniResurs>) informacioniResursi;
	}
	@Override
	public boolean getAllowsChildren() {
		return true;
	}
	@Override
	public TreeNode getChildAt(int childIndex) {
		return informacioniResursi.get(childIndex);
	}
	@Override
	public int getChildCount() {
		return informacioniResursi.size();
	}
	@Override
	public int getIndex(TreeNode node) {
		return informacioniResursi.indexOf((InformacioniResurs)node);
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
		if(dete instanceof InformacioniResurs) {
			informacioniResursi.add((InformacioniResurs)dete);
		}
	}
	@Override
	public void remove(Object dete) {
		if(dete instanceof InformacioniResurs) {
			informacioniResursi.remove((InformacioniResurs)dete);
		}
	}
	
}
