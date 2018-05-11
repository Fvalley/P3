package mutation;

import model.Chromosome;
import model.Nodo;

public class FuncionSimple extends Mutation {

	@Override
	public void execute(Chromosome chromosome, int k) {
		// TODO Auto-generated method stub
		Nodo aux = chromosome.getNode(k);
		if(!aux.esTerminal())
		{
			if(aux.esBiFuncion())
			{
				
			}
			else
			{
				
			}
		}
	}

}
