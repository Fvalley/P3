package selections;

import model.Population;

public class Rests extends Selections {

	@Override
	public Population select(Population pob, int tampob) {
		// TODO Auto-generated method stub
		int k = pob.getTam();
		Population aux = new Population();
		
		for(int i = 0; i < pob.getTam(); i++) {
			int j = 0;
			while( aux.getTam() < tampob && j < k*pob.getChromosome(i).getPuntuation()) {
				aux.add(pob.getChromosome(i));
				j++;
			}
		}
		while(aux.getTam() < tampob)
		{
			double aux2 = Math.random();
			int j = 0;
			boolean found = false;
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
