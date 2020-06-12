public class Dewey {
	
	public static String Descripcion(String x){
	
		int identificador=Integer.parseInt(x);
		
		return Asignacion(identificador);
	}
	
	
	public static String Asignacion(int identificador){
		String Descripcion=null;
		
		switch(identificador){
			case 000:
				Descripcion=("Ciencias de CIT");
				break;
			case 500:
				Descripcion=("Ciencias Exactas");
				break;
			case 600:
				Descripcion=("Tecnologia");
				break;
			case 900:
				Descripcion=("Historia y Geografia");
				break;
		}
		return Descripcion;
	}
}