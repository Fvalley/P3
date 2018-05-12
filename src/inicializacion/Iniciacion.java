package inicializacion;

import model.Chromosome;
import model.Elemento;


public abstract class Iniciacion {
	protected static Elemento[] funciones = Elemento.values();
	private static Iniciacion inic = null;
	public abstract Chromosome[] execute(int treeLength, int pobSize);
	public static void createInstance(String ini) {
		switch (ini) {
		case "FULL":
			inic= new Full();
			break;
		case "GROW":
			inic = new Grow();
			break;
		case "RAMPED":
			inic = new Ramped();
			break;
		
		default:
			break;
		}
	}
	public static Iniciacion getInstance() {
		return Iniciacion.inic;
	}
}
