import java.util.*;
import java.io.*;

public class miArchivero {
	
	public void leerArchivo(ArrayList<Colaborador> lColab){//leer el archivo
		Scanner leer=new Scanner(System.in);
		int preguntas=0;
		try {
			leer=new Scanner(new File("equipo.in"));
			
			preguntas = leer.nextInt();
			leer.nextLine();//salto de linea
			
			int colaboradores= leer.nextInt();
			leer.nextLine();//salto de linea
			
			for(int i=0; i<colaboradores;i++){//se lee y llena la lista de colaboradores, cada uno con su respuesta y n de colaborador
				Colaborador c=new Colaborador(leer.nextLine(), i+1);
				lColab.add(c);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(leer!=null) leer.close();
		}
	}
	
	public void escribirArchivo(ArrayList<Afinidad> lAfinidad){//escribir el archivo
		PrintWriter escribir = null;
		try {
			escribir=new PrintWriter(new File("equipo.out"));
			if(lAfinidad.isEmpty())escribir.println(0+"\nnull");
			else {
				escribir.println(lAfinidad.get(0).getAfinidad());//escribir el maximo de afinidad obtenido
				escribir.println(lAfinidad.get(0).getCadena());//escribir la cadena de maxima afinidad
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(escribir!=null) escribir.close();
		}
	}
	
	public  void escribirArchivoIn() {
		PrintWriter escribo=new PrintWriter(System.out);
		
		try{
			escribo=new PrintWriter(new File("equipo.in"));
			
			escribo.println("4");
			escribo.println("4");
			escribo.println("abab");
			escribo.println("abac");
			escribo.println("abac");
			escribo.println("abab");
			escribo.println("");
			escribo.println("");
			escribo.println("");
			escribo.println("");
			
		}
		catch(Exception e){	
			System.out.println(e.getMessage());
		}
		finally{
			if(escribo!=null) escribo.close();
		}
	}
	
	public  void escribirArchivoStressTest() {
		PrintWriter escribo=new PrintWriter(System.out);
		
		try{
			escribo=new PrintWriter(new File("equipo.in"));
			escribo.println("500");
			escribo.println("5000");
			for(int i=0; i<5000; i++) {
				for(int j=0; j<500; j++) {
					escribo.print((char)((int)(Math.random()*(123-97)+97)));//convierto en caracter al entero que representa a las letras de la a-z excluyendo ñ
				}
				escribo.println();
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