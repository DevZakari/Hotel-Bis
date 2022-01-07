package Hotel;

import java.util.*;
import java.io.*;

public class TestHotel {

	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
	int choix;
	
	do {
		cls();
		choix = showMenu();
		switch(choix)
		{
			case 1 : cls();Prince.Afficher_Les_chambres(); break;
			case 2 : cls();Prince.AjouterChambre(); break; 
			case 3 : cls();Prince.Trier_Liste_Chambres(); break;
			case 4 : 
					 cls();
					 System.out.println("Donnez Categorie : ");
					 int categ = scan.nextInt();
					 if(Prince.Vector_Chambre_avec_Categ(categ).isEmpty())
					 {
						 cls();System.out.println("** Aucune chambre avec la categorie : " + categ);
					 }else {
						 cls();System.out.println(Prince.Vector_Chambre_avec_Categ(categ));
					 }
					 break;
					 
			case 5 : cls();Prince.Lecture_Donnee_depuis_F();break;		 
			case 6 : cls();Prince.Sauvegarder_Donnee_sur_F(); break;
			case 7 : cls();Prince.Ajouter_Chambre_dans_F();break;
			case 8 : 
					 cls();
					 System.out.println("Donnez Numero de la chambre : ");
					 int num = scan.nextInt();
					 Prince.Supprimer_Chambre_depuis_F(num);
					 break;
			case 9 : 
					 cls();
					 System.out.println("Donnez Numero de la chambre : ");
					 int numC = scan.nextInt();
					 Prince.Modification_Chambre_depuis_F(numC);
					 break;
					 
			case 10 : cls();Prince.Calcul_Recette_Max_Reel();break;
			case 11 : 
					  cls();
					  System.out.println("Donnez La categorie : ");
					  int cateG = scan.nextInt();
					  Prince.Copier_Chambres_Vers_F(cateG);
					  break;
					  
			case 12 : cls();Prince.Sauvegarder_Les_Chambre_Libre_sur_Vecteur();break; 		 
			case 0  : cls();System.out.println("AuRevoir. ");break;
			default : System.out.println("CHOIX INVALIDE !");break;
		}
		try {
			char ch = (char) System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}while(choix !=0);
		
	}
	
	private static int  showMenu()
	{
		System.out.println("------------ Conernat La liste Des Chambres -------------------");
		System.out.println("01 : Afficher les chambres(arraylist)");
		System.out.println("02 : Ajouter une chambre");
		System.out.println("03 : Trier les chambres");
		System.out.println("04 : Recuperer les chambres par categorie");
		System.out.println("------------ Concernant Les fichiers -------------------");
		System.out.println("05 : Afficher les chambres");
		System.out.println("06 : Sauvgrader les chambres vers le fichier. ");
		System.out.println("07 : Ajouter une chambre. ");
		System.out.println("08 : Supprimer une chambre by Num. ");
		System.out.println("09 : Modifier une chambre by Num. ");
		System.out.println("10 : Calculer la recette Maximale et Reelle. ");
		System.out.println("11 : Copier les chambres by categorie dans un autre fichier. ");
		System.out.println("12 : Remplir un vecteur avec toutes les chambres libres. ");
		System.out.println("0  : Quitter");
		System.out.print("Tapez votre choix : ");
		int choix = scan.nextInt();
		scan.nextLine();
		return choix;
	}
	public static void cls(){
		for (int i = 0; i < 50; ++i) System.out.println();
	}

}
