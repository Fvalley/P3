package practice3;

import inicializacion.Iniciacion;
import model.EvAlgorithm;
import mutation.Mutation;
import selections.Selections;

public class Controller {

	public void execute(String population, String generations, String percentagecross, String percentagemuta, boolean elitsm,
			String percentageelit, String inic, String selection, String mutation,String num) {
		// TODO Auto-generated method stub
		int tampob = Integer.parseInt(population);
		int generaciones = Integer.parseInt(generations);
		double porccruce = Double.parseDouble(percentagecross)/100;
		double porcmuta =Double.parseDouble(percentagemuta)/100;
		double porcelit = Double.parseDouble(percentageelit)/100;
		int length = Integer.parseInt(num);
		Selections.createInstance(selection);
		Iniciacion.createInstance(inic);
		Crosses.createInstance();
		Mutation.createInstance(mutation);
		EvAlgorithm algorithm = new EvAlgorithm(tampob, generaciones, porccruce, porcmuta, elitsm, porcelit, length);
		algorithm.start();

	}

}
