package mutation;

import model.Chromosome;

public abstract class Mutation {
	private static Mutation muta = null;
	public abstract void execute(Chromosome chromosome);
	public static void createInstance(String mutate) {
		switch (mutate) {
		case "FUNCION SIMPLE":
			muta= new FuncionSimple();
			break;
		case "ARBOL":
			muta = new Arbol();
			break;
		case "PERMUTACION":
			muta = new Permutacion();
			break;
		default:
			break;
		}
	}
	public static Mutation getInstance() {
		return Mutation.muta;
	}
}
