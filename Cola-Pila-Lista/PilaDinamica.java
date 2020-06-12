public class PilaDinamica <T> extends Lista <T> implements Pila <T> {
	 public PilaDinamica() {
		 super();
	 }
	 
	 public void apilar(T dato) {
			 this.insertarInicio(new Nodo<T>(dato));
	 }
	 
	 public void desapilar() {
		 if(!esVacia())this.eliminarInicio();
	 }

	public boolean esVacia() {
		if(this.getInicio()==null && this.getEnd()==null)return true;
		else return false;
	}
	
	public T cima() {
		Nodo<T> aux=this.getInicio();
		return aux.getDato();
	}
	
	public void vaciar() {
		this.setInicio(null);
		this.setEnd(null);
	}	 
}