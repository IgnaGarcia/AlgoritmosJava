package Biblioteca;

public class Publicacion {
	private String codigo;
	private String titulo;
	private int añoP;
	
	public Publicacion(String codigo, String titulo, int añoP){
		this.setCodigo(codigo);
		this.setTitulo(titulo);
		this.setAñoP(añoP);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAñoP() {
		return añoP;
	}

	public void setAñoP(int añoP) {
		this.añoP = añoP;
	}
	
	public String toString(){
		return "codigo= "+getCodigo()+"; titulo= "+getTitulo()+"; Año de publicacion= "+getAñoP();
	}
}
