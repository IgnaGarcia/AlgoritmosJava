import java.util.ArrayList;

public class Camino {
	private Integer Costo;
	private ArrayList<Nodo> listaNodosTomados;
	private ArrayList<Arco> listaArcosTomados;
	
	public Camino(){
		ArrayList<Nodo> list1=new ArrayList<Nodo>();
		ArrayList<Arco> list2=new ArrayList<Arco>();
		
		this.setCosto(0);
		this.setListaNodosTomados(list1);
		this.setListaArcosTomados(list2);
	}
	
	public String toString() {
		return "\nCamino:\nCosto: "+this.getCosto()+"\nNodos: "+this.getListaNodosTomados()+"\nArcos: "+this.getListaArcosTomados();
	}
	
	public Integer getCosto() {
		return Costo;
	}
	public void setCosto(Integer costo) {
		Costo = costo;
	}
	public ArrayList<Arco> getListaArcosTomados() {
		return listaArcosTomados;
	}
	public void setListaArcosTomados(ArrayList<Arco> listaArcosTomados) {
		this.listaArcosTomados = listaArcosTomados;
	}
	public ArrayList<Nodo> getListaNodosTomados() {
		return listaNodosTomados;
	}
	public void setListaNodosTomados(ArrayList<Nodo> listaNodosTomados) {
		this.listaNodosTomados = listaNodosTomados;
	}
	
}
