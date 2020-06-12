
public class Tablero {
	private char[][] tablero;
	private int tamanio;
	
	public Tablero() {//Constructores con diferentes usos
		this.setTablero(null);
		this.setTamanio(0);
	}
	
	public Tablero(int i) {
		this.setTamanio(i);
	}
	
	public char[][] getTablero() {
		return tablero;
	}
	public void setTablero(char[][] tablero) {
		this.tablero = tablero;
	}
	public int getTamanio() {
		return tamanio;
	}
	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}
}
