import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Archivero {
	
	public void leerArchivo(Tablero t, Rapigrama r) {
		Scanner leo=new Scanner(System.in);
		int palabras=0;
		String palabra=null;
		ArrayList<String> lPalabras=new ArrayList<String>();
		ArrayList<Solucion> lSoluciones=new ArrayList<Solucion>();
		
		try{
			leo=new Scanner(new File("rapigrama.in"));	
			
			t.setTamanio(leo.nextInt());//se lee el tamanio y se asigna al Tablero
			palabras=leo.nextInt();//se lee la cantidad de palabras a buscar

			char[][] tabla=new char[t.getTamanio()][t.getTamanio()];//creacion del tablero
			
			leo.nextLine();
			for(int i=0;i<t.getTamanio();i++) {//for para leer las filas del tablero
				palabra=leo.nextLine();
				for(int j=0;j<palabra.length();j++) tabla[i][j]=palabra.charAt(j);	//for para leer elementos de la fila y asignar al tablero
			}
			t.setTablero(tabla);//se guarda en el Tablero			
			
			for(int k=0;k<palabras;k++)lPalabras.add(leo.nextLine());//for para leer y guardar las palabras a buscar
			r.setlPalabras(lPalabras);
			r.setlSoluciones(lSoluciones);//se asigna una lista vacia para evitar errores mas adelante
		}
		catch(Exception e){	
			System.out.println(e.getMessage());
		}
		finally{
			if(leo!=null) leo.close();
		}
	}
	
	public void escribirArchivo(Rapigrama r) {
		PrintWriter escribo=new PrintWriter(System.out);
		
		try{
			escribo=new PrintWriter(new File("rapigrama.out"));	

			if(r.getlSoluciones().isEmpty()) escribo.println(" ");//en caso de no haber encontrado soluciones se escribe un simple espacio
			else {
				for(Solucion solucion: r.getlSoluciones()) {//en caso de haber soluciones se recorre tal lista y se escribe y muestra por consola
					escribo.println(solucion.getNumeroDePalabra()+" "+solucion.getOrientacion());
					System.out.println(solucion.getNumeroDePalabra()+" "+solucion.getOrientacion());
				}
			}	
		}
		catch(Exception e){	
			System.out.println(e.getMessage());
		}
		finally{
			if(escribo!=null) escribo.close();
		}
	}
}
