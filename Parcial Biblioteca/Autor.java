public class Autor {
	private String nombre;
	private String apellido;
	private String telf;
	
	public Autor(String nombre, String apellido, String telf){
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setTelf(telf);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelf() {
		return telf;
	}
	public void setTelf(String telf) {
		this.telf = telf;
	}
}
