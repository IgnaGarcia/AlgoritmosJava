public class ColaDinamica <T> extends Lista <T> implements Cola <T>{
	 public ColaDinamica() {
		 super();
	 }
	 
	public void encolar(T dato) {
		 if(esVacia())this.insertarInicio(new Nodo<T>(dato));
		 else this.insertarFinal(new Nodo<T>(dato));
	}

	public void desencolar() {
		 if(!esVacia())this.eliminarInicio();
	}

	public T primero() {
		if(!esVacia()) {
			Nodo<T> aux=this.getInicio();
			return aux.getDato();
		}
		else return null;
	}

	public boolean esVacia() {
		if(this.getInicio()==null && this.getEnd()==null)return true;
		else return false;
	}

	public void vaciar() {	
		this.setInicio(null);
		this.setEnd(null);
	}

}
