package inicializacion;

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
				if(aux.esBiFuncion())
					aux.añadirHijo(crear(length-1, aux, i));
				aux.añadirHijo(crear(length-1, aux, i));
			}
		}
		else
			aux.setFuncion(Elemento.A);
		return aux;
	}

	@Override
	public Nodo execute(int treeLength) {
		// TODO Auto-generated method stub
		Nodo padre = new Nodo();
		int i = 1;
		if(!padre.esTerminal()){
			if(padre.esBiFuncion())
				padre.añadirHijo(crear(treeLength-1, padre, i));
			padre.añadirHijo(crear(treeLength-1, padre, i));
		}
		return padre;
	}

}
