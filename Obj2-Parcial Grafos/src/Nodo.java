import java.util.ArrayList;

public class Nodo {
	private Integer indice;
	private ArrayList<Adyacente> listaAdyacentes;
	private int color;
	
	public Nodo(Integer indice, ArrayList<Adyacente> adyacentes){
		this.setIndice(indice);
		this.setListaAdyacentes(adyacentes);
		this.setColor(0);
	}
	
	public Nodo( Integer indice){
		this.setIndice(indice);
		ArrayList<Adyacente> listaAdy=new ArrayList<Adyacente>();
		this.setListaAdyacentes(listaAdy);
		this.setColor(0);
	}
	
	public Nodo(){
		this.setIndice(null);
		this.setColor(0);
		ArrayList<Adyacente> listaAdy=new ArrayList<Adyacente>();
		this.setListaAdyacentes(listaAdy);
	}
	
	public Nodo(Nodo nodo) {
		this.setIndice(nodo.getIndice());
		this.setListaAdyacentes(nodo.getListaAdyacentes());
		this.setColor(nodo.getColor());
	}

	public void mostrarAdyacentes(){
		System.out.println(this.getIndice()+" es adyacente con: ");
		for(Adyacente adyacente: this.getListaAdyacentes()){
			System.out.print(adyacente.getArco()+" conecta con "+adyacente.getNodo());
		}
	}
	
	public boolean equals(Nodo n){
		if(this.getIndice()==n.getIndice()) return true;
		else return false;
	}
	
	public String toString(){
		return "[Nodo: "+this.getIndice()+"; Adyacentes: "+this.getListaAdyacentes()+"]";
	}
	
	public Integer getIndice() {
		return indice;
	}
	public void setIndice(Integer indice) {
		this.indice = indice;
	}
	public ArrayList<Adyacente> getListaAdyacentes() {
		return listaAdyacentes;
	}
	public void setListaAdyacentes(ArrayList<Adyacente> listaAdyacentes) {
		this.listaAdyacentes = listaAdyacentes;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
}
