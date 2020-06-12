import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Archivero {
	public int[][] leerArchivoMetro() {
		Scanner leo=new Scanner(System.in);
		int[][] matrizAd = new int[0][0];
		
		try{
			leo=new Scanner(new File("metro.in"));
			int nodos=leo.nextInt();
			int tuneles=leo.nextInt();
			int puentes=leo.nextInt();
			
			matrizAd=new int[nodos][nodos];
			leo.nextLine();	
			
			for(int i=0; i<tuneles;i++) {
				int nodo1=leo.nextInt();
				int nodo2=leo.nextInt();
				matrizAd[nodo1-1][nodo2-1]=1;//1 significa tunel
				leo.nextLine();
			}	
			
			for(int k=0; k<puentes;k++) {
				int nodo1=leo.nextInt();
				int nodo2=leo.nextInt();
				matrizAd[nodo1-1][nodo2-1]=10;//10 significa puente
				if(leo.hasNextLine())leo.nextLine();
			}	
		}catch(Exception e){	
			System.out.println(e.getMessage());
		}finally{
			if(leo!=null) leo.close();
		}return matrizAd;	
	}
	
	public void escribirArchivoMetro(int minPuentes) {
		PrintWriter escribo=new PrintWriter(System.out);
		
		try{
			escribo=new PrintWriter(new File("metro.out"));	
			
			escribo.print(minPuentes);

		}catch(Exception e){	
			System.out.println(e.getMessage());
		}finally{
			if(escribo!=null) escribo.close();
		}
	}

	public int[][] leerArchivoPrincesa(EjRescatandoPrincesa aux) {
		Scanner leo=new Scanner(System.in);
		int[][] matrizAd = new int[0][0];
		int nodos=0,dragones=0,arcos=0,nodo1,nodo2,distancia;
		
		try{
			leo=new Scanner(new File("std.in"));
			
			nodos=leo.nextInt();
			matrizAd=new int[nodos][nodos];
			arcos=leo.nextInt();
			dragones=leo.nextInt();
			
			leo.nextLine();
			
			aux.setNodoPrincesa(leo.nextInt()-1);
			aux.setNodoPrincipe(leo.nextInt()-1);
			
			leo.nextLine();
			
			for(int i=0; i<dragones; i++){
				aux.getNodosDragon().add(leo.nextInt()-1);
			}
			
			for(int j=0; j<arcos; j++){
				nodo1=leo.nextInt();
				nodo2=leo.nextInt();
				distancia=leo.nextInt();
				
				matrizAd[nodo1-1][nodo2-1]=distancia;
				matrizAd[nodo2-1][nodo1-1]=distancia;
				
				leo.nextLine();
			}
			
					
		}catch(Exception e){	
			System.out.println(e.getMessage());
		}finally{
			if(leo!=null) leo.close();
		}return matrizAd;	
	}
	
	public void escribirArchivoPrincesa(String solucion) {
		PrintWriter escribo=new PrintWriter(System.out);
		
		try{
			escribo=new PrintWriter(new File("std.out"));	
			
			escribo.println(solucion);
		}catch(Exception e){	
			System.out.println(e.getMessage());
		}finally{
			if(escribo!=null) escribo.close();
		}
	}
	
	public ArrayList<int[]> leerArchivoTarzan() {
		Scanner leo=new Scanner(System.in);
		ArrayList<int[]> puntos=new ArrayList<int[]>();
		int[]  punto=null;
		
		try{
			leo=new Scanner(new File("tarzan.in"));
			
			punto=new int[2];//se lee el nodo inicial
			punto[0]=leo.nextInt();
			punto[1]=leo.nextInt();	
			puntos.add(punto);//se agrega a la lista el nodo inicial
			
			for(int i=0; i<1000; i++) {//mientras siga habiendo lineas por leer
				if(leo.hasNextLine()) {
					punto=new int[2];//lee el nodo
					punto[0]=leo.nextInt();
					punto[1]=leo.nextInt();
					
					leo.nextLine();
					puntos.add(punto);// carga el nodo
				}
				else break;
			}
			
		}catch(Exception e){	
			System.out.println(e.getMessage());
		}finally{
			if(leo!=null) leo.close();
		}return puntos;
	}
	
	public void escribirArchivoTarzan(Stack<String> stack) {
		PrintWriter escribo=new PrintWriter(System.out);
		
		try{
			escribo=new PrintWriter(new File("tarzan.out"));	
			
			if(!stack.isEmpty()) {//si la lista no esta vacia
				while(!stack.isEmpty()){
					escribo.println(stack.pop());// escribo punto por punto que fueron tomados
				}
			}
			else escribo.println("NO HAY RUTA");
		}catch(Exception e){	
			System.out.println(e.getMessage());
		}finally{
			if(escribo!=null) escribo.close();
		}
	}
	
	public void escribirArchivoTarzanIn() {// escritura para estres test
		PrintWriter escribo=new PrintWriter(System.out);
		
		try{
			escribo=new PrintWriter(new File("tarzan.in"));	
				
			for(int i=0; i<1000; i++){
				int j=(int) (Math.random()*10);// elige opcion random para cargar el numero
				if(j>=0 && j<=3) escribo.println((int)(Math.random()*(500))+" "+(int)(Math.random()*(500)));// el numero sera entre -500 y 500
				else if(j>3 && j<=5) escribo.println((int)(Math.random()*(-500))+" "+(int)(Math.random()*(500)));// cambio tomado debido a que el grafo tendria 
				else if(j>5 && j<=7) escribo.println((int)(Math.random()*(500))+" "+(int)(Math.random()*(-500)));// distancias muy grandes y tarzan no puede volar
				else if(j>7 && j<=10) escribo.println((int)(Math.random()*(-500))+" "+(int)(Math.random()*(-500)));
			}
			
		}catch(Exception e){	
			System.out.println(e.getMessage());
		}finally{
			if(escribo!=null) escribo.close();
		}
	}
}
