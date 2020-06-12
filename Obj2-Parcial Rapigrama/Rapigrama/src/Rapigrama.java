import java.util.ArrayList;

public class Rapigrama {
	private ArrayList<String> lPalabras;
	private ArrayList<Solucion> lSoluciones;
	
	public Rapigrama() {//Constructores con diferentes usos
		this(null,null);
	}
	
	public Rapigrama(ArrayList<String> p) {
		this(p,null);
	}
	
	public Rapigrama(ArrayList<String> p, ArrayList<Solucion> s) {
		this.setlPalabras(p);
		this.setlSoluciones(s);
	}
	
	public void calcularCoincidencias(Tablero t) {//Metodo con doble for para recorrer el tablero
		for(int i=0;i<t.getTamanio();i++) {
			for(int j=0;j<t.getTamanio();j++) {
				
				for(int k=0;k<this.getlPalabras().size();k++) {//y un tercero para comprar si la letra del tablero es inicial de alguna palabra a buscar
					String palabra=this.getlPalabras().get(k);//se guarda la palabra
					if(palabra.charAt(0)==t.getTablero()[i][j]) {//se compara la inicial y se manda a buscar
						if(i-1>=0)this.tirarN(palabra, i, j, t, k);//comprobaciones de que no se pase de los limites del tablero
						if(i+1<t.getTamanio())this.tirarS(palabra, i, j, t, k);
						if(j+1<t.getTamanio())this.tirarE(palabra, i, j, t, k);
						if(j-1>=0)this.tirarO(palabra, i, j, t, k);
					}	
				}
			}
		}
	}

	private void tirarO(String palabra, int i, int j, Tablero t, int k) {
		boolean condition=false;
		Solucion s;
		for(int a=1;a<palabra.length();a++) {//for para recorrer la palabra 
			if(j-a>=0) {//siempre que no se pase del tablero
				if(t.getTablero()[i][j-a]==palabra.charAt(a)) condition=true;//se comparan los caracteres debidos y se sige
				else {
					condition=false;//ni bien la comparacion sea falsa re rompe la iteracion
					break;
				}
			}
			else {//en caso de que se pase del tablero, la palabra no se completo
				condition=false;
				break;
			}
		}
		if(condition) {//se guarda la solucion si se encontro la palabra
			s=new Solucion(k+1, 'O');
			this.getlSoluciones().add(s);
		}
	}

	private void tirarE(String palabra, int i, int j, Tablero t, int k) {
		boolean condition=false;
		Solucion s;
		for(int a=1;a<palabra.length();a++) {
			if(j+a<t.getTamanio()) {
				if(t.getTablero()[i][j+a]==palabra.charAt(a)) condition=true;
				else {
					condition=false;
					break;
				}
			}
			else {
				condition=false;
				break;
			}
		}
		if(condition) {
			s=new Solucion(k+1, 'E');
			this.getlSoluciones().add(s);
		}
	}

	private void tirarS(String palabra, int i, int j, Tablero t, int k) {
		boolean condition=false;
		Solucion s;
		for(int a=1;a<palabra.length();a++) {
			if(i+a<t.getTamanio()) {
				if(t.getTablero()[i+a][j]==palabra.charAt(a)) condition=true;
				else {
					condition=false;
					break;
				}
			}
			else {
				condition=false;
				break;
			}
		}
		if(condition) {
			s=new Solucion(k+1, 'S');
			this.getlSoluciones().add(s);
		}
	}

	private void tirarN(String palabra, int i, int j, Tablero t, int k) {
		boolean condition=false;
		Solucion s;
		for(int a=1;a<palabra.length();a++) {
			if(i-a>=0) {
				if(t.getTablero()[i-a][j]==palabra.charAt(a)) condition=true;
				else {
					condition=false;
					break;
				}
			}
			else {
				condition=false;
				break;
			}
		}
		if(condition){
			s=new Solucion(k+1, 'N');
			this.getlSoluciones().add(s);
		}
	}

	public ArrayList<String> getlPalabras() {
		return lPalabras;
	}
	public void setlPalabras(ArrayList<String> lPalabras) {
		this.lPalabras = lPalabras;
	}
	public ArrayList<Solucion> getlSoluciones() {
		return lSoluciones;
	}
	public void setlSoluciones(ArrayList<Solucion> lSoluciones) {
		this.lSoluciones = lSoluciones;
	}
}

