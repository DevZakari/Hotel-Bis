package Hotel;

import java.util.*;



import java.lang.*;
import java.io.*;

public class Chambre implements Serializable {
	
	private int NumChambre;
	private int Categorie;
	private float Prix;
	private int Capacite;
	private char Etat;
	
	// dans le cas ou l'etat de la chambre doit etre initialisée : 
	Chambre(int numC,int categ,float prix,int capac)
	{
		this.NumChambre =numC;
		this.Categorie = categ;
		this.Prix = prix;
		this.Capacite =capac;
		this.Etat = 'L';
	}
   // le cas normal : 
	Chambre(int numC,int categ,float prix,int capac,char etat)
	{
		// utilisons le constructeur qui est déja définie :
		this(numC,categ,prix,capac);
		this.Etat = etat;
	}
	
	
	@Override
	public String toString() {
		return "Chambre [NumChambre=" + NumChambre + ", Categorie=" + Categorie + ", Prix=" + Prix + ", Capacite="
				+ Capacite + ", Etat=" + Etat + "]";
	}
	public String Format_Chambre()
	{
		return NumChambre+","+Categorie+","+Prix+","+Capacite+","+Etat+"\n";
	}
	
	public void Changer_Etat(char E)
	{
		this.Etat = E;
	}
	
	// getters : 
	public int getCategorie() {
		return Categorie;
	}
	
	public int getNumChambre() {
		return NumChambre;
	}
	public float getPrix() {
		return Prix;
	}
	public int getCapacite() {
		return Capacite;
	}
	public char getEtat() {
		return Etat;
	}
	
		
}

class TrierParCapacite implements Comparator<Chambre>
{
	public int compare(Chambre a,Chambre b)
	{
		return a.getCapacite() - b.getCapacite();
	}
}
