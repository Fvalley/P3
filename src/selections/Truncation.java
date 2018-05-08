package selections;

import model.Chromosome;
import model.Population;

public class Truncation extends Selections {

	@Override
	public Population select(Population pob, int tampob) {
		// TODO Auto-generated method stub
		Population aux = new Population();
		Population copia = new Population(pob);
		
		for (int j = 0; j < 10; j++) {
			Chromosome max = copia.getChromosome(0);
			int index = 0;
				for (int k = 1; k < pob.getTam(); k++) {
					if (max.getFitness() < copia.getChromosome(k).getFitness()) {
						max = new Chromosome(copia.getChromosome(k));
						index = k;
					}
				}
			aux.add(max);
			copia.getChromosome(index).setFitness(Integer.MIN_VALUE);
		}
		for(int i = 0; i< tampob;i++){
			aux.add(aux.getChromosome(i));
		}
		return aux;
	}

}
