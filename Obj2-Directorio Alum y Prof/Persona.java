public class Persona implements Comparable<Persona>{
	private String apellido;
	private String nombre;
	private String dni;
	private String direccion;
	private String telefono;
	private String fNacimiento;
	
	
	public Persona(String apellido, String nombre, String dni, String direccion, String telefono, String fNacimiento) {
		this.setApellido(apellido);
		this.setNombre(nombre);
		this.setDni(dni);
		this.setDireccion(direccion);
		this.setTelefono(telefono);
		this.setfNacimiento(fNacimiento);
	}
	
	public Persona (Persona p) {
		this(p.getApellido(),p.getNombre(),p.getDni(),p.getDireccion(),p.getTelefono(),p.getfNacimiento());
	}
	
	public Persona() {
		this(null,null,null,null,null,null);
	}
	
	public int compareTo(Persona p) {
		if(this.getApellido().compareToIgnoreCase(p.getApellido())==0) return this.getNombre().compareToIgnoreCase(p.getNombre());
		else return this.getApellido().compareToIgnoreCase(p.getApellido());
	}
	
	
	public String toString() {
		return "Apellido: "+this.getApellido()+"; Nombre: "+this.getNombre()+"; DNI: "+this.getDni()+"; Direccion: "+this.getDireccion()+"; Telefono: "+this.getTelefono()+"; Fecha de Nacimiento: "+this.getfNacimiento();
	}
	
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	public String getfNacimiento() {
		return fNacimiento;
	}
	public void setfNacimiento(String fNacimiento) {
		this.fNacimiento = fNacimiento;
	}
}
