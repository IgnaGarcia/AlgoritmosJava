import java.util.*;


public class Afinidad implements Comparator<Afinidad>{
	private int afinidad;
	private int colaboradores;
	private int preguntas;
	private String cadena;
	private ArrayList<Colaborador> lColaboradores;
	
	public Afinidad(int preguntas, String cadena, ArrayList<Colaborador> lColaboradores){
		this.setPreguntas(preguntas);
		this.setCadena(cadena);
		this.setlColaboradores(lColaboradores);
		this.setColaboradores(lColaboradores.size());
		this.calcularAfinidad();
	}
	
	public Afinidad(int preguntas, String cadena){
		this.setPreguntas(preguntas);
		this.setCadena(cadena);
	}
	
	public Afinidad(){
		this.setPreguntas(0);
		this.setCadena("");
	}
	
	public boolean equals(Afinidad af){
		if(this.getCadena().equals(af.getCadena())) return true;
		else return false;
	}
	
	public String toString() {
		return "\n[Preguntas igual: "+this.getPreguntas()+"; Cadena: "+this.getCadena()+"; Colaboradores: "+this.getColaboradores()+"; Afinidad: "+this.getAfinidad()+";]";
	}
	
	public void calcularAfinidad(){
		this.setAfinidad(this.getColaboradores()*(this.getPreguntas()*this.getPreguntas()));//colaboradores*(preguntas iguales^2)
	}
	
	public int comprobarAfinidades(ArrayList<Afinidad> lAfinidad, int preguntas, String respuesta2,Colaborador c1, Colaborador c2) {
		int compruebo=0;
		for(Afinidad af:lAfinidad) {
			if(af.getPreguntas()==preguntas && af.getCadena().equals(respuesta2)) {//en caso de que exista la afinidad se actualiza
				af.actualizarAfinidad(c1,c2);//agregandole colaboradores y rehaciendo el calculo de afinidad
				compruebo=1;
				break;
			}
			else compruebo=0;
		}
		return compruebo;
	}
	
	public void actualizarAfinidad(Colaborador c1, Colaborador c2) {
		if(!(this.getlColaboradores().contains(c2))) {//comprobar que no se dupliquen colaboradores
			this.getlColaboradores().add(c2);
			if(!(this.getlColaboradores().contains(c1)))this.getlColaboradores().add(c1);
		}
	}
	
	public void agregarPrimeraAfinidad(Colaborador c1,Colaborador c2, ArrayList<Afinidad> lAfinidad) {
		ArrayList<Colaborador> lColaboradores=new ArrayList<Colaborador>();	
		lColaboradores.add(c2);//Se agregan los colaboradores a la lista
		lColaboradores.add(c1);
		this.setlColaboradores(lColaboradores);// set lista de colaboradores
		lAfinidad.add(this);//se agrega a la lista	
	}
	
	public int compare(Afinidad af, Afinidad af1) {//metodo ordenador de afinidad mayor a menor
		int i=0;
		if(af.getAfinidad()<af1.getAfinidad()) i=1;
		if(af.getAfinidad()==af1.getAfinidad()) i=0;
		if(af.getAfinidad()>af1.getAfinidad()) i=-1;
		return i;
	}
	
	public int getAfinidad() {
		this.calcularAfinidad();
		return afinidad;
	}
	public void setAfinidad(int afinidad) {
		this.afinidad = afinidad;
	}
	public int getColaboradores() {
		return this.getlColaboradores().size();
	}
	public void setColaboradores(int colaboradores) {
		this.colaboradores = colaboradores;
	}
	public int getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(int preguntas) {
		this.preguntas = preguntas;
	}
	public String getCadena() {
		return cadena;
	}
	public void setCadena(String cadena) {
		this.cadena = cadena;
	}
	public ArrayList<Colaborador> getlColaboradores() {
		return lColaboradores;
	}
	public void setlColaboradores(ArrayList<Colaborador> lColaboradores) {
		this.lColaboradores = lColaboradores;
	}
}