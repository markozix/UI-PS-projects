package modeli;

import java.util.HashSet;

public class Relacija extends InformacioniResurs {
	private String atribut1;
	private String atribut2;
	private String entitet;
	
	public String getAtribut1() {
		return atribut1;
	}
	public void setAtribut1(String atribut1) {
		this.atribut1 = atribut1;
	}
	public String getAtribut2() {
		return atribut2;
	}
	public void setAtribut2(String atribut2) {
		this.atribut2 = atribut2;
	}
	public String getEntitet() {
		return entitet;
	}
	public void setEntitet(String entitet) {
		this.entitet = entitet;
	}
	
	@Override
	public String toString() {
		return "Related to " + entitet;
	}

/* javlja neke greske..
	public void addAtribut(Atribut newAtribut) {
	      if (newAtribut == null)
	         return;
	      if (this.atribut1 == null)
	         this.atribut1 = new java.util.HashSet<Atribut>();
	      if (!this.atribut1.contains(newAtribut))
	         this.atribut1.add(newAtribut);
	   }
	
	public void removeAtribut(Atribut oldAtribut) {
	      if (oldAtribut == null)
	         return;
	      if (this.atribut != null)
	         if (this.atribut.contains(oldAtribut))
	            this.atribut.remove(oldAtribut);
	   }
	   */
	
//	public void removeAllAtribut() {
//	      if (atribut1 != null)
//	         atribut1.clear();
//	   }
}
