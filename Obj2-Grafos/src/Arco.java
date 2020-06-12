
public class Arco implements Comparable<Arco>{
	private Integer costo;
	private Nodo nodo1;
	private Nodo nodo2;
	private Integer direccion;
	private Integer indice;
	
	public Arco(Integer costo, Nodo n1, Nodo n2, Integer direc){
		this.setCosto(costo);
		this.setNodo1(n1);
		this.setNodo2(n2);
		this.setDireccion(direc);
	}
	
	public Arco(Integer costo, Nodo n1, Nodo n2){
		this.setCosto(costo);
		this.setNodo1(n1);
		this.setNodo2(n2);
		this.setDireccion(0);
	}
	
	public Arco(){
		this(0, null, null,0);
	}
	
	public String toString(){
		return "[Arco: "+this.getCosto()+" ; Desde "+this.getNodo1().getIndice()+" Hasta "+this.getNodo2().getIndice()+" ]";
	}
	
	public int compareTo(Arco a) {
		if(this.getCosto()>a.getCosto()) return 1;
		else if(this.getCosto()<a.getCosto()) return -1;
		else return 0;
	}
	
	public Integer getCosto() {
		return costo;
	}
	public void setCosto(Integer costo) {
		this.costo = costo;
	}
	public Nodo getNodo1() {
		return nodo1;
	}
	public void setNodo1(Nodo nodo1) {
		this.nodo1 = nodo1;
	}
	public Nodo getNodo2() {
		return nodo2;
	}
	public void setNodo2(Nodo nodo2) {
		this.nodo2 = nodo2;
	}
	public Integer getDireccion() {
		return direccion;
	}
	public void setDireccion(Integer direccion) {
		this.direccion = direccion;
	}
	public Integer getIndice() {
		return indice;
	}
	public void setIndice(Integer indice) {
		this.indice = indice;
	}
}
