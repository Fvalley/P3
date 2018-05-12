package crosses;

import model.Chromosome;
import model.Nodo;
import model.Population;

public class Crosses {
	
	private static Crosses cross = null;
	public void execute(Chromosome chrom1, Chromosome chrom2, double porcfuncion) {
		boolean found1 = false, found2 = false;
		int index1 =0, index2=0;
		double porc1, porc2;
		while(!found1)
		{
			index1 = (int) Math.round(Math.random()*chrom1.getNumNodos());
			porc1 = Math.random();
			if(chrom1.getNode(index1).esTerminal()){
				if(porc1 < 1-porcfuncion)
					found1=true;
			}
			else{
				if(porc1 < porcfuncion)
					found1=true;
			}
		}
		while(!found2)
		{
			index2 = (int) Math.round(Math.random()*chrom2.getNumNodos());
			porc2 = Math.random();
			if(chrom2.getNode(index2).esTerminal()){
				if(porc2 < 1-porcfuncion)
					found2=true;
			}
			else{
				if(porc2 < porcfuncion)
					found2=true;
			}
		}
		Nodo aux = chrom1.getNode(index1);
		chrom1.setNode(index1, chrom2.getNode(index2));
		chrom2.setNode(index2, aux);
		
	}
	public int cross(Population pob, double porccruce, double porcfuncion) {
		// TODO Auto-generated method stub
		double j;
		int k=0;
		for(int i =0; i < pob.getTam()-1;i=i+2) {
			j=Math.random();
			if(j < porccruce) {
				this.execute(pob.getChromosome(i), pob.getChromosome(i+1),porcfuncion);
				k++;
			}
		}
		return k;
	}
	public static void createInstance(String cruces) {
			if(cross== null)
				cross = new Crosses();
		}
	public static Crosses getInstance() {
		return Crosses.cross;
	}
}
