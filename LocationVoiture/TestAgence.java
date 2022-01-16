package LocationVoiture;

public class TestAgence {
	
	public static void main(String [] args) throws VoitureAlreadyRented,VoitureNotFound
	{
		Critere c = new CriterePrix(500);
		Critere c_m = new CritereMarque("DZICKO");
		Voiture v1 = new Voiture("VOLVO","volvo b122",2020,500);
		Voiture v2 = new Voiture("CLIO","Clio 4 forfait",2009,50);
		Voiture v3 = new Voiture("JEEP","4*4 JEEP-BOSS",2020,500);
		Voiture v4 = new Voiture("Renault","Renault B22",2009,90);
		
		Agence agence = new Agence();
		agence.addVoiture(v4);
		agence.addVoiture(v3);
		agence.addVoiture(v2);
		agence.addVoiture(v1);
		
		agence.AfficheSelection(c);
		agence.AfficheSelection(c_m);
		
		// affichage de toutes les voitures dont le prix Loc < 100 :
		agence.Afficher_Voiture_prix_bas();
		
		// Tester InterCritere : 
		System.out.println("** InterCritere **");
		Critere c_p = new CriterePrix(100);
		Critere c_m1 = new CritereMarque("Renault");
		InterCritere i_c = new InterCritere();
		i_c.addCritere(c_p);
		i_c.addCritere(c_m1);
	    agence.AfficheSelection(i_c);
	    
	    // TEST : 
	    Client cli1 = new Client("Machtor","Zakaria","T33333","M.");
	    Client cli2 = new Client("Ahrass","Mohammed","T33333","M.");
	    agence.loueVoiture(cli1, v4);
	    agence.loueVoiture(cli2, v3);
	    //agence.loueVoiture(cli2, v4);
	    System.out.println(" ** Les locations de l'agence ** ");
	    agence.AfficherLocations();
	    
	    
	    /*
	     * Q10)
	     *   --> 2 : le problème c'est que la COLLECTION TreeMap need an implementation of Method CompareTo or a Comparator ; Client doit etre Comparable;
	     * */
	    
		
	}

}
