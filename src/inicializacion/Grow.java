package inicializacion;

import model.Chromosome;
import model.Elemento;
import model.Nodo;

public class Grow extends Iniciacion {

	public Nodo crear(int length, Nodo padre, int i){
		Nodo aux = new Nodo();
		aux.setPadre(padre);
		aux.setIndice(++i);
		aux.setProfundidad(padre.getProfundidad() +1);
		if(length > 0){
			aux.setFuncion(funciones[(int) Math.round(Math.random()*6)]);
			if(!aux.esTerminal()){
				if(aux.esBiFuncion()) {
					aux.anadirHijo(crear(length-1, padre, i));
					i = aux.elUltimo();
				}
				aux.anadirHijo(crear(length-1, aux, i));
			}
		}
		else
			aux.setFuncion(Elemento.A);
		return aux;
	}

	public Nodo execut(int treeLength) {
		// TODO Auto-generated method stub
		Nodo padre = new Nodo();
		int i = 1;
		if(!padre.esTerminal()){
			if(padre.esBiFuncion()) {
				padre.anadirHijo(crear(treeLength-1, padre, i));
				i = padre.elUltimo();
			}
			padre.anadirHijo(crear(treeLength-1, padre, i));
		}
		return padre;
	}
	@Override
	public Chromosome[] execute(int treeLength, int pobSize) {
		// TODO Auto-generated method stub
		Chromosome[] aux = new Chromosome[pobSize];
		for(int i = 0; i < pobSize; i++)
			aux[i] = new Chromosome(treeLength, execut(treeLength));
		return aux;
	}

}
