package crosses;

import model.Chromosome;
import model.Population;

public abstract class Crosses {
	
	private static Crosses cross = null;
	public abstract void execute(Chromosome chrom1, Chromosome chrom2);
	public int cross(Population pob, double porccruce) {
		// TODO Auto-generated method stub
		double j;
		int k=0;
		for(int i =0; i < pob.getTam()-1;i=i+2) {
			j=Math.random();
			if(j < porccruce) {
				this.execute(pob.getChromosome(i), pob.getChromosome(i+1));
				k++;
			}
		}
		return k;
	}
	public static void createInstance(String cruces) {
		switch (cruces) {
		case "PMX":
			cross= new PartialMatchingX();
			break;
		case "OX":
			cross = new OrdinalX();
			break;
		case "OUR METHOD":
			cross = new MethodCross();
			break;
		case "INDEX":
			cross = new IndexCross();
		default:
			break;
		}
	}
	public static Crosses getInstance() {
		return Crosses.cross;
	}
}
