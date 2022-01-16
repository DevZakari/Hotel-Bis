package LocationVoiture;

public class Client implements Comparable<Client> {
	
	private String nom;
	private String prenom;
	private String CIN;
	private String civilite;
	
	Client(String n,String p,String cin,String civ)
	{
		this.CIN = cin;
		this.civilite= civ;
		this.nom=n;
		this.prenom = p;
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", CIN=" + CIN + ", civilite=" + civilite + "]";
	}

	@Override
	public int compareTo(Client o) {
		return this.nom.compareToIgnoreCase(o.nom);
	}
	
	
}
