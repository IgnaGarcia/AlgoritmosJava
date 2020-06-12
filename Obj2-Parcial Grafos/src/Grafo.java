import java.util.ArrayList;

public abstract class Grafo {
	private int[][] matrizAdyacencia;
	private ArrayList<Nodo> listaNodos;
	private ArrayList<Arco> listaArcos;
	private int cantidadDeNodos;
	private Camino dijkstra;
	
	public void calcListaDeNodos(){
		ArrayList<Nodo> nl=new ArrayList<Nodo>();
		Nodo n;
		for(int i=0; i<this.getMatrizAdyacencia().length;i++){
			n= new Nodo(i);
			
			nl.add(n);
		}
		this.setListaNodos(nl);
	}
	
	abstract public void calcListaDeArcos();
	
	abstract public void calcDijkstra(int inicial);
	
	abstract public String toString();
	
	public int[][] getMatrizAdyacencia() {
		return matrizAdyacencia;
	}
	public void setMatrizAdyacencia(int[][] matrizAdyacencia) {
		this.matrizAdyacencia = matrizAdyacencia;
	}
	public ArrayList<Nodo> getListaNodos() {
		return listaNodos;
	}
	public void setListaNodos(ArrayList<Nodo> listaAdyacencia) {
		this.listaNodos = listaAdyacencia;
	}
	public int getCantidadDeNodos() {
		return cantidadDeNodos;
	}
	public void setCantidadDeNodos(int cantidadDeNodos) {
		this.cantidadDeNodos = cantidadDeNodos;
	}
	public ArrayList<Arco> getListaArcos() {
		return listaArcos;
	}
	public void setListaArcos(ArrayList<Arco> listaArcos) {
		this.listaArcos = listaArcos;
	}
	public Camino getDijkstra() {
		return dijkstra;
	}
	public void setDijkstra(Camino dijkstra) {
		this.dijkstra = dijkstra;
	}
}
