package LocationVoiture;

import java.util.*;

public class InterCritere implements Critere {
	
	private List<Critere> mes_Criteres;
	InterCritere(){
		mes_Criteres = new ArrayList<>();
	}
	public void addCritere(Critere c)
	{
		mes_Criteres.add(c);
	}

	@Override
	public boolean estSatisfaitPar(Voiture v) {
		
		if(mes_Criteres.isEmpty())
		{
			System.out.println("Y'a pas des Criteres Passés.");
			return false;
		}
		
		for(Critere c : mes_Criteres)
		{
			if(!c.estSatisfaitPar(v)) {
				return false;
			}
		}
		
		return true;
	}

}
