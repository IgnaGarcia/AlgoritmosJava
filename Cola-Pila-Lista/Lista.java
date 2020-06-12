public class Lista<T> {
	private Nodo<T> inicio;
	private Nodo<T> end;
	
	public class Nodo <T>{
		private T dato;
		private Nodo<T> siguiente;
		
		public Nodo(T dato,Nodo<T> siguiente){  //creo un nodo con dato y con nodo siguiente
			this.setDato(dato);
			this.setSiguiente(siguiente);
		}	
		
		public Nodo(T dato){//nodo con dato y sin nodo siguiente
			this(dato,null);
		}
		
		public Nodo(){//nodo sin dato y nodo siguiente
			this(null,null);
		}

		public T getDato() {
			return dato;
		}

		public void setDato(T dato) {
			this.dato = dato;
		}

		public Nodo<T> getSiguiente() {
			return siguiente;
		}

		public void setSiguiente(Nodo<T> siguiente) {
			this.siguiente = siguiente;
		}	
	}
	
	public Lista(Nodo<T> inicio){
		this.setInicio(inicio);
		this.setEnd(getInicio());
	}
	
	public Lista(){
		this(null);
	}
	
	public void insertarInicio(Nodo<T> nodo){
			if(this.getEnd()==null) {
				this.setInicio(nodo);
				this.setEnd(nodo);
			}
			else {
				Nodo<T> aux=this.getInicio();
				this.setInicio(nodo);
				nodo.setSiguiente(aux);
			}
	}

	public void insertarFinal(Nodo<T> nodo){
		Nodo<T> aux=getEnd();
		aux.setSiguiente(nodo);
		this.setEnd(aux.getSiguiente());
	}
	
	public void eliminarFinal(){
		if(this.getInicio()!=null){
			setEnd(null);
		}
		else this.setInicio(null);
	}
	
	public void eliminarInicio(){
		setInicio(getInicio().getSiguiente());	
	}

	public Nodo<T> getInicio() {
		return inicio;
	}

	public void setInicio(Nodo<T> inicio) {
		this.inicio = inicio;
	}

	public Nodo<T> getEnd() {
		return end;
	}

	public void setEnd(Nodo<T> end) {
		this.end = end;
	}
	
}