package mutation;

import model.Chromosome;
import model.Nodo;

public class Arbol extends Mutation {

	@Override
	public void execute(Chromosome chromosome, int k) {
		// TODO Auto-generated method stub
		
		Nodo aux = chromosome.getNode(k);
		Nodo aux2 = new Nodo(aux.getProfundidad(),aux.getPadre(),aux.getIndex()-1);
		chromosome.setNode(k, aux2);
	}

}
