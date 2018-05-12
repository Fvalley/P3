package model;

public class Nodo {
	private Nodo hijoIzq = null;
	private Nodo hijoDer = null;
	private Nodo padre = null;
	private Elemento funcion = null;
	protected static Elemento[] funciones = Elemento.values();
	private int profundidad;
	private int indice = -1;
	
	public Nodo(int length, Nodo padre, int i){
		this.padre = padre;
		i++;
		this.indice = i;
		this.profundidad = padre.getProfundidad() +1;
		if(length > 0){
			this.funcion = funciones[(int) Math.round(Math.random()*6)];
			if(!this.esTerminal()){
				if(this.esBiFuncion())
					this.añadirHijo(new Nodo(length-1, this, i));
				this.añadirHijo(new Nodo(length-1, this, i));
			}
		}
		else
			this.funcion = Elemento.A;
		
	}
	public Nodo() {
		this.profundidad = 0;
		int i = 1;
		this.indice = i;
		this.funcion = funciones[(int) Math.round(Math.random()*6)];
	}
	public Nodo(Nodo tree, Nodo padre) {
		// TODO Auto-generated constructor stub
		this.funcion = tree.getFuncion();
		if(padre != null)
			this.padre = padre;
		this.profundidad = tree.profundidad;
		this.hijoIzq = new Nodo(tree.getHijoIzq(),this);
		this.hijoDer = new Nodo(tree.getHijoDer(), this);
		
	}
	
	
	public boolean esRaiz(){
		return (this.padre == null) ? true : false;
	}
	public boolean esBiFuncion(){
		if(this.funcion == Elemento.Suma || this.funcion ==Elemento.Resta || this.funcion ==Elemento.Multiplicacion|| 
				this.funcion ==Elemento.Division)
			return true;
		else
			return false;
	}
	public boolean esTerminal(){
		return (this.funcion == Elemento.A) ? true : false;
	}
	public boolean tieneHijo(){
		return (hijoIzq!= null) ? true : false;
	}
	public void añadirHijo(Nodo hijo)
	{
		if(this.hijoIzq == null)
			this.hijoIzq = hijo;
		else if(this.hijoDer == null)
			this.hijoDer = hijo;
	}
	
	
	public Nodo getHijoDer() {
		// TODO Auto-generated method stub
		return this.hijoDer;
	}
	public Nodo getHijoIzq() {
		// TODO Auto-generated method stub
		return this.hijoIzq;
	}
	public int getProfundidad() {
		// TODO Auto-generated method stub
		return this.profundidad;
	}
	private Elemento getFuncion() {
		// TODO Auto-generated method stub
		return this.funcion;
	}
	public Nodo getNodo(int i) {
		// TODO Auto-generated method stub
		if(this.indice == i)
			return this;
		else
		{
			if(this.getHijoDer().indice > i)
				return this.hijoIzq.getNodo(i);
			else
				return this.hijoDer.getNodo(i);
		}
	}
	public void setNodo(int k, Nodo gen) {
		// TODO Auto-generated method stub
		if(this.indice == k){
			this.funcion = gen.getFuncion();
			this.profundidad = gen.profundidad;
			this.hijoIzq = new Nodo(gen.getHijoIzq(),this);
			this.hijoDer = new Nodo(gen.getHijoDer(),this);
		}
		else
		{
			if(this.getHijoDer().indice > k)
				this.hijoIzq.setNodo(k, gen);
			else
				this.hijoDer.setNodo(k,gen);
		}
	}
	public Nodo getPadre() {
		// TODO Auto-generated method stub
		return this.padre;
	}
	public int getIndex() {
		// TODO Auto-generated method stub
		return this.indice;
	}
	public void setHijoIzq(Nodo hijo) {
		// TODO Auto-generated method stub
		this.hijoIzq = hijo;
	}
	public void setHijoDer(Nodo hijo) {
		// TODO Auto-generated method stub
		this.hijoDer = hijo;
	}
	public void setFuncion(Elemento elemento) {
		// TODO Auto-generated method stub
		this.funcion= elemento;
	}
	public void setPadre(Nodo padre2) {
		// TODO Auto-generated method stub
		this.padre= padre2;
	}
	public void setIndice(int i) {
		// TODO Auto-generated method stub
		this.indice=i;
	}
	public void setProfundidad(int i) {
		// TODO Auto-generated method stub
		this.profundidad=i;
	}
}
