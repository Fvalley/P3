package inicializacion;

import model.Chromosome;
import model.Elemento;
import model.Nodo;

public class Ramped extends Iniciacion {


	@Override
	public Chromosome[] execute(int treeLength, int pobSize) {
		// TODO Auto-generated method stub
		Chromosome[] aux = new Chromosome[pobSize];
		int tamGroup = pobSize/treeLength;
		for(int i = 0; i <= treeLength-1; i++)
		{
			for(int j = 0; j < tamGroup/2; j++)
			{
				aux[(tamGroup*i)+j] = new Chromosome(treeLength, full(treeLength-i));
			}
			for(int j = tamGroup/2; j < tamGroup;j++)
			{
				aux[(tamGroup*i)+j] = new Chromosome(treeLength, grow(treeLength-i));
			}
		}
			
		return aux;
	}

	private Nodo grow(int treeLength) {
		// TODO Auto-generated method stub
		Nodo padre = new Nodo();
		int i = 1;
		if(!padre.esTerminal()){
			if(padre.esBiFuncion()) {
				padre.anadirHijo(grow(treeLength-1, padre, i));
				i = padre.elUltimo();
			}
			padre.anadirHijo(grow(treeLength-1, padre, i));
		}
		return padre;
	}

	private Nodo grow(int length, Nodo padre, int i) {
		// TODO Auto-generated method stub
		Nodo aux = new Nodo();
		aux.setPadre(padre);
		aux.setIndice(++i);
		aux.setProfundidad(padre.getProfundidad() +1);
		if(length > 0){
			aux.setFuncion(funciones[(int) Math.round(Math.random()*6)]);
			if(!aux.esTerminal()){
				if(aux.esBiFuncion()) {
					aux.anadirHijo(grow(length-1, padre, i));
					i = aux.elUltimo();
				}
				aux.anadirHijo(grow(length-1, aux, i));
			}
		}
		else
			aux.setFuncion(Elemento.A);
		return aux;
	}

	private Nodo full(int treeLength) {
		// TODO Auto-generated method stub
		Nodo padre= new Nodo();
		do {
			padre.setFuncion(funciones[(int) Math.round(Math.random()*6)]) ;
		}while(padre.esTerminal());
		int i = 1;
		if(padre.esBiFuncion()) {
			padre.anadirHijo(full(treeLength-1, padre, i));
			i = padre.elUltimo();
		}
		padre.anadirHijo(full(treeLength-1, padre, i));
		return padre;
	}

	private Nodo full(int length, Nodo padre, int i) {
		// TODO Auto-generated method stub
		Nodo aux = new Nodo();
		aux.setPadre(padre);
		aux.setIndice(++i);
		aux.setProfundidad(padre.getProfundidad() +1);
		if(length > 0){
			do {
				aux.setFuncion(funciones[(int) Math.round(Math.random()*6)]);
			}while(aux.esTerminal());
			if(aux.esBiFuncion()) {
				aux.anadirHijo(full(length-1, padre, i));
				i = aux.elUltimo();
			}
			aux.anadirHijo(full(length-1, aux, i));
		}
		else
			aux.setFuncion(Elemento.A);
		return aux;
	}



}
