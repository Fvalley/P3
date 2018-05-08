package practice3;

import crosses.Crosses;
import model.EvAlgorithm;
import mutation.Mutation;
import selections.Selections;
import view.Grafics;

public class Controller {

	public void execute(String population, String generations, String percentagecross, String percentagemuta, boolean elitsm,
			String percentageelit, String cross, String selection, String mutation,String num, String text) {
		// TODO Auto-generated method stub
		if(text.length() !=0)
		{
			int tampob = Integer.parseInt(population);
			int generaciones = Integer.parseInt(generations);
			double porccruce = Double.parseDouble(percentagecross)/100;
			double porcmuta =Double.parseDouble(percentagemuta)/100;
			double porcelit = Double.parseDouble(percentageelit)/100;
			int inser = Integer.parseInt(num);
			Selections.createInstance(selection);
			Crosses.createInstance(cross);
			Mutation.createInstance(mutation);
			EvAlgorithm algorithm = new EvAlgorithm(tampob, generaciones, porccruce, porcmuta, elitsm, porcelit, inser, text);
			algorithm.start();
		}
		else {
			Grafics.usage();
		}
	}

}
