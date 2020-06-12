package Biblioteca;

public class Libro extends Publicacion implements Prestable{
	private boolean prestado;
	
	public Libro(String codigo, String titulo, int añoP){
		super(codigo, titulo, añoP);
		this.setPrestado(false);
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
	
	public String toString(){
		return super.toString()+"; Prestado= "+isPrestado();
		
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}
}
