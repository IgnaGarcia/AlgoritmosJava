import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class RapigramaTest {
	/*Casos de prueba ya preparados y listos para ejecutar
	 * un bloque de sentencias para escribir el caso de prueba .in
	 * un bloque de sentencias para llevar a cabo el algoritmo(leer archivo, calcular, ordenar y escribir)
	 * un bloque de sentencias para leer el archivo .out y hacer las comparaciones de lo esperado y lo obtenido.
	 * Por ultimo un caso de prueba vacio por defecto para ser copiado, pegado y personalizado.
	 */
	@Test
	void test() {
		PrintWriter escribo=new PrintWriter(System.out);
		Scanner leo=new Scanner(System.in);
		Archivero archivero=new Archivero();
		Tablero t=new Tablero();
		Rapigrama r=new Rapigrama();
		Solucion aux=new Solucion();
		
//--------------------------------------------CASO 1-----------------------------------------------
		try{//Caso por defecto del programa
			escribo=new PrintWriter(new File("rapigrama.in"));
			escribo.println("8 4");
			escribo.println("xabcdflu");
			escribo.println("ntcertam");
			escribo.println("nnnabbnm");
			escribo.println("fffgnhom");
			escribo.println("vhtoiaio");
			escribo.println("thvivacc");
			escribo.println("ytuuebab");
			escribo.println("zxvylbnx");
			escribo.println("oia");
			escribo.println("certamen");
			escribo.println("nivel");
			escribo.println("nacional");
		}
		catch(Exception e){	
			System.out.println(e.getMessage());
		}
		finally{
			if(escribo!=null) escribo.close();
		}
		
		archivero.leerArchivo(t, r);
		r.calcularCoincidencias(t);
		Collections.sort(r.getlSoluciones(), aux);
		archivero.escribirArchivo(r);
		
		try {
			leo=new Scanner(new File("rapigrama.out"));
			assertEquals("1 E",leo.nextLine());
			assertEquals("1 O",leo.nextLine());//esta salida es agregada debido a que en el caso por defecto no esta y no restringe la escritura de tal
			assertEquals("3 S",leo.nextLine());
			assertEquals("4 N",leo.nextLine());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(leo!=null) leo.close();
		}					
		
//--------------------------------------------CASO 1-----------------------------------------------
		try{//Caso minimo, una palabra y una solucion
			escribo=new PrintWriter(new File("rapigrama.in"));
			escribo.println("2 1");
			escribo.println("ab");
			escribo.println("xz");
			escribo.println("ba");
		}
		catch(Exception e){	
			System.out.println(e.getMessage());
		}
		finally{
			if(escribo!=null) escribo.close();
		}
		
		archivero.leerArchivo(t, r);
		r.calcularCoincidencias(t);
		Collections.sort(r.getlSoluciones(), aux);
		archivero.escribirArchivo(r);
		
		try {
			leo=new Scanner(new File("rapigrama.out"));
			assertEquals("1 O",leo.nextLine());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(leo!=null) leo.close();
		}
		
//--------------------------------------------CASO 2-----------------------------------------------
		try{//Caso sin ninguna solucion
			escribo=new PrintWriter(new File("rapigrama.in"));
			escribo.println("3 3");
			escribo.println("xyb");
			escribo.println("mos");
			escribo.println("las");
			escribo.println("sol");
			escribo.println("ola");
			escribo.println("pez");
		}
		catch(Exception e){	
			System.out.println(e.getMessage());
		}
		finally{
			if(escribo!=null) escribo.close();
		}
		
		archivero.leerArchivo(t, r);
		r.calcularCoincidencias(t);
		Collections.sort(r.getlSoluciones(), aux);
		archivero.escribirArchivo(r);
		
		try {
			leo=new Scanner(new File("rapigrama.out"));
			assertEquals(" ",leo.nextLine());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(leo!=null) leo.close();
		}
		
//--------------------------------------------CASO 3-----------------------------------------------
		try{//Caso que encuentra las 4 palabras, cada una en una direccion diferente
			escribo=new PrintWriter(new File("rapigrama.in"));
			escribo.println("4 4");
			escribo.println("acav");
			escribo.println("lrzh");
			escribo.println("oune");
			escribo.println("hzde");
			escribo.println("hola");
			escribo.println("oun");
			escribo.println("vaca");
			escribo.println("cruz"); 
		}
		catch(Exception e){	
			System.out.println(e.getMessage());
		}
		finally{
			if(escribo!=null) escribo.close();
		}
				
		archivero.leerArchivo(t, r);
		r.calcularCoincidencias(t);
		Collections.sort(r.getlSoluciones(), aux);
		archivero.escribirArchivo(r);
				
		try {
			leo=new Scanner(new File("rapigrama.out"));
			assertEquals("1 N",leo.nextLine());
			assertEquals("2 E",leo.nextLine());
			assertEquals("3 O",leo.nextLine());
			assertEquals("4 S",leo.nextLine());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(leo!=null) leo.close();
		}
	
//--------------------------------------------CASO 4-----------------------------------------------
		try{//Caso con palabra capicua y tablero capicua
			escribo=new PrintWriter(new File("rapigrama.in"));
			escribo.println("3 1");
			escribo.println("oso");
			escribo.println("sos");
			escribo.println("oso");
			escribo.println("oso");
		}
		catch(Exception e){	
			System.out.println(e.getMessage());
		}
		finally{
			if(escribo!=null) escribo.close();
		}
				
		archivero.leerArchivo(t, r);
		r.calcularCoincidencias(t);
		Collections.sort(r.getlSoluciones(), aux);
		archivero.escribirArchivo(r);
				
		try {
			leo=new Scanner(new File("rapigrama.out"));
			assertEquals("1 S",leo.nextLine());
			assertEquals("1 E",leo.nextLine());
			assertEquals("1 S",leo.nextLine());
			assertEquals("1 O",leo.nextLine());
			assertEquals("1 N",leo.nextLine());
			assertEquals("1 E",leo.nextLine());
			assertEquals("1 N",leo.nextLine());
			assertEquals("1 O",leo.nextLine());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(leo!=null) leo.close();
		}

//--------------------------------------------CASO 5-----------------------------------------------
		try{//Caso que en la misma inicial hay dos palabras
			escribo=new PrintWriter(new File("rapigrama.in"));
			escribo.println("5 2");
			escribo.println("holas");
			escribo.println("fsani");
			escribo.println("fnjsa");
			escribo.println("kjolk");
			escribo.println("saloh");
			escribo.println("hola");
			escribo.println("holas");
		}
		catch(Exception e){	
			System.out.println(e.getMessage());
		}
		finally{
			if(escribo!=null) escribo.close();
		}
				
		archivero.leerArchivo(t, r);
		r.calcularCoincidencias(t);
		Collections.sort(r.getlSoluciones(), aux);
		archivero.escribirArchivo(r);
				
		try {
			leo=new Scanner(new File("rapigrama.out"));
			assertEquals("1 E",leo.nextLine());
			assertEquals("1 O",leo.nextLine());
			assertEquals("2 E",leo.nextLine());
			assertEquals("2 O",leo.nextLine());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(leo!=null) leo.close();
		}
		
//--------------------------------------------CASO 5-----------------------------------------------
		/*try{Caso a personalizar, quite los "/*............../*" y rellene los println y assert 
			escribo=new PrintWriter(new File("rapigrama.in"));
			escribo.println("");
			escribo.println("");
			escribo.println("");
			escribo.println("");
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
				
		archivero.leerArchivo(t, r);
		r.calcularCoincidencias(t);
		Collections.sort(r.getlSoluciones(), aux);
		archivero.escribirArchivo(r);
				
		try {
			leo=new Scanner(new File("rapigrama.out"));
			assertEquals("",leo.nextLine());
			assertEquals("",leo.nextLine());
			assertEquals("",leo.nextLine());
			assertEquals("",leo.nextLine());
			assertEquals("",leo.nextLine());
			assertEquals("",leo.nextLine());
			assertEquals("",leo.nextLine());
			assertEquals("",leo.nextLine());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(leo!=null) leo.close();
		}*/			
	}
}


