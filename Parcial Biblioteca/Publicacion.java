public class Publicacion implements Prestable{
	private int autor;
	private String titulo;
	private int año;
	private boolean prestado;
	
	public Publicacion(int autor, String titulo, int año, boolean prestado){
		this.setAutor(autor);
		this.setTitulo(titulo);
		this.setAño(año);
		this.setPrestado(prestado);
	}

	public int getAutor() {
		return autor;
	}

	public void setAutor(int autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}
	
	public String toString(){
		return "autor= "+getAutor()+"; titulo= "+getTitulo()+"; Año de edicion= "+getAño()+"; Prestado= "+isPrestado();
	}
	
	public void prestar() {	
		this.setPrestado(true);
	}

	public void devolver() {
		this.setPrestado(false);
	}

	public boolean estaPrestado() {
		if(this.isPrestado()) return true;
		else return false;
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}
}
