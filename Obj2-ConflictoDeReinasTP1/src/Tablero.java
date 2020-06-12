public class Tablero {
	private int posiciones; //dimension del tablero
	private int cantReinas;//cantidad de reinas
	private Reina[][] posicionReina;//lista con las reinas del tablero
	
	public Tablero(int posiciones, int cantReinas, Reina[][] posicionReina) {
		this.setPosiciones(posiciones);
		this.setCantReinas(cantReinas);
		this.setPosicionReina(posicionReina);
	}
	
	public Tablero(int posiciones, int cantReinas) {
		this.setPosiciones(posiciones);
		this.setCantReinas(cantReinas);
	}
	
	public Tablero() {
		this(0,0);
	}
	
	public Tablero(Tablero t) {
		this(t.getPosiciones(),t.getCantReinas(),t.getPosicionReina());
	}

	public int getPosiciones() {
		return posiciones;
	}
	public void setPosiciones(int posiciones) {
		this.posiciones = posiciones;
	}
	public int getCantReinas() {
		return cantReinas;
	}
	public void setCantReinas(int cantReinas) {
		this.cantReinas = cantReinas;
	}
	public Reina[][] getPosicionReina() {
		return posicionReina;
	}
	public void setPosicionReina(Reina[][] posicionReina) {
		this.posicionReina = posicionReina;
	}
}
