package Biblioteca;

public class Revista extends Publicacion {
	private int numero;
	
	public Revista(String codigo, String titulo, int añoP, int x){
		super(codigo, titulo, añoP);
		this.setNumero(x);
	}
	
	public String toString(){
		return super.toString()+"; Numero= "+getNumero();
		
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
}
