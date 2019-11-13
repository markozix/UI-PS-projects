package projectTree;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;

import model.Container;
import model.Dokument;

public class PomocniProjekat implements Container, TreeNode {

	private ArrayList<Dokument> dokumenti = new ArrayList<>();
	
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
		return dokumenti.indexOf((Dokument)node);
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

}
