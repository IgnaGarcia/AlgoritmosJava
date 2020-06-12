import static org.junit.Assert.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;


public class EjTarzanTest {

	@Test
	public void test() {
		PrintWriter escribo=new PrintWriter(System.out);
		Scanner leo=new Scanner(System.in);
		Archivero archivero=new Archivero();
		GrafoNoDirigido g=null;
		EjTarzan ejecutor=new EjTarzan();
		ArrayList<int[]> puntos=null;
		
//--------------------------------------------CASO 0-----------------------------------------------
		try{//Caso por defecto del programa
			escribo=new PrintWriter(new File("tarzan.in"));
			escribo.println("0 0");
			escribo.println("-20 -30");
			escribo.println("-50 0");
			escribo.println("-30 30");
			escribo.println("40 0");
			escribo.println("80 0");
			escribo.println("120 0");
			escribo.println("160 0");
			escribo.println("40 30");
			escribo.println("90 30");
			escribo.println("60 50");
			escribo.println("120 70");
			escribo.println("160 50");
			escribo.println("40 80");
			escribo.println("160 100");
		}
		catch(Exception e){	
			System.out.println(e.getMessage());
		}
		finally{
			if(escribo!=null) escribo.close();
		}
		
		puntos= new ArrayList<int[]>(archivero.leerArchivoTarzan()); 
		g=new GrafoNoDirigido(ejecutor.cargarMatriz(puntos));
		archivero.escribirArchivoTarzan(ejecutor.obtenerSalida(ejecutor.pseudoDijkstra(g.getListaNodos().get(0).getIndice(), g),puntos));

		
		try {
			leo=new Scanner(new File("tarzan.out"));
			assertEquals("0 0",leo.nextLine());
			assertEquals("40 0",leo.nextLine());
			assertEquals("90 30",leo.nextLine());
			assertEquals("120 70",leo.nextLine());
			assertEquals("160 100",leo.nextLine());
		}
		catch(Exception e){	
			System.out.println(e.getMessage());
		}
		finally{
			if(leo!=null) leo.close();
		}					
		
//--------------------------------------------CASO 1-----------------------------------------------
		try{//Caso NO HAY RUTA
			escribo=new PrintWriter(new File("tarzan.in"));
			escribo.println("0 0");
			escribo.println("50 50");
			escribo.println("100 100");
			escribo.println("200 200");
		}
		catch(Exception e){	
			System.out.println(e.getMessage());
		}
		finally{
			if(escribo!=null) escribo.close();
		}
		
		puntos= new ArrayList<int[]>(archivero.leerArchivoTarzan()); 
		g=new GrafoNoDirigido(ejecutor.cargarMatriz(puntos));
		archivero.escribirArchivoTarzan(ejecutor.obtenerSalida(ejecutor.pseudoDijkstra(g.getListaNodos().get(0).getIndice(), g),puntos));
		
		try {
			leo=new Scanner(new File("tarzan.out"));
			assertEquals("NO HAY RUTA",leo.nextLine());
		}
		catch(Exception e){	
			System.out.println(e.getMessage());
		}
		finally{
			if(leo!=null) leo.close();
		}
	}
}
