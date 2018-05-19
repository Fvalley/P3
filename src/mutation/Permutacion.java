package mutation;

import model.Chromosome;
import model.Nodo;

public class Permutacion extends Mutation {

	@Override
	public void execute(Chromosome chromosome) {
		// TODO Auto-generated method stub
		int k = (int) Math.round(Math.random()*(chromosome.getNumNodos()-1));
		Nodo aux = chromosome.getNode(k);
		if(aux.esBiFuncion())
		{
			Nodo aux2 = aux.getHijoIzq();
			aux.setHijoIzq(aux.getHijoDer());
			aux.setHijoDer(aux2);
		}
	}

}
