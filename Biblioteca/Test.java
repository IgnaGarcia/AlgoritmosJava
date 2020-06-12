package Biblioteca;

public class Test {
	public static void main(String[] args) {
		
		Libro[] vector = new Libro[6];
		
		vector[0]=new Libro("41664614", "Luna de Pluton", 2014);
		//System.out.println(vector[0].estaPrestado());
		vector[0].prestar();
		/*System.out.println(vector[0].toString());
		vector[0].devolver();
		System.out.println(vector[0].toString());*/
		
		vector[1]=new Libro("41662314", "Pluton", 2011);
		
		vector[2]=new Libro("41664618", "Luna de Pluton", 2012);
		
		vector[3]=new Libro("41664618", "Luna de Pluton", 2012);
		
		vector[4]=new Libro("41664614", "Luna de Pluton", 2014);
		vector[4].prestar();
		
		vector[5]=new Libro("41664614", "Luna de Pluton", 2014);
		vector[5].prestar();
		
		/*Publicacion r=new Revista("40899804", "Espejito", 2017, 15);
		System.out.println(r.toString());
		
		Publicacion a=new ArtAcadem("40429924", "Manual de Java", 1997, "DeJean");
		System.out.println(a.toString());*/
		
		Publicacion[] vectorP= new Publicacion[3];
		
		vectorP[0]=new ArtAcadem("40429924", "Manual de Java", 1997, "DeJean");
		
		vectorP[1]=new Revista("40899804", "Espejito", 2017, 15);
		
		vectorP[2]=new Libro("41664614", "Luna de Pluton", 2015);
		
		
		System.out.println(Contar.contarPrestados(vector));
		System.out.println(Contar.publicacionesAnteriores(vectorP, 2015));
	}
}
