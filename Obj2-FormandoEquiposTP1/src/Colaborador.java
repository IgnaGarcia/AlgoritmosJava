import java.util.ArrayList;

public class Colaborador implements Comparable<Colaborador>{
	private String respuesta;
	private int nColab;

	public Colaborador(String respuesta, int nColab){
		this.setRespuesta(respuesta);
		this.setnColab(nColab);
	}
	
	public Colaborador(){
		this.setRespuesta(null);
		this.setnColab(0);
	}
	
	public boolean equals(Colaborador c){
		if(this.getnColab()==c.getnColab()) return true;
		else return false;
	}
	
	public void buscarAfinidad(ArrayList<Colaborador> lColab,ArrayList<Afinidad> lAfinidad) {
		for(Colaborador c2: lColab){
			if(!(this.equals(c2))){//siempre que no se trate del mismo objeto colaborador se compara
				this.compararRespuesta(c2, lAfinidad);
			}
		}
	}
	
	public void compararRespuesta(Colaborador c2,ArrayList<Afinidad> lAfinidad){
		int preguntas=0;
		String respuesta="";
		
		for(int i=0; i<this.getRespuesta().length();i++) {
			if(this.getRespuesta().charAt(i)==c2.getRespuesta().charAt(i)){
				respuesta+=this.getRespuesta().charAt(i);//corta la cadena cada ves una unidad mas, para asi buscar todas las afinidades posibles
				preguntas=respuesta.length();
			}
			else break;
		}
		
		
		if(preguntas>0) {//siempre que haya una afinidad
			if(lAfinidad.size()==0) {//siempre que sea la primera afinidad	
				Afinidad af1=new Afinidad(preguntas, respuesta); //nueva afinidad
				af1.agregarPrimeraAfinidad(this,c2,lAfinidad);//cargar lista a la afinidad
			}	
			else {	
				int compruebo=0;
				Afinidad af1=new Afinidad();
				compruebo=af1.comprobarAfinidades(lAfinidad,preguntas,respuesta,this, c2);	//comprobar que no exista la afinidad
					if(compruebo==0) {
						af1=new Afinidad(preguntas, respuesta); //nueva afinidad
						af1.agregarPrimeraAfinidad(this,c2,lAfinidad);//cargar lista a la afinidad
					}
				}			
			}
		}	

	public int compareTo(Colaborador c1) {
		return this.getRespuesta().compareTo(c1.getRespuesta());	
	}
	
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public int getnColab() {
		return nColab;
	}
	public void setnColab(int nColab) {
		this.nColab = nColab;
	}
}