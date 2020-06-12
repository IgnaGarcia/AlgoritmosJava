package VideoClub;

public class Serie implements Entregable{
	 private String titulo;
	 private int temporadas;
	 private String genero;
	 private String creador;
	 private boolean entregado;

	 public Serie(String titulo, int temporadas, String genero, String creador){
		 this.setTitulo(titulo);
		 this.setTemporadas(temporadas);
		 this.setGenero(genero);
		 this.setCreador(creador);
		 this.setEntregado(false);
	 }
	 
	 public Serie(String titulo, String creador){
		 this(titulo,3,null,creador);
	 }
	 
	 public Serie(){
		 this(null,3,null,null);
	 }
	 
	public void entregar() {
		this.setEntregado(true);
	}

	public void devolver() {
		this.setEntregado(false);
	}

	public boolean estaEntregado() {
		if(this.isEntregado()) return true;
		return false;
	} 

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(int temporadas) {
		this.temporadas = temporadas;
	}

	public boolean isEntregado() {
		return entregado;
	}

	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
}
