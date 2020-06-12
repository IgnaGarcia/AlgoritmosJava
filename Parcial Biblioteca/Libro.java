public class Libro extends Publicacion{
	private String dewey;
	
	public Libro(int autor, String titulo, int año, String dewey,boolean prestado){
		super(autor, titulo, año, prestado);
		this.setDewey(dewey);
	}
	
	public String toString(){
		return super.toString()+"; Dewey= "+getDewey();	
	}

	public String getDewey() {
		return dewey;
	}

	public void setDewey(String dewey) {
		this.dewey= dewey;
	}
}