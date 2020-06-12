public class Adscripto extends Alumno implements Remunerados{
	private int materias;
	private float sueldoBasico;
	private float sueldoBruto;
	
	public Adscripto(String apellido, String nombre, String dni, String direccion, String telefono, String fNacimiento, String nLegajo, float promGeneral, int materias, float sBasico) {
		super(apellido,nombre,dni,direccion,telefono,fNacimiento,nLegajo,promGeneral);
		this.setMaterias(materias);
		this.setSueldoBasico(sBasico);
		this.calcularSBruto();
	}
	
	
	public Adscripto() {
		this(null,null,null,null,null,null,null,0,0,0);
	}

	
	public int compare(Adscripto a1, Adscripto a2) {
		int i=0;
		if(a1.getSueldoBruto()<a2.getSueldoBruto()) i=1;
		if(a1.getSueldoBruto()==a2.getSueldoBruto()) i=0;
		if(a1.getSueldoBruto()>a2.getSueldoBruto()) i=-1;
		return i;
	}
	

	
	public void calcularSBruto() {
		if(this.getMaterias()<4) this.setSueldoBruto(this.getSueldoBasico()*this.getMaterias());
		else this.setSueldoBruto(0.0f);
	}
	
	
	public String toString() {
		return "Apellido: "+this.getApellido()+"; Nombre: "+this.getNombre()+"; DNI: "+this.getDni()+"; Direccion: "+this.getDireccion()+"; Telefono: "+this.getTelefono()+"; Fecha de Nacimiento: "+this.getfNacimiento()+"; Numero de Legajo: "+this.getnLegajo()+"; Promedio General: "+this.getPromGeneral()+"; Materias como adscripto: "+this.getMaterias()+"; Sueldo Basico: "+this.getSueldoBasico()+"; Sueldo Bruto: "+this.getSueldoBruto();
	}


	public float getSueldoBruto() {
		return sueldoBruto;
	}
	public void setSueldoBruto(float sueldoBruto) {
		this.sueldoBruto = sueldoBruto;
	}

	
	public float getSueldoBasico() {
		return sueldoBasico;
	}
	public void setSueldoBasico(float sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}

	
	public int getMaterias() {
		return materias;
	}
	public void setMaterias(int materias) {
		this.materias = materias;
	}
}
