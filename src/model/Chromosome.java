package model;

public class Chromosome {
	private Nodo tree;//cadena de bits (genotipo)
	private int treeLength = 0;//profundidad maxima del arbol
	private double fitness = 0;//funcion de evaluacion fitness adaptacion)
	private double puntuation = 0;//puntuacion relativa(aptitud/suma)
	private double punt_acum = 0;//puntuacion acumulada para seleccion
	private final static double[] datos = {0.72 , 1 , 1.52 , 5.2 , 9.53 , 19.1};
	private final static double[] resultados = {0.61 ,1 ,1.84 ,11.9 ,29.4 ,83.5 };
	//Random creation
	public Chromosome(int treeLength, Nodo nodo){
		this.tree =nodo;
		this.treeLength = treeLength;
	}
	
	//Constructor of a copy cromosoma
	public Chromosome(Chromosome chromosome) {
		// TODO Auto-generated constructor stub
		this.tree = new Nodo(chromosome.tree, null);
		this.fitness= chromosome.fitness;
		this.punt_acum = chromosome.punt_acum;
		this.puntuation = chromosome.puntuation;
		this.treeLength =chromosome.treeLength;
	}

	//Decodes genotype to fenotype
	public String decodificador(){
		//Convert text to uppercase, separate it on chars, convert actual text to new text with genes array
		return this.tree.getText();
	}

	/**
	 * Calculate the fitness
	 * @param text Example text to control the value of this chromosome
	 */
	public void calculos(){
		double aux=0;
		for (int i = 0; i< resultados.length;i++) {
			aux+= Math.abs(this.tree.getCalc(datos[i])-resultados[i]);
		}
		if(aux != aux)//Si resulta NaN
			this.fitness = Integer.MAX_VALUE;
		else
			this.fitness = aux;
	}


	//Getters & Setters

	public double getFitness(){
		
		return this.fitness;
	}
	public void setPuntuation(double d) {
		// TODO Auto-generated method stub
		this.puntuation = d;
	}
	public double getPuntuation() {
		// TODO Auto-generated method stub
		return this.puntuation;
	}
	public void setPuntAcum(double d) {
		// TODO Auto-generated method stub
		this.punt_acum = d;
	}
	public double getPuntAcum() {
		// TODO Auto-generated method stub
		return this.punt_acum;
	}

	public Nodo getNode(int i) {
		return this.tree.getNodo(i);
	}
	public void setFitness(double minValue) {
		// TODO Auto-generated method stub
		this.fitness = minValue;
	}
	public void setNode(int k, Nodo gen) {
		this.tree.setNodo(k,gen );
	}
	public Nodo getGenes() {
		return this.tree;
	}

	public double getNumNodos() {
		// TODO Auto-generated method stub
		return this.tree.elUltimo()+1;
	}

	public String getSolution() {
		// TODO Auto-generated method stub
		return this.tree.getText();
	}
}
