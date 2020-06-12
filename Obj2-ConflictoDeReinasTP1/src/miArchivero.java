import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class miArchivero {
	
	public Tablero leerArchivo(Tablero t) {
		Scanner leo=new Scanner(System.in);
		Reina[][] lReinas;
		try{
			leo=new Scanner(new File("reinas.in"));
			t=new Tablero(leo.nextInt(), leo.nextInt());
			lReinas=new Reina[t.getPosiciones()][t.getPosiciones()];
			leo.nextLine();	

			for(int i=0; i<t.getCantReinas();i++) {
				ArrayList<Conflicto> lConflictos=new ArrayList<Conflicto>();
				Reina r=new Reina(leo.nextInt()-1,leo.nextInt()-1,(i+1), lConflictos);
				lReinas[r.getFila()][r.getColumna()]=r;
			}	
			t.setPosicionReina(lReinas);
			
			return t;
		}
		catch(Exception e){	
			System.out.println(e.getMessage());
		}
		finally{
			if(leo!=null) leo.close();
		}
		return t;
	}
	
	public void escribirArchivo(Tablero t) {
		PrintWriter escribo=new PrintWriter(System.out);
		
		try{
			escribo=new PrintWriter(new File("reinas.out"));
			
			for(int k=0; k<t.getPosiciones(); k++) {
				for(int j=0; j<t.getPosiciones(); j++) {
					
					if(t.getPosicionReina()[k][j]!=null) {
						
						String linea=""+t.getPosicionReina()[k][j].getlConflictos().size();// escribo cantidad de conflictos de la reina 
						
						Conflicto cAux=new Conflicto();
						Collections.sort(t.getPosicionReina()[k][j].getlConflictos(), cAux);//Ordeno la lista de conflictos de reina menor a mayor
						for(Conflicto c: t.getPosicionReina()[k][j].getlConflictos()) {//la recorro y guardo el numero de reina conflictiva
							linea+=" "+c.getConflictiva2().getnReina();
						}
						escribo.println(linea);//escribo 
					}
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
	
	public  void escribirArchivoIn() {
		PrintWriter escribo=new PrintWriter(System.out);
		
		try{
			escribo=new PrintWriter(new File("reinas.in"));
			
			escribo.println("8 8");
			escribo.println("1 7");
			escribo.println("2 2");
			escribo.println("3 4");
			escribo.println("4 1");
			escribo.println("4 4");
			escribo.println("4 6");
			escribo.println("5 3");
			escribo.println("8 8");
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
			escribo=new PrintWriter(new File("reinas.in"));
			escribo.println("10000 20000");
			for(long i=0; i<=2; i++) {
				for(long j=0; j<10000; j++) {
					escribo.println(i+" "+j);
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