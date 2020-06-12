package montañaComoTP1;

import java.io.*;
import java.util.*;

public class miArchivero {
	
	
	public long leerArchivo(ArrayList<Obstaculo> lObstaculos) {
		Scanner leo=new Scanner(System.in);
		long obstaculos=0, posicionInicial=0;
		
		try {
			leo=new Scanner(new File("como.txt"));
			
			obstaculos=leo.nextLong();//Leo cantidad de obstaculos
			for(long i=0;i<obstaculos;i++) {
				leo.nextLine();
				Obstaculo obs=new Obstaculo(leo.nextLong());
				lObstaculos.add(obs); //Cargo los obstaculos en lista
			}
			
			leo.nextLine();
			posicionInicial=leo.nextLong(); //Leo y Cargo la posicion inicial del carro
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(leo!=null) leo.close();
		}
		
		return posicionInicial;
	}
	
	public void escrivoArchivo(Carrito c) {
		PrintWriter escribo=new PrintWriter(System.out);
		try {		
			escribo=new PrintWriter(new File("como.out"));

			escribo.println(c.getxRecorrida()+" "+c.getyFinal()); //Descargo el acumulador del carrito y la posicion final
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(escribo!=null) escribo.close();
		}
	}
	
	public  void escribirArchivoIn() {
		PrintWriter escribo=new PrintWriter(System.out);
		
		try{
			escribo=new PrintWriter(new File("como.txt"));

			escribo.println("5");
			escribo.println("40");
			escribo.println("10");
			escribo.println("20");
			escribo.println("5");
			escribo.println("70");
			escribo.println("0");
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
			escribo=new PrintWriter(new File("como.txt"));
			
			escribo.println("2000000");
			for(long i=1; i<=2000000; i++) {
				if(i%2==0) escribo.println((long)(Math.random()*1000000));
				else  escribo.println((long)(Math.random()*1000000)+1000000);
			}
			escribo.println(10);
		}
		catch(Exception e){	
			System.out.println(e.getMessage());
		}
		finally{
			if(escribo!=null) escribo.close();
		}
		
	}
	
}
