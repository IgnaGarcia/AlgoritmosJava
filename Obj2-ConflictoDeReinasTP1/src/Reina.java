import java.util.ArrayList;

public class Reina{
	private int fila;
	private int columna;
	private int nReina;
	private ArrayList<Conflicto> lConflictos;
	
	public Reina(int fila, int columna, int nReina,ArrayList<Conflicto> lConflictos) {
		this.setFila(fila);
		this.setColumna(columna);
		this.setnReina(nReina);
		this.setlConflictos(lConflictos);
	}
	
	public Reina() {
		this.setFila(0);
		this.setColumna(0);
		this.setnReina(0);
	}
	
	public boolean equals(Reina r) {
		if(this.getColumna()==r.getColumna() && this.getFila()==r.getFila())return true;
		else return false;
	}
	
	public String toString() {
		return "[Posicion fila: "+this.getFila()+"; columna: "+this.getColumna()+"; numero de Reina: "+this.getnReina()+";]";
	}
	
	public void calcularConflicto( Tablero t) {

		for(int k=1; k<=t.getPosiciones(); k++) {//CONFLICTO FILA ASCENDENTE
			if(this.getFila()+k < t.getPosiciones() && t.getPosicionReina()[this.getFila()+k][this.getColumna()]!=null) {
				//comparacion para que no se pase de tablero y si hay alguna reina
				Conflicto aux= new Conflicto(this, t.getPosicionReina()[this.getFila()+k][this.getColumna()]);			
				this.getlConflictos().add(aux);
				break;
			}
		}

		for(int k=1; k<=t.getPosiciones(); k++) {//CONFLICTO FILA DESCENDENTE
			if(this.getFila()-k >= 0 && t.getPosicionReina()[this.getFila()-k][this.getColumna()]!=null) {
				//comparacion para que no se pase de tablero y si hay alguna reina
				Conflicto aux= new Conflicto(this, t.getPosicionReina()[this.getFila()-k][this.getColumna()]);
				this.getlConflictos().add(aux);
				break;
			}
		}

		for(int k=1; k<=t.getPosiciones(); k++) {//CONFLICTO COLUMNA ASCENDENTE
			if(this.getColumna()+k < t.getPosiciones() && t.getPosicionReina()[this.getFila()][this.getColumna()+k]!=null) {
				//comparacion para que no se pase de tablero y si hay alguna reina
				Conflicto aux= new Conflicto(this, t.getPosicionReina()[this.getFila()][this.getColumna()+k]);
				this.getlConflictos().add(aux);
				break;
			}
		}

		for(int k=1; k<=t.getPosiciones(); k++) {//CONFLICTO COLUMNA DESCENDENTE
			if(this.getColumna()-k >= 0 && t.getPosicionReina()[this.getFila()][this.getColumna()-k]!=null) {
				//comparacion para que no se pase de tablero y si hay alguna reina
				Conflicto aux= new Conflicto(this, t.getPosicionReina()[this.getFila()][this.getColumna()-k]);
				this.getlConflictos().add(aux);
				break;
			}
		}

		for(int k=1; k<=t.getPosiciones(); k++) {//CONFLICTO DIAGONAL DOBLE ASCENDENTE
			if(this.getColumna()+k < t.getPosiciones() && this.getFila()+k < t.getPosiciones() && t.getPosicionReina()[this.getFila()+k][this.getColumna()+k]!=null) {
				//comparacion para que no se pase de tablero y si hay alguna reina
				Conflicto aux= new Conflicto(this, t.getPosicionReina()[this.getFila()+k][this.getColumna()+k]);
				this.getlConflictos().add(aux);
				break;
			}
		}

		for(int k=1; k<=t.getPosiciones(); k++) {//CONFLICTO DIAGONAL DOBLE DESCENDENTE
			if(this.getColumna()-k >= 0 && this.getFila()-k >= 0 && t.getPosicionReina()[this.getFila()-k][this.getColumna()-k]!=null) {
				//comparacion para que no se pase de tablero y si hay alguna reina
				Conflicto aux= new Conflicto(this, t.getPosicionReina()[this.getFila()-k][this.getColumna()-k]);
				this.getlConflictos().add(aux);
				break;
			}
		}

		for(int k=1; k<=t.getPosiciones(); k++) {//CONFLICTO DIAGONAL ASCENDENTE FILA DESCENDENTE COLUMNA
			if(this.getColumna()-k >= 0  && this.getFila()+k < t.getPosiciones() && t.getPosicionReina()[this.getFila()+k][this.getColumna()-k]!=null) {
				//comparacion para que no se pase de tablero y si hay alguna reina
				Conflicto aux= new Conflicto(this, t.getPosicionReina()[this.getFila()+k][this.getColumna()-k]);
				this.getlConflictos().add(aux);
				break;
			}
		}

		for(int k=1; k<=t.getPosiciones(); k++) {//CONFLICTO DIAGONAL DESCENDENTE FILA ASCENDENTE COLUMNA
			if(this.getColumna()+k < t.getPosiciones() && this.getFila()-k >= 0  && t.getPosicionReina()[this.getFila()-k][this.getColumna()+k]!=null) {
				//comparacion para que no se pase de tablero y si hay alguna reina
				Conflicto aux= new Conflicto(this, t.getPosicionReina()[this.getFila()-k][this.getColumna()+k]);
				this.getlConflictos().add(aux);
				break;
			}
		}				
	}

	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	public int getColumna() {
		return columna;
	}
	public void setColumna(int columna) {
		this.columna = columna;
	}
	public int getnReina() {
		return nReina;
	}
	public void setnReina(int nReina) {
		this.nReina = nReina;
	}
	public ArrayList<Conflicto> getlConflictos() {
		return lConflictos;
	}
	public void setlConflictos(ArrayList<Conflicto> lConflictos) {
		this.lConflictos = lConflictos;
	}

}
