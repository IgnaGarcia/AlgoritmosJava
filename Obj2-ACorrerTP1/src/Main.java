
import java.util.*;


public class Main {

	public static void main(String[] args) {
		ArrayList<Categoria> lCategoriasF=new ArrayList<Categoria>();
		ArrayList<Categoria> lCategoriasM=new ArrayList<Categoria>();
		HashMap<Integer, Competidor> lCompetidores=new HashMap<Integer, Competidor>();
		miArchivero archivero=new miArchivero();
		long TInicio,TFin;
		
		TInicio = System.currentTimeMillis();
		//archivero.escribirArchivoStressTest();
		//archivero.escribirArchivoIn();
		TFin = System.currentTimeMillis();
		System.out.println("Tiempo de escritura: "+(TFin-TInicio));
		
		TInicio = System.currentTimeMillis();
		archivero.leerArchivo(lCategoriasF, lCategoriasM, lCompetidores);
		
		archivero.escribirArchivo(lCategoriasF,lCategoriasM);	
		TFin = System.currentTimeMillis();
		System.out.println("Tiempo de ejecucion: "+(TFin-TInicio));
	}
}