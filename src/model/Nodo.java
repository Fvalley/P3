package model;

public class Nodo {
	private Nodo hijoIzq = null;
	private Nodo hijoDer = null;
	private Nodo padre = null;
	private Elemento funcion = null;
	private static Elemento[] funciones = Elemento.values();
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
					this.a�adirHijo(new Nodo(length-1, this, i));
				this.a�adirHijo(new Nodo(length-1, this, i));
			}
		}
		else
			this.funcion = Elemento.A;
		
	}
	public Nodo(int treeLength) {
		this.profundidad = 0;
		int i = 0;
		this.indice = i;
		this.funcion = funciones[(int) Math.round(Math.random()*6)];
		if(!this.esTerminal()){
			if(this.esBiFuncion())
				this.a�adirHijo(new Nodo(treeLength-1, this, i));
			this.a�adirHijo(new Nodo(treeLength-1, this, i));
		}
	}
	public Nodo(Nodo tree) {
		// TODO Auto-generated constructor stub
		this.funcion = tree.getFuncion();
		this.profundidad = tree.profundidad;
		this.hijoIzq = new Nodo(tree.getHijoIzq());
		this.hijoDer = new Nodo(tree.getHijoDer());
		
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
	public void a�adirHijo(Nodo hijo)
	{
		if(this.hijoIzq == null)
			this.hijoIzq = hijo;
		else if(this.hijoDer == null)
			this.hijoDer = hijo;
	}
	
	
	private Nodo getHijoDer() {
		// TODO Auto-generated method stub
		return this.hijoDer;
	}
	private Nodo getHijoIzq() {
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
			this.hijoIzq = new Nodo(gen.getHijoIzq());
			this.hijoDer = new Nodo(gen.getHijoDer());
		}
		else
		{
			if(this.getHijoDer().indice > k)
				this.hijoIzq.setNodo(k, gen);
			else
				this.hijoDer.setNodo(k,gen);
		}
	}
}