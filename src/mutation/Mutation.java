package mutation;

import model.Chromosome;

public abstract class Mutation {
	private static Mutation muta = null;
	public abstract void execute(Chromosome chromosome, int k);
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
		case "HEURISTIC":
			muta = new Heuristic();
			break;
		case "OUR METHOD":
			muta = new MethodMutate();
			break;
		case "INDEX":
			muta = new IndexMutation();
		default:
			break;
		}
	}
	public static Mutation getInstance() {
		return Mutation.muta;
	}
}
