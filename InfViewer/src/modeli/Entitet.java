package modeli;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;

import javax.swing.tree.TreeNode;

import model.tree.Tree;
import state.StateManager;

public class Entitet extends InformacioniResurs {
	// private InformacioniResurs parent;
	private String name;
	private ArrayList<Atribut> atributi = new ArrayList<>();
	private ArrayList<Relacija> relacije = new ArrayList<>();
	private String path;
	private StateManager stateManager;
	private long seek;
	private int opened = 0;
	private int blockSize = 20;
	private Paket entPaket;
	private long lastSearch = 0;
	private Tree tree;

	public void openTree(String path){
		ObjectInputStream os=null;
		try {
			os = new ObjectInputStream(new FileInputStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			tree = (Tree) os.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Enumeration children() {
		return (Enumeration<Atribut>) atributi;
	}

	public Tree getTree() {
		return tree;
	}

	public void setTree(Tree tree) {
		this.tree = tree;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}

	public Paket getEntPaket() {
		return entPaket;
	}

	public void setEntPaket(Paket entPaket) {
		this.entPaket = entPaket;
	}

	public int getOpened() {
		return opened;
	}

	public void setOpened(int opened) {
		this.opened = opened;
	}

	public long getSeek() {
		return seek;
	}

	public void setSeek(long seek) {
		this.seek = seek;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return atributi.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return atributi.size();
	}

	@Override
	public int getIndex(TreeNode node) {
		return atributi.indexOf((Atribut) node);
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
		if (dete instanceof Atribut) {
			atributi.add((Atribut) dete);
		}
	}

	@Override
	public void remove(Object dete) {
		if (dete instanceof Atribut) {
			atributi.remove((Atribut) dete);
		}
	}

	public ArrayList<Relacija> getRelacije() {
		return relacije;
	}

	public void setRelacije(ArrayList<Relacija> relacije) {
		this.relacije = relacije;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return name;
	}

	public StateManager getStateManager() {
		return stateManager;
	}

	public void setStateManager(StateManager stateManager) {
		this.stateManager = stateManager;
	}

	public ArrayList<Atribut> getAtributi() {
		return atributi;
	}

	public void setAtributi(ArrayList<Atribut> atributi) {
		this.atributi = atributi;
	}

	public long getLastSearch() {
		return lastSearch;
	}

	public void setLastSearch(long lastSearch) {
		this.lastSearch = lastSearch;
	}

	// public void addAtribut(Atribut newAtribut) {
	// if (newAtribut == null)
	// return;
	// if (this.atribut == null)
	// this.atribut = new java.util.ArrayList<Atribut>();
	// if (!this.atribut.contains(newAtribut))
	// this.atribut.add(newAtribut);
	// }
	//
	// public void removeAtribut(Atribut oldAtribut) {
	// if (oldAtribut == null)
	// return;
	// if (this.atribut != null)
	// if (this.atribut.contains(oldAtribut))
	// this.atribut.remove(oldAtribut);
	// }
	//
	// public void addTabela(Tabela newTabela) {
	// if (newTabela == null)
	// return;
	// if (this.tabela == null)
	// this.tabela = new java.util.HashSet<Tabela>();
	// if (!this.tabela.contains(newTabela))
	// this.tabela.add(newTabela);
	// }
	//
	// public void removeTabela(Tabela oldTabela) {
	// if (oldTabela == null)
	// return;
	// if (this.tabela != null)
	// if (this.tabela.contains(oldTabela))
	// this.tabela.remove(oldTabela);
	// }

}
