import java.util.*;


public class Main {

	public static void main(String[] args) {
		miArchivero archivero= new miArchivero();
		ArrayList<Colaborador> lColab=new ArrayList<Colaborador>();
		ArrayList<Afinidad> lAfinidad=new ArrayList<Afinidad>();
		Afinidad af1=new Afinidad();
		long TInicio,TFin;
		
		TInicio = System.currentTimeMillis();
		//archivero.escribirArchivoStressTest();
		//archivero.escribirArchivoIn();
		TFin = System.currentTimeMillis();
		System.out.println("Tiempo de escritura(mseg): "+(TFin-TInicio));
		
		
		TInicio = System.currentTimeMillis();
		archivero.leerArchivo(lColab);//llamado a leer archivo, obtengo lista 
		
		Collections.sort(lColab);//ordeno la lista alfabeticamente
	
		for(Colaborador c: lColab){//comparar cada colaborador con cada colaborador
			c.buscarAfinidad(lColab,lAfinidad);
		}
		
		
		
		Collections.sort(lAfinidad, af1);//ordenar la lista a partir de la maxima afinidad
		
		archivero.escribirArchivo(lAfinidad);//llamado a escribir archivo
		
		TFin = System.currentTimeMillis();
		System.out.println("Tiempo de escritura(mseg): "+(TFin-TInicio));
	}
}