package Biblioteca;

public class Contar {
	
	public static int contarPrestados(Libro[] vector){
		
		int librosPrestados=0;
		
		for(int i=0;i<vector.length;i++){
			if(vector[i].estaPrestado()) librosPrestados++;	
		}
		return librosPrestados;
	}
	
	public static int publicacionesAnteriores(Publicacion[] vectorP, int año){
		
		int publicacionAnterior=0;
		
		for(int i=0;i<vectorP.length;i++){
			if(vectorP[i].getAñoP()<año) publicacionAnterior++;
		}
		return publicacionAnterior;
	}
}
