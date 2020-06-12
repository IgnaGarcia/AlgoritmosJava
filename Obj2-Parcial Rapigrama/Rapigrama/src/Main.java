import java.util.Collections;

public class Main {
	public static void main(String[] args) {
		Tablero t=new Tablero();
		Rapigrama r=new Rapigrama();
		Archivero archiver=new Archivero();
		long TInicio,TFin;
		
		TInicio = System.currentTimeMillis();//Se toma el tiempo	
		
		archiver.leerArchivo(t, r);//manda a leer

		r.calcularCoincidencias(t);//algoritmo principal

		Solucion aux=new Solucion();
		Collections.sort(r.getlSoluciones(), aux);//manda a ordenar
		
		archiver.escribirArchivo(r);//manda a escribir

		TFin = System.currentTimeMillis();
		System.out.println("Tiempo de ejecucion(mseg): "+(TFin-TInicio));// y se muestra el tiempo del algoritmo
	}
}
