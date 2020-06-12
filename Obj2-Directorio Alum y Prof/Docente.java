import java.util.Comparator;

public class Docente extends Persona implements Remunerados, Comparator<Docente>{
	private String cuil;
	private int antiguedad;
	private float sueldoBasico;
	private float sueldoBruto;
	
	
	public Docente(String apellido, String nombre, String dni, String direccion, String telefono, String fNacimiento, String cuil, int ant, float sbasico) {
		super(apellido,nombre,dni,direccion,telefono,fNacimiento);
		this.setCuil(cuil);
		this.setAntiguedad(ant);
		this.setSueldoBasico(sbasico);
		this.calcularSBruto();
	}
	
	

	public Docente() {
		this(null,null,null,null,null,null,null,0,0);
	}


	public int compare(Docente d1, Docente d2) {
		int i=0;
		if(d1.getSueldoBruto()<d2.getSueldoBruto()) i=1;
		if(d1.getSueldoBruto()==d2.getSueldoBruto()) i=0;
		if(d1.getSueldoBruto()>d2.getSueldoBruto()) i=-1;
		return i;
	}
	
	
	public void calcularSBruto() {
			if(this.getAntiguedad()<11) this.setSueldoBruto(this.getSueldoBasico()+((this.getSueldoBasico()*10)/100));
			else if(this.getAntiguedad()<16) this.setSueldoBruto(this.getSueldoBasico()+((this.getSueldoBasico()*15)/100));
			else if(this.getAntiguedad()<21) this.setSueldoBruto(this.getSueldoBasico()+((this.getSueldoBasico()*20)/100));
			else if(this.getAntiguedad()>20) this.setSueldoBruto(this.getSueldoBasico()+((this.getSueldoBasico()*25)/100));
	}
	
	
	public String toString() {
		return "Apellido: "+this.getApellido()+"; Nombre: "+this.getNombre()+"; DNI: "+this.getDni()+"; Direccion: "+this.getDireccion()+"; Telefono: "+this.getTelefono()+"; Fecha de Nacimiento: "+this.getfNacimiento()+"; Cuil: "+this.getCuil()+"; Antiguedad: "+this.getAntiguedad()+"; Sueldo Basico: "+this.getSueldoBasico()+"; Sueldo Bruto: "+this.getSueldoBruto();
	}

	
	public String getCuil() {
		return cuil;
	}
	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	
	public int getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	
	public float getSueldoBasico() {
		return sueldoBasico;
	}
	public void setSueldoBasico(float sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}
	

	public float getSueldoBruto() {
		return sueldoBruto;
	}
	public void setSueldoBruto(float sueldoBruto) {
		this.sueldoBruto = sueldoBruto;
	}
}
