package LocationVoiture;

public class CriterePrix implements Critere {
	
	private int prix;
	CriterePrix(int pr)
	{
		this.prix = pr;
	}
	@Override
	public boolean estSatisfaitPar(Voiture v) {
		if(v.GetPrix() < this.prix)
		{
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return "CriterePrix [prix=" + prix + "]";
	}

}
