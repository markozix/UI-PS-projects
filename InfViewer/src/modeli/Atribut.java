package modeli;

import java.util.Enumeration;

import javax.swing.tree.TreeNode;

public class Atribut extends InformacioniResurs {
	private String name;
	private boolean isKey;
	private int duzina;
	private String type;
	private boolean required;

	@Override
	public Enumeration children() {
		return null;
	}
	
	@Override
	public boolean getAllowsChildren() {
		return false;
	}
	
	@Override
	public TreeNode getChildAt(int childIndex) {
		return null;
	}
	
	@Override
	public int getChildCount() {
		return 0;
	}
	
	@Override
	public int getIndex(TreeNode node) {
		return 0;
	}
	
	@Override
	public TreeNode getParent() {
		return null;
	}
	
	@Override
	public boolean isLeaf() {
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isKey() {
		return isKey;
	}

	public void setKey(boolean isKey) {
		this.isKey = isKey;
	}

	public int getDuzina() {
		return duzina;
	}

	public void setDuzina(int duzina) {
		this.duzina = duzina;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
