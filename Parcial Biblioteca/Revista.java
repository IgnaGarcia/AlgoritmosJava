public class Revista extends Publicacion{
	private String coleccion;
	private int numero;
	
	public Revista(int autor, String titulo, int año, int x, String coleccion, boolean prestado){
		super(autor, titulo, año, prestado);
		this.setNumero(x);
		this.setColeccion(coleccion);
	}
	
	public String toString(){
		return super.toString()+"; Numero= "+getNumero()+"; Coleccion = "+getColeccion();
		
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getColeccion() {
		return coleccion;
	}

	public void setColeccion(String coleccion) {
		this.coleccion = coleccion;
	}
}