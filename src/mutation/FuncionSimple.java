package mutation;

import model.Chromosome;
import model.Elemento;
import model.Nodo;

public class FuncionSimple extends Mutation {

	@Override
	public void execute(Chromosome chromosome) {
		// TODO Auto-generated method stub
		int k = (int) Math.round(Math.random()*chromosome.getNumNodos());
		Nodo aux = chromosome.getNode(k);
		if(!aux.esTerminal())
		{
			if(aux.esBiFuncion())
			{
				do {
					aux.setFuncion(Elemento.values()[(int) Math.round(Math.random()*6)]);
				}while(!aux.esBiFuncion());
			}
			else
			{
				do {
					aux.setFuncion(Elemento.values()[(int) Math.round(Math.random()*6)]);
				}while(aux.esBiFuncion());
			}
		}
	}

}
