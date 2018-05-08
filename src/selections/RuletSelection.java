package selections;

import model.Population;

public class RuletSelection extends Selections {

	@Override
	public Population select(Population pob, int tampob) {
		// TODO Auto-generated method stub
		Population aux= new Population();
		double aux2;
		int j;
		boolean found = false;
		for(int i=0; i < tampob;i++)
		{
			aux2 = Math.random();
			j = 0;
			while(!found && j < pob.getTam()){
				if(j == 0 && aux2 <= pob.getChromosome(j).getPuntAcum()){
					aux.add(pob.getChromosome(j));
					found = true;
				}
				else if(aux2 <= pob.getChromosome(j).getPuntAcum() && aux2 > pob.getChromosome(j-1).getPuntAcum()){
					aux.add(pob.getChromosome(j));
					found = true;
				}
				j++;
			}
			found = false;
		}
		
		return aux;
		
	}

	
}
