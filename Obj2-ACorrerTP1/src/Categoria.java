import java.util.HashMap;


public class Categoria{
	private int nCat;
	private int menor;
	private int mayor;
	private char genero;
	private String podio;
	private HashMap<Integer, Competidor> lCompetidores;
	private int ganador;
	
	public Categoria(int nCat, int menor, int mayor, char genero, HashMap<Integer, Competidor> lCompetidores) {
		this.setnCat(nCat);
		this.setMenor(menor);
		this.setMayor(mayor);
		this.setGenero(genero);
		this.setPodio(""+this.getnCat());
		this.setlCompetidores(lCompetidores);
		this.setGanador(0);
	}
	
	public Categoria(int nCat, int menor, int mayor, char genero) {
		this(nCat,menor,mayor,genero,null);
	}
	
	public Categoria() {
		this(0,0,0,' ');
	}
	
	public boolean equals(Categoria c){
		if(this.getGenero()==c.getGenero() && this.getnCat()==c.getnCat()) return true;
		else return false;
	}
	
	public String toString() {
		return "[Categoria n"+this.getnCat()+"; Genero "+this.getGenero()+"; Desde "+this.getMenor()+" Hasta "+this.getMayor()+";]";
	}
	
	public void calcPodioM(Competidor comp) {
		if(this.getGanador()<3 && comp.getPosicion()!=0) {//Siempre y cuando  el podio este incompleto
			this.setPodio(this.getPodio()+" "+comp.getnCompetidor());  //Cargar numero de competidor al podio
			this.setGanador(this.getGanador()+1); //aumentar contador de ganadores en esta categoria
			
		}
	}

	public void calcPodioF(Competidor comp) {
		if(this.getGanador()<3 && comp.getPosicion()!=0) {//Siempre y cuando el podio este incompleto
			this.setPodio(this.getPodio()+" "+comp.getnCompetidor());  //Cargar numero de competidor al podio
			this.setGanador(this.getGanador()+1); //aumentar contador de ganadores en esta categoria
		}
	}

	
	public int getnCat() {
		return nCat;
	}
	public void setnCat(int nCat) {
		this.nCat = nCat;
	}
	
	public int getMenor() {
		return menor;
	}
	public void setMenor(int menor) {
		this.menor = menor;
	}
	
	public int getMayor() {
		return mayor;
	}
	public void setMayor(int mayor) {
		this.mayor = mayor;
	}
	
	public char getGenero() {
		return genero;
	}
	public void setGenero(char genero) {
		this.genero = genero;
	}
	
	public String getPodio() {
		return podio;
	}
	public void setPodio(String podio) {
		this.podio = podio;
	}

	public HashMap<Integer, Competidor> getlCompetidores() {
		return lCompetidores;
	}
	public void setlCompetidores(HashMap<Integer, Competidor> lCompetidores) {
		this.lCompetidores = lCompetidores;
	}

	public int getGanador() {
		return ganador;
	}

	public void setGanador(int ganador) {
		this.ganador = ganador;
	}

}