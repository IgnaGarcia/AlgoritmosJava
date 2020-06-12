package montañaComoTP1;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		ArrayList<Obstaculo> lObstaculos=new ArrayList<Obstaculo>();
		miArchivero archivero=new miArchivero();
		long TInicio, TFin;
		
		TInicio = System.currentTimeMillis();
		archivero.escribirArchivoStressTest();	
		//archivero.escribirArchivoIn();
		TFin = System.currentTimeMillis();
		System.out.println("Tiempo de escritura(mseg): "+(TFin-TInicio));
		
		
		TInicio = System.currentTimeMillis();
		Carrito c=new Carrito(archivero.leerArchivo(lObstaculos));
		c.hacerRecorrido(lObstaculos);
		archivero.escrivoArchivo(c);
		TFin = System.currentTimeMillis();
		System.out.println("Tiempo de ejecucion(mseg): "+(TFin-TInicio));
	}
}
