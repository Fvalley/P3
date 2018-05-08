package selections;

import model.Population;

public abstract class Selections {
	
	private static Selections selection = null;
	
	public static void createInstance(String select) {
		switch (select) {
		case "RULET":
			selection = new RuletSelection();
			break;
		case "STOCHASTIC":
			selection = new Stochastic();
			break;
		case "TOURNEY":
			selection = new Tourney();
			break;
		case "PROB TOURNEY":
			selection = new Tourney();
			break;
		case "RESTS":
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
