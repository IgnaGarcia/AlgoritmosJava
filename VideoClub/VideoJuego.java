package VideoClub;

public class VideoJuego implements Entregable{
	private String titulo;
	private int horas;
	private String genero;
	private String compania;
	private boolean entregado;
	
	public VideoJuego(String titulo, int horas, String genero, String compania){
		 this.setTitulo(titulo);
		 this.setHoras(horas);
		 this.setGenero(genero);
		 this.setCompania(compania);
		 this.setEntregado(false);
	 }
	 
	 public VideoJuego(String titulo, int horas){
		 this(titulo,horas,null,null);
	 }
	 
	 public VideoJuego(){
		 this(null,10,null,null);
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

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public boolean isEntregado() {
		return entregado;
	}

	public void setEntregado(boolean entregado) {
		this.entregado = entregado;
	}
}
