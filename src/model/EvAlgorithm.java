package model;

import crosses.Crosses;
import selections.Selections;
import view.Grafics;

public class EvAlgorithm {
	private double[] losMejores;
	private double[] elMejorDeTodos;
	private double[] media;
	private Population pob;
	private int tampob;
	private int generaciones;
	private double porccruce;
	private double porcmuta;
	private boolean elit;
	private double porcelit;
	private int inser;
	private Chromosome solution;
	private String text;
	private String cleantext="";//Text without punctuations and spaces
	private int numbcross=0;
	private int numbmuta=0;
	private int length;
	private static String punctuations= ".,;:?!-_/'";

	public EvAlgorithm(int tampob2, int generaciones2, double porccruce2, double porcmuta2, boolean elitsm, double porcelit2, int inser2, String text) {
		// TODO Auto-generated method stub
		this.tampob = tampob2;
		this.generaciones = generaciones2;
		this.porccruce = porccruce2;
		this.porcmuta =porcmuta2;
		this.elit = elitsm;
		this.porcelit = porcelit2;
		this.pob = new Population(this.tampob, this.length);

		this.inser = inser2;
		this.text = text.toUpperCase();
		String[] words= text.split(" ");
		String[] letters;
		for(String word:words) {
			letters=word.split("");
			for(String letter:letters) {
				if(!punctuations.contains(letter) && !letter.equals(Character.toString((char) 34))) {
					this.cleantext+=letter;
				}
			}
		}
		Population.setText(this.cleantext);
	}
	public void start(){
		this.pob.evaluar(this.cleantext);
		this.elMejorDeTodos = new double[this.generaciones];
		this.losMejores = new double[this.generaciones];
		this.media = new double[this.generaciones];
		Chromosome auxc = pob.getChromosome(pob.getPosBest());
		this.elMejorDeTodos[0] = this.pob.getTheBest();
		this.losMejores[0] = this.pob.getTheBest();
		this.solution=auxc;
		int tamelit = (int) (this.tampob*this.porcelit);
		this.media[0] = media(this.pob);
		int index = 0;

		for(int i = 1; i < generaciones; i++){
			//Seleccion, cruce y mutacion

			Population aux = new Population();
			int k = 0;
			if(!this.elit) {
				tamelit=0;
				this.pob = Selections.getInstance().select(this.pob, this.tampob);
			}
			else
			{

				Population copia = new Population(this.pob);

				for (int j = 0; j < tamelit; j++) {
					Chromosome max = new Chromosome(copia.getChromosome(0));
					index =0;
					for (int k1 = 1; k1 < this.tampob; k1++) {
						if (max.getFitness() < copia.getChromosome(k1).getFitness()) {
							max = new Chromosome(copia.getChromosome(k1));
							index = k1;
						}
					}
					aux.add(max);
					copia.getChromosome(index).setFitness(Integer.MIN_VALUE);
				}
				this.pob = Selections.getInstance().select(this.pob,this.tampob-(tamelit*2));
			}


			while(k < tamelit) {
				this.pob.add(aux.getChromosome(k));
				k++;
			}

			numbcross+= Crosses.getInstance().cross(this.pob, this.porccruce);
			numbmuta += this.pob.mutate(this.porcmuta, this.inser);
			k = 0;
			while(k < tamelit) {
				this.pob.add(aux.getChromosome(k));
				k++;
			}
			//Para medir
			this.pob.evaluar(this.cleantext);
			this.media[i] = this.media(this.pob);
			this.losMejores[i]=this.pob.getTheBest();
			if(pob.getTheBest() > this.elMejorDeTodos[i-1]){
				this.elMejorDeTodos[i] = pob.getTheBest();

				this.solution =  this.pob.getChromosome(this.pob.getPosBest());
			}
			else
				this.elMejorDeTodos[i] = this.elMejorDeTodos[i-1];
		}
		System.out.println("Numero  de cruces:" + numbcross);
		System.out.println("Numero de mutaciones"+numbmuta);
	}
	private double media(Population pob2) {
		double aux=0;
		for(int i = 0; i< this.tampob;i++)
			aux+= pob2.getChromosome(i).getFitness();
		aux= aux/this.tampob;
		return aux;
	}




}
