public class Main {

	public static void main(String[] args) {
		Tablero t=new Tablero();
		miArchivero archivero=new miArchivero();
		long TInicio,TFin;
		
		TInicio = System.currentTimeMillis();
		//archivero.escribirArchivoStressTest();	
		archivero.escribirArchivoIn();
		TFin = System.currentTimeMillis();
		System.out.println("Tiempo de escritura(mseg): "+(TFin-TInicio));
		
		TInicio = System.currentTimeMillis();		
		t=new Tablero(archivero.leerArchivo(t));
		
		for(int k=0; k<t.getPosiciones(); k++) {			
			for(int j=0; j<t.getPosiciones(); j++) {
				if(t.getPosicionReina()[k][j]!=null) t.getPosicionReina()[k][j].calcularConflicto(t);
			}
		}

		archivero.escribirArchivo(t);

		TFin = System.currentTimeMillis();
		System.out.println("Tiempo de ejecucion(mseg): "+(TFin-TInicio));
	}
}
