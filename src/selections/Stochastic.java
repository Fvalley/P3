package selections;

import model.Population;

public class Stochastic extends Selections {

	@Override
	public Population select(Population pob, int tampob) {
		// TODO Auto-generated method stub
		Population aux = new Population();
		float a;
		int j = 0;
		boolean found = false;
		for(int i = 0; i < tampob; i++){
			a = ((1/tampob) + i) / tampob;
			j= 0;
			while (!found && j < pob.getTam())
			if(j == 0 && a <= pob.getChromosome(j).getPuntAcum()){
				aux.add(pob.getChromosome(j));
				found =true;
			}
			else if(a <= pob.getChromosome(i).getPuntAcum() && a > pob.getChromosome(i-1).getPuntAcum()){
				aux.add(pob.getChromosome(i));
				found = true;
			}
			found = false;
		}
		return aux;
	}

}
