import java.util.*;

public class Competidor implements Comparator<Competidor>{
	private int edad;
	private char genero;
	private Categoria cat;
	private int nCompetidor;
	private int posicion;
	
	public Competidor(int edad, char genero, Categoria cat, int nCompetidor, int posicion) {
		this.setEdad(edad);
		this.setGenero(genero);
		this.setCat(cat);
		this.setnCompetidor(nCompetidor);
		this.setPosicion(posicion);
	}
	
	public Competidor(int edad, char genero, int nCompetidor) {
		this.setEdad(edad);
		this.setGenero(genero);
		this.setnCompetidor(nCompetidor);
		this.setPosicion(0);
	}
	
	public Competidor() {
		this(0,' ',null,0,0);
	}
	
	public Competidor(Competidor competidor) {
		this.setEdad(competidor.getEdad());
		this.setGenero(competidor.getGenero());
		this.setnCompetidor(competidor.getnCompetidor());
		this.setCat(competidor.getCat());
	}

	public String toString() {
		return "[Competidor n"+this.getnCompetidor()+"; Edad: "+this.getEdad()+"; Genero: "+this.getGenero()+" (categoria n"+this.getCat().getnCat()+")";
	}
	
	public void calcCategoria(ArrayList<Categoria> lCategoriasF, ArrayList<Categoria> lCategoriasM) {
		if(this.getGenero()=='M') {
			for(Categoria c: lCategoriasM) {//Compara con cada categoria por edad
				if(c.getMenor()<=this.getEdad() && this.getEdad()<=c.getMayor()) {
					this.setCat(c);
					c.getlCompetidores().put(this.getnCompetidor(), this);
					break;
				}
			}
		}
		else {
			for(Categoria c: lCategoriasF) {//Compara con cada categoria por edad
				if(c.getMenor()<=this.getEdad() && this.getEdad()<=c.getMayor()) {
					this.setCat(c);
					c.getlCompetidores().put(this.getnCompetidor(), this);
					break;
				}
			}
		}
		
	}
	
	public int compare(Competidor c1, Competidor c2) {//Metodo a partir del cual se ordena la lista
		int i=0;
		if(c1.getPosicion()<c2.getPosicion()) i=-1;
		if(c1.getPosicion()==c2.getPosicion()) i=0;
		if(c1.getPosicion()>c2.getPosicion()) i=1;
		return i;
	}
	
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public char getGenero() {
		return genero;
	}
	public void setGenero(char genero) {
		this.genero = genero;
	}
	
	public Categoria getCat() {
		return cat;
	}
	public void setCat(Categoria cat) {
		this.cat = cat;
	}
	
	public int getnCompetidor() {
		return nCompetidor;
	}
	public void setnCompetidor(int nCompetidor) {
		this.nCompetidor = nCompetidor;
	}
	
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	
}
