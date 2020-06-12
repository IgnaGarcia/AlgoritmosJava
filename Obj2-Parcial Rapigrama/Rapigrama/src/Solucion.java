import java.util.Comparator;

public class Solucion implements Comparator<Solucion>{
	private int numeroDePalabra;
	private char orientacion;
	
	public Solucion(int num, char orientacion){//Constructores con diferentes usos
		this.setNumeroDePalabra(num);
		this.setOrientacion(orientacion);
	}
	
	public Solucion(){
		this.setNumeroDePalabra(0);
		this.setOrientacion(' ');
	}
	
	public int compare(Solucion s1, Solucion s2) {//Metodo ordenador dependiendo el numero de palabra
		int i=0;
		if(s1.getNumeroDePalabra()<s2.getNumeroDePalabra()) i=-1;
		if(s1.getNumeroDePalabra()==s2.getNumeroDePalabra()) i=0;
		if(s1.getNumeroDePalabra()>s2.getNumeroDePalabra()) i=1;
		return i;
	} 
	
	public int getNumeroDePalabra() {
		return numeroDePalabra;
	}
	public void setNumeroDePalabra(int numeroDePalabra) {
		this.numeroDePalabra = numeroDePalabra;
	}
	public char getOrientacion() {
		return orientacion;
	}
	public void setOrientacion(char orientacion) {
		this.orientacion = orientacion;
	}
}
