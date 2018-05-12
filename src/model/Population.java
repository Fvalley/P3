package model;

import inicializacion.Iniciacion;
import mutation.Mutation;

public class Population {
	private Chromosome[] individuals;
	private int pobSize;
	private double theBest;
	private int posBest;
	private static String cleantext;
	public Population(int tam, int length){
		this.pobSize = tam;
		this.individuals= Iniciacion.getInstance().execute(length,this.pobSize);
		
	}
	public Population() {
		this.pobSize=0;
		this.theBest = Integer.MIN_VALUE;
		this.posBest = -1;
	}
	public Population(Population pob) {
		// TODO Auto-generated constructor stub
		this.individuals= new Chromosome[pob.pobSize];
		for (int i = 0; i < pob.pobSize;i++) {
			this.individuals[i] = new Chromosome(pob.individuals[i]);
		}
		this.pobSize= pob.pobSize;
		this.theBest=pob.theBest;
		this.posBest=pob.posBest;
	}
	public void elMejor(double[] aux){
		double soFit = aux[0];
		int pos = 0;
		for(int i = 1; i < this.pobSize; i++){
			if(aux[i] > soFit){
				soFit = aux[i];
				pos = i;
			}
		}
		this.theBest = soFit;
		this.posBest = pos;
	}
	public void FitnessSum(double[] aux){
		double sum = 0;
		for(int i = 0;i < this.pobSize;i++ ){
			sum += aux[i];
		}
		for(int j = 0 ; j < this.pobSize;j++){
			individuals[j].setPuntuation(aux[j]/sum);
		}
		individuals[0].setPuntAcum(individuals[0].getPuntuation());
		for(int k = 1; k < this.pobSize;k++){
			
			individuals[k].setPuntAcum(individuals[k].getPuntuation() + individuals[k - 1].getPuntAcum());
		}
	}
	public void evaluar(String cleantext){
		double[] aux = new double[this.pobSize];
		
		for(int i = 0; i < this.pobSize; i++){
			this.individuals[i].calculos();
		}
		for (int i = 0;i < this.pobSize;i++)
			aux[i] = individuals[i].getFitness();
		this.elMejor(aux);
		this.FitnessSum(aux);
		
		
	}
	public void add(Chromosome chromosome) {
		// TODO Auto-generated method stub
		int j = (int) Math.round(Math.random()*this.pobSize);
		Chromosome[] aux = new Chromosome[this.pobSize+1];
		for (int i=0; i < j;i++) {
			aux[i]= new Chromosome(this.individuals[i]);
		}
		aux[j] = new Chromosome(chromosome);
		for (int i=j+1; i <= this.pobSize;i++) {
			aux[i]= new Chromosome(this.individuals[i-1]);
		}
		
		this.individuals = aux;
		this.pobSize++;
	}
	public void clear() {
		// TODO Auto-generated method stub
		this.pobSize=0;
		this.theBest = Integer.MIN_VALUE;
		this.posBest = -1;
	}
	public Chromosome getChromosome(int index){
		return this.individuals[index];
	}
	public double getTheBest() {
		return this.theBest;
	}
	public int getPosBest() {
		return this.posBest;
	}
	public int getTam() {
		// TODO Auto-generated method stub
		return this.pobSize;
	}
	public int mutate(double porcmuta, int k) {
		// TODO Auto-generated method stub
		double j;
		int res =0;
		for(int i =0;i<this.pobSize;i++) {
			j=Math.random();
			if(j<porcmuta) {
				Mutation.getInstance().execute(this.individuals[i], k);
				res++;
			}
		}
		return res;
	}
	public static String getText() {
		// TODO Auto-generated method stub
		return Population.cleantext;
	}
	public static void setText(String cleantext2) {
		// TODO Auto-generated method stub
		cleantext= cleantext2;
	}

}
