package LocationVoiture;

import java.util.*;

public class Voiture {
	
	private String marque;
	private String nomModele;
	private int anneeProd;
	private int prixLocJour;
	
	// constructor : 
	Voiture(String m,String nm,int anneP,int prixL) {
		this.marque = m;
		this.nomModele = nm;
		this.anneeProd = anneP;
		this.prixLocJour = prixL;
	}
	
	// methods :
	boolean EqualeTo(Voiture v) {
		if(this.marque == v.marque &&
		   this.nomModele == v.nomModele && 
		   this.anneeProd == v.anneeProd &&
		   this.prixLocJour == v.prixLocJour) {
		   return true;
		}
		return false;
	}

	public String toString() {
		return "Voiture [marque=" + marque + ", nomModele=" + nomModele + ", anneeProd=" + anneeProd + ", prixLocJour="
				+ prixLocJour + "]";
	}
	public String GetMarque() {
		return this.marque;
	}
	public int GetPrix() {
		return this.prixLocJour;
	}
	

}
