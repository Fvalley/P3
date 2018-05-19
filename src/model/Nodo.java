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
				if(this.esBiFuncion()) {
					this.anadirHijo(new Nodo(length-1, this, i));
					i =this.elUltimo();
				}
				this.anadirHijo(new Nodo(length-1, this, i));
			}
		}
		else
			this.funcion = Elemento.A;
	}
	public Nodo() {
		this.profundidad = 0;
		this.indice = 0;
		this.funcion = funciones[(int) Math.round(Math.random()*6)];
	}
	public Nodo(Nodo tree, Nodo padre) {
		// TODO Auto-generated constructor stub
		if(tree != null) {
			this.funcion = tree.getFuncion();
			
			this.indice = tree.indice;
			this.profundidad = tree.profundidad;
			if(padre != null) {
				this.padre = padre;
			}
			if(tree.hijoIzq!= null)
				this.hijoIzq = new Nodo(tree.getHijoIzq(),this);
			if(tree.hijoDer != null)
				this.hijoDer = new Nodo(tree.getHijoDer(), this);
		}
	}


	public Nodo(Nodo tree, Nodo padre, int k) {
		// TODO Auto-generated constructor stub
		int j = k;
		this.funcion = tree.getFuncion();
		this.profundidad = tree.profundidad;
		++k;
		this.indice=k;
		if(tree.hijoIzq != null) {
			this.hijoIzq = new Nodo(tree.getHijoIzq(),this, k);
			j = this.elUltimo();
		}
		if(tree.hijoDer != null)
			this.hijoDer = new Nodo(tree.getHijoDer(),this, j);
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
	public int anadirHijo(Nodo hijo)
	{
		if(this.hijoIzq == null)
			this.hijoIzq = hijo;
		else if(this.hijoDer == null)
			this.hijoDer = hijo;
		return hijo.indice;
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
		System.out.println("soy " + this.funcion + " indice " + this.indice);
		if(this.indice == i)
			return this;
		else
		{
			if(this.getHijoDer() == null || this.getHijoDer().indice > i) {
				if(this.getHijoDer() != null)System.out.println("indice del hermano derecho "+ this.getHijoDer().indice);
				return this.hijoIzq.getNodo(i);
				
			}
			else
				return this.hijoDer.getNodo(i);
		}
	}
	public void setNodo(int k, Nodo gen) {
		// TODO Auto-generated method stub
		if(this.indice == k){
			this.funcion = gen.getFuncion();
			this.profundidad = gen.profundidad;
			if(gen.hijoIzq != null)
				this.hijoIzq = new Nodo(gen.getHijoIzq(),this, k);
			int j =this.elUltimo();
			if(gen.hijoDer != null)
				this.hijoDer = new Nodo(gen.getHijoDer(),this, j);
		}
		else
		{
			if(this.getHijoDer() == null || this.getHijoDer().indice > k)
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
	public String getText() {
		// TODO Auto-generated method stub
		String aux = "";
		switch(this.funcion) {
		case Suma:
			aux = "+ ("+ this.hijoIzq.getText() + ") (" + this.hijoDer.getText() + ")";
			break;
		case Resta:
			aux = "- ("+ this.hijoIzq.getText() + ") (" + this.hijoDer.getText() + ")";
			break;
		case Multiplicacion:
			aux = "* ("+ this.hijoIzq.getText() + ") (" + this.hijoDer.getText() + ")";
			break;
		case Division:
			aux = "/ ("+ this.hijoIzq.getText() + ") (" + this.hijoDer.getText() + ")";
			break;
		case LOG:
			aux = "LOG ("+ this.hijoIzq.getText() + ")";
			break;
		case SQRT:
			aux = "SQRT ("+ this.hijoIzq.getText() + ")";
			break;
		case A:
			aux = "A";
			break;
		}
		return aux;
	}
	public double getCalc(double valor) {
		double aux=0;
		switch(this.funcion) {
		case Suma:
			aux = this.hijoIzq.getCalc(valor) + this.hijoDer.getCalc(valor);
			break;
		case Resta:
			aux = this.hijoIzq.getCalc(valor) - this.hijoDer.getCalc(valor);
			break;
		case Multiplicacion:
			aux = this.hijoIzq.getCalc(valor) * this.hijoDer.getCalc(valor);
			break;
		case Division:
			if(this.hijoDer.getCalc(valor)!= 0)
				aux = this.hijoIzq.getCalc(valor) / this.hijoDer.getCalc(valor);
			else
				aux =1000000;
			break;
		case LOG:
			if(this.hijoIzq.getCalc(valor)!= 0)
				aux = Math.log(this.hijoIzq.getCalc(valor));
			else
				aux = 1000000;
			break;
		case SQRT:
			aux = Math.sqrt(this.hijoIzq.getCalc(valor));
			break;
		case A:
			aux = valor;
			break;
		}
		return aux;
	}
	public double getMaxProfundidad() {
		// TODO Auto-generated method stub
		if(this.esTerminal()) {
			return this.profundidad;
		}
		else
		{
			if(this.esBiFuncion()) {
				double aux1 = this.hijoIzq.getMaxProfundidad();
				double aux2 = this.hijoDer.getMaxProfundidad();
				return (aux1 > aux2) ? aux1 : aux2;
			}
			else {
				return this.hijoIzq.getMaxProfundidad();
			}
		}
	}
	public int elUltimo() {
		// TODO Auto-generated method stub
		if(this.hijoDer!=null)
		{
			return this.hijoDer.elUltimo();
		}
		else if(!this.esTerminal())
		{
			return this.hijoIzq.elUltimo();
		}
		else
		{
			return this.indice;
		}
	}
}
