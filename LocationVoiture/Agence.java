package LocationVoiture;

import java.util.*;


class VoitureNotFound extends Exception {
	
	public VoitureNotFound(String reason)
	{
		super(reason);
	}
}
class VoitureAlreadyRented extends Exception {
	public VoitureAlreadyRented(String reason)
	{
		super(reason);
	}
}

class ClientAlreadyInLocation extends Exception {
	public ClientAlreadyInLocation(String reason) {
		super(reason);
	}
}

public class Agence {
	
	private List<Voiture> mes_voitures;
	//private HashMap<Client,Voiture> Locations;
	private TreeMap<Client,Voiture> Locations;
	
	
	/*********************************************************************************************************/
	Agence(){
		mes_voitures = new ArrayList<Voiture>();
		Locations = new TreeMap<>();
	}
	/*********************************************************************************************************/
	public void addVoiture(Voiture v) {
		mes_voitures.add(v);
	}
	/*********************************************************************************************************/
	public Iterator Selectionne(Critere c)
	{
		List<Voiture> v_satisfaits = new ArrayList<Voiture>();
		Iterator it = mes_voitures.iterator();
		Voiture v_temp;
		
		while(it.hasNext())
		{
			v_temp = (Voiture) it.next();
			if(c.estSatisfaitPar(v_temp))
			{
				v_satisfaits.add(v_temp);
			}
		}
		return v_satisfaits.iterator();
		
	}
	/*********************************************************************************************************/
	public void AfficheSelection(Critere c) {
		
		Iterator it = Selectionne(c);
		if(!it.hasNext())
		{
			System.out.println("Aucune Voiture satisfait le critere : " + c.toString());
		}
		else {
			while(it.hasNext())
			{
				System.out.println(it.next().toString());
			}
		}
	}
	/*********************************************************************************************************/
	public void Afficher_Voiture_prix_bas() {
		Iterator it = mes_voitures.iterator();
		if(mes_voitures.isEmpty())
		{
			System.out.println("Y'a aucune voiture dance cette AGENCE.");
		}
		else {
			while(it.hasNext()) {
				Voiture v_temp = (Voiture)it.next();
				if(v_temp.GetPrix() < 100) {
					System.out.println(v_temp);
				}
			}
		}
	}
	
	/*********************************************************************************************************/
	public void loueVoiture(Client cli,Voiture v) throws VoitureNotFound,VoitureAlreadyRented
	{
		if(!this.mes_voitures.contains(v))
		{
			throw new VoitureNotFound("** Y'a pas cette voiture dans notre agence.");
		}else if(this.Locations.containsValue(v))
		{
			throw new VoitureAlreadyRented("** Voiture déjà louée.");
		}		
		this.Locations.put(cli, v);
	}
	/*********************************************************************************************************/
	public boolean estLoueur(Client cli)
	{
		if(this.Locations.containsKey(cli))
		{
			return true;
		}
		return false;
	}
	/*********************************************************************************************************/
	public boolean estLoue(Voiture v)
	{
		if(this.Locations.containsValue(v))
		{
			return true;
		}
		return false;
	}
	/*********************************************************************************************************/
	public void rendVoiture(Client cli)
	{
		if(this.estLoueur(cli))
		{
			this.Locations.remove(cli);
		}
	}
	/*********************************************************************************************************/
	public Iterator<Map.Entry<Client, Voiture>> lesVoituresLouees()
	{
		return this.Locations.entrySet().iterator();
	}
	/*********************************************************************************************************/
	public void AfficherLocations()
	{
		this.Locations.keySet().forEach(k -> System.out.println((k + " : " + this.Locations.get(k))));
	}
	
}
