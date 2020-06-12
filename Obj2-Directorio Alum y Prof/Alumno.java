import java.util.Comparator;

public class Alumno extends Persona implements Comparator<Alumno>{
	private String nLegajo;
	private float promGeneral;
	
	
	public Alumno(String apellido, String nombre, String dni, String direccion, String telefono, String fNacimiento, String nLegajo, float promGeneral) {
		super(apellido,nombre,dni,direccion,telefono,fNacimiento);
		this.setnLegajo(nLegajo);
		this.setPromGeneral(promGeneral);
	}
	
	
	public Alumno(Alumno a) {
		this(a.getApellido(), a.getNombre(), a.getDni(),a.getDireccion(),a.getTelefono(),a.getfNacimiento(),a.getnLegajo(),a.getPromGeneral());
	}
	
	public Alumno() {
		this(null,null,null,null,null,null,null,0);
	}
	
	public int compare(Alumno a1, Alumno a2) {
		int i=0;
		if(a1.getPromGeneral()<a2.getPromGeneral()) i=1;
		if(a1.getPromGeneral()==a2.getPromGeneral()) i=0;
		if(a1.getPromGeneral()>a2.getPromGeneral()) i=-1;
		return i;
	}

	public String toString() {
		return "Apellido: "+this.getApellido()+"; Nombre: "+this.getNombre()+"; DNI: "+this.getDni()+"; Direccion: "+this.getDireccion()+"; Telefono: "+this.getTelefono()+"; Fecha de Nacimiento: "+this.getfNacimiento()+"; Numero de Legajo: "+this.getnLegajo()+"; Promedio General: "+this.getPromGeneral();
	}

	
	public String getnLegajo() {
		return nLegajo;
	}
	public void setnLegajo(String nLegajo) {
		this.nLegajo = nLegajo;
	}

	
	public float getPromGeneral() {
		return promGeneral;
	}
	public void setPromGeneral(float promGeneral) {
		this.promGeneral = promGeneral;
	}

}
