
public class Adyacente {
	private Nodo nodo;
	private Arco arco;
	
	public Adyacente(Nodo n, Arco a){
		this.setNodo(n);
		this.setArco(a);
	}
	
	public Adyacente() {
		this(null,null);
	}

	public String toString() {
		return "[Arco: "+this.getArco().getCosto()+" ; Nodo: "+this.getNodo().getIndice()+"]";
	}
	
	public Nodo getNodo() {
		return nodo;
	}
	public void setNodo(Nodo n) {
		this.nodo = n;
	}
	public Arco getArco() {
		return arco;
	}
	public void setArco(Arco a) {
		this.arco = a;
	}
}
