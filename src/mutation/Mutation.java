package mutation;

import model.Chromosome;

public abstract class Mutation {
	private static Mutation muta = null;
	public abstract void execute(Chromosome chromosome, int k);
	public static void createInstance(String mutate) {
		switch (mutate) {
		case "EXCHANGE":
			muta= new Exchange();
			break;
		case "INSERTION":
			muta = new Insertion();
			break;
		case "INVERSION":
			muta = new Inversion();
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
