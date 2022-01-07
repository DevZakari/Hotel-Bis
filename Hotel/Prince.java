package Hotel;

import java.util.*;

import java.io.*;

//we define our custom Exception :
class DataException extends Exception{
	DataException(String reason)
	{
		super(reason);
	}
}


public class Prince {
	
	// 												**  member attributes
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Chambre> les_chambres = new ArrayList<>();
	static Vector<Chambre> Les_chambres_Libres = new Vector<>();
	
/*************************************************************************************************************************************/	
	// 												** member functions
	public static Chambre SaisieChambre() throws DataException {
		
		System.out.println("Numero de la chambre : ");int numC = scan.nextInt();
		System.out.println("Categorie de la chambre : ");int categ = scan.nextInt();
		System.out.println("Prix de la chambre : ");float prix = scan.nextFloat();
		if(prix < 0)
		{
			throw new DataException("** Prix ne peut pas etre < 0 .");
		}
		System.out.println("Capacite de la chambre : ");int capac = scan.nextInt();
		if(capac < 1 || capac > 4) {
			throw new DataException("** Capacite doit etre entre [1,4] .");
		}
		return new Chambre(numC,categ,prix,capac);
	}
/*************************************************************************************************************************************/	
	public static void Afficher_Les_chambres()
	{
		if(les_chambres.isEmpty())
		{
			System.out.println("SORRY. Il n'y a pas de chambre pour le moment. ");
		}else {
			System.out.println("\t\t *-* Voilà les chambres disponibles *-* ");
			for(Chambre c: les_chambres)
			{
				System.out.println(c.toString());
			}
		}
	}
/*************************************************************************************************************************************/	
	// 										** whenever we try : saisir une chamre on doit l'ajouter sur une liste des chambre :
	public static void AjouterChambre()
	{
		try {
			 Chambre c = Prince.SaisieChambre();
			 les_chambres.add(c);
		}catch(DataException e)
		{
			System.out.println(e);
		}
		
	}
/*************************************************************************************************************************************/	
	// 										** afficher liste des chambres qui ont la categorie : X 
	public static Vector<Chambre> Vector_Chambre_avec_Categ(int categ)
	{
		Vector<Chambre> my_vec = new Vector<Chambre>();
		for(Chambre ch : les_chambres)
		{
			if(ch.getCategorie() == categ) my_vec.add(ch);
		}
		return my_vec;
	}
/*************************************************************************************************************************************/	
	// 										** Trier le tableau des chambres en ordre croissant des capacites :
	public static void  Trier_Liste_Chambres() {
		Collections.sort(les_chambres, new TrierParCapacite());
		System.out.println("\t\t ** Les chambres en ordre croissant by : Capacite . **");
		for(Chambre c : les_chambres)
		{
			System.out.println(c.toString());
		}
		
	}
/*************************************************************************************************************************************/		
	// 										** Sauvegardons d'abord les données dans un fichier.dat :
	public static void Sauvegarder_Donnee_sur_F()  {
		try {
			File f = new File("chambres.dat");
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			for(Chambre c : les_chambres)
			{
				raf.writeUTF(c.Format_Chambre());
			}
			if(!les_chambres.isEmpty()) {System.out.println("\t\t *-* Les donnees sont sauvegardees avec SUCCES *-* ");}
			raf.close();
			
		}catch(IOException e)
		{
			System.out.println(e);
		}
	}
/*************************************************************************************************************************************/		
	//										** La lecture depuis un fichier.dat :
	public static void Lecture_Donnee_depuis_F() {
		try {
			File f = new File("chambres.dat");
			RandomAccessFile raf = new RandomAccessFile(f, "r");
			long lenght_file = raf.length();
			
			if(lenght_file >0) {System.out.println("\t\t *-* Les donnees sont lues avec SUCCES  *-* ");}
			while(raf.getFilePointer() < lenght_file)
			{
				System.out.println(raf.readUTF());
			}
			raf.close();
		}catch(IOException e)
		{
			System.out.println(e);
		}
	}
/*************************************************************************************************************************************/	
	// 										** Ajouter une chambre dans un fichier.dat : 
	public static void Ajouter_Chambre_dans_F()
	{
		try {
			Chambre c = Prince.SaisieChambre();
			File f = new File("chambres.dat");
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			// se positionner dans la fin du fichier : 
			raf.seek(raf.length());
			raf.writeUTF(c.Format_Chambre());
			raf.close();
			
		}catch(IOException e) {
			System.out.println(e);
		}catch(DataException e )
		{
			System.out.println(e);
		}
	}
/*************************************************************************************************************************************/		
	//										** La suppression d'une chambre depuis un fichier.dat :
	public static void Supprimer_Chambre_depuis_F(int Num_chambre) {
		try {
			File f = new File("chambres.dat");
			RandomAccessFile raf = new RandomAccessFile(f, "r");
			// Fichier d'aide : 
			File f_temp = new File("Temp.dat");
			RandomAccessFile raf_temp = new RandomAccessFile(f_temp, "rw");
			long lenght_file = raf.length();
			while(raf.getFilePointer() < lenght_file)
			{
				String ligne_lu = raf.readUTF();
				String [] info_chambre = ligne_lu.split(",");
				if(!info_chambre[0].equals(Num_chambre+"")) {
					raf_temp.writeUTF(ligne_lu);
				}
			}
			raf.close();
			raf_temp.close();
			// and we rename the paths : 
			f.delete();
			f_temp.renameTo(f);
		}catch(IOException e)
		{
			System.out.println(e);
		}
	}
/*************************************************************************************************************************************/	
	// 											** Modification d'une chambre depuis un fichier.dat : 
	public static void Modification_Chambre_depuis_F(int Num_chambre) {
		
		try {
		
			File f = new File("chambres.dat");
			RandomAccessFile raf = new RandomAccessFile(f, "r");
			// Fichier d'aide : 
			File f_temp = new File("Temp.dat");
			RandomAccessFile raf_temp = new RandomAccessFile(f_temp, "rw");
			long lenght_file = raf.length();
			while(raf.getFilePointer() < lenght_file)
			{
				String ligne_lu = raf.readUTF();
				String [] info_chambre = ligne_lu.split(",");
				if(!info_chambre[0].equals(Num_chambre+"")) {
					raf_temp.writeUTF(ligne_lu);
				}else {
					try {
						Chambre c = Prince.SaisieChambre();
						System.out.println("Etat de la chambre : ");
						String str = scan.next();
						char car = str.charAt(0);
						c.Changer_Etat(car);
						raf_temp.writeUTF(c.Format_Chambre());
					}catch (DataException e)
					{
						System.out.println(e);
					}
					
				}
			}
			raf.close();
			raf_temp.close();
			// and we rename the paths
			f.delete();
			f_temp.renameTo(f);
		
		}catch(IOException e)
		{
			System.out.println(e);
		}
		
	}
/**
 *  ***********************************************************************************************************************************/	
	public static void Copier_Chambres_Vers_F(int categ) {
		
		try {
			
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("fichier_Sequenciel.txt"));
			Vector<Chambre> chambre_libres = Vector_Chambre_avec_Categ(categ);
				
			oos.writeObject(chambre_libres);
			oos.flush();
			oos.close();
		
		}catch(FileNotFoundException e)
		{
			System.out.println(e);
		}catch(IOException e)
		{
			System.out.println(e);
		}
		
		//if we want to read and show it in the console : 
		/*
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("fichier_Sequenciel.txt"));
		try {
			chambre_libres = (Vector<Chambre>)ois.readObject();
			for(Chambre c : chambre_libres)
			{
				syso(c);
			}
		}catch(ClassNotFoundException e) {
			System.out.println(e);
			ois.close();
		}
		*/
	}
/**

 *  ***********************************************************************************************************************************/
	public static void Sauvegarder_Les_Chambre_Libre_sur_Vecteur() {
		
		
		try {
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("fichier_Sequenciel.txt"));
			Vector<Chambre> chambre_libres = (Vector<Chambre>)ois.readObject();
			for(Chambre c : chambre_libres)
			{
				Les_chambres_Libres.add(c);
			}
			if(!Les_chambres_Libres.isEmpty())
				{System.out.println("\t\t *-* Les Chambres Libres sont sauvegardees dans le vecteur *-*");}
			ois.close();
			
			
		}catch(ClassNotFoundException e) {
			System.out.println(e);
			
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}catch (IOException e)
		{
			System.out.println(e);
		}
		
	}
	public static void Calcul_Recette_Max_Reel() {
		try {
			File f = new File("chambres.dat");
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			double reel=0, max=0;
			while(raf.getFilePointer() < raf.length())
			{
				String ligne_lu = raf.readUTF();
				String [] mes_chambres = ligne_lu.split(",");
				if(mes_chambres[4].charAt(0) == 'O')
				{
					reel+=Double.parseDouble(mes_chambres[2]);
				}
				max += Double.parseDouble(mes_chambres[2]);
			}
			
			System.out.println("La recette Maximale journaliere : " + max);
			System.out.println("La recette Reelle du jour est : " + reel);
		}catch(IOException e)
		{
			System.out.println(e);
		}
	
	}
	
}
