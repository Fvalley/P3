package selections;

import model.Population;

public abstract class Selections {
	
	private static Selections selection = null;
	
	public static void createInstance(String select) {
		switch (select) {
		case "ROULETTE":
			selection = new RuletSelection();
			break;
		case "STOCHASTIC":
			selection = new Stochastic();
			break;
		case "TOURNAMENT":
			selection = new Tourney();
			break;
		case "PROB TOURNAMENT":
			selection = new Tourney();
			break;
		case "LEFTOVERS":
			selection= new Rests();
		default:
			selection = new RuletSelection();
			break;
		}
	}
	public static Selections getInstance() {
		return Selections.selection;
	}
	public abstract Population select(Population pob, int tampob);
}
