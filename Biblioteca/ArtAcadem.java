package Biblioteca;

public class ArtAcadem extends Publicacion{
	private String autor;
	
	public ArtAcadem(String codigo, String titulo, int añoP, String x){
		super(codigo, titulo, añoP);
		this.setAutor(x);
	}
	
	public String toString(){
		return super.toString()+"; Autor= "+getAutor();	
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
}
