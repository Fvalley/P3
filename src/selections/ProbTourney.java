package selections;

import model.Population;

public class ProbTourney extends Selections {

	@Override
	public Population select(Population pob, int tampob) {
		// TODO Auto-generated method stub
		int k = 3;
		double a;
		boolean found = false, prob;
		int o = 0;
		double p=0.7;
		Population aux = new Population(), aux2 = new  Population();
		for(int i = 0; i < tampob; i++){
			a = Math.random();
			for(int j = 0; j < k; j++){			
				a = Math.random();
				o = 0;
				while(!found && o < pob.getTam()) {
					if(o == 0 && a <= pob.getChromosome(o).getPuntAcum()){
						aux.add(pob.getChromosome(o));
						found = true;
					}
					else if(a <= pob.getChromosome(o).getPuntAcum() && a > pob.getChromosome(o-1).getPuntAcum()){
						aux.add(pob.getChromosome(o));
						found = true;
					}
					o++;
				}
				found = false;
			}
			double[] copia = new double[aux.getTam()];
			for(int k1= 0; k1 <aux.getTam();k1++) {
				copia[k1] = aux.getChromosome(k1).getFitness();
			}
			
			if(Math.random() > p) {
				prob =true;
			}
			else
			{
				prob = false;
			}
			aux.elMejor(copia);
			if(prob) {
				double max = aux.getTheBest() *1.05;
				for(int k1= 0; k1 <aux.getTam();k1++) {
					copia[k1] = max-aux.getChromosome(k1).getFitness();
				}
				aux.elMejor(copia);
			}
			aux2.add(aux.getChromosome(aux.getPosBest()));
			aux.clear();

		}
		return aux2;
	}

}
