package LocationVoiture;

public class CritereMarque implements Critere {
	
	private String marque;

	public CritereMarque(String marque) {
		this.marque = marque;
	}

	@Override
	public boolean estSatisfaitPar(Voiture v) {
		if(this.marque.equalsIgnoreCase(v.GetMarque()))
		{
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "CritereMarque [marque=" + marque + "]";
	}
	
}
