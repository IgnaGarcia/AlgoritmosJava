import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class miArchivero {
	
	public void leerArchivo(ArrayList<Categoria> lCategoriasF, ArrayList<Categoria> lCategoriasM, HashMap<Integer, Competidor> lCompetidores) {
		Scanner leo=new Scanner(System.in);
		int corredores=0, catF=0, catM=0, corredoresLlegados=0;
		
		try{
			leo=new Scanner(new File("Carrera.in"));
			
			corredores=leo.nextInt();	
			catF=leo.nextInt();
			catM=leo.nextInt();
			corredoresLlegados=leo.nextInt();
		
			cargarCat(leo, lCategoriasF, lCategoriasM, catF, catM);//Leer y Cargar en lista de Categorias
			
			cargarCompet(leo,lCompetidores,corredores, lCategoriasF, lCategoriasM);//Leer y Cargar en lista de Competidores

			cargarCompetPosiciones(leo,lCategoriasF, lCategoriasM,corredoresLlegados,lCompetidores);//Leer el orden de llegada
		}
		catch(Exception e){	
			System.out.println(e.getMessage());
		}
		finally{
			if(leo!=null) leo.close();
		}
	}
	
	public void cargarCompetPosiciones(Scanner leo,ArrayList<Categoria> lCategoriasF,ArrayList<Categoria> lCategoriasM,int corredoresLlegados, HashMap<Integer, Competidor> lCompetidores) {
		int ncorredor=0;
		for(int i=0; i<corredoresLlegados;i++) {
			ncorredor=leo.nextInt();
			
			Competidor e=new Competidor(lCompetidores.get(ncorredor));//busca por numero de corredor, asigna posicion 
			e.setPosicion(i+1);
					
			if(e.getGenero()=='M'){			
				for(Categoria cat: lCategoriasM) {
					if(e.getCat().equals(cat) && cat.getGanador()<3) {
						cat.calcPodioM(e);
						break;
					}
				}	
			}
			else if(e.getGenero()=='F') {
				for(Categoria cat: lCategoriasF) {
					if(e.getCat().equals(cat) && cat.getGanador()<3) {
						cat.calcPodioF(e);
						break;
					}
				}
			}
		}
		leo.nextLine();	
	}

	public void cargarCompet(Scanner leo, HashMap<Integer, Competidor> lCompetidores, int corredores, ArrayList<Categoria> lCategoriasF, ArrayList<Categoria> lCategoriasM) {
		for(int i=0; i<corredores;i++) {
			Competidor auxi=new Competidor(leo.nextInt(),leo.nextLine().charAt(1),i+1);//Leer y cargar competidor(edad, genero, n de corredor
			auxi.calcCategoria(lCategoriasF,lCategoriasM);
			lCompetidores.put(auxi.getnCompetidor(), auxi);//Agregarlo a la lista
		}	
	}

	public void cargarCat(Scanner leo, ArrayList<Categoria> lCategoriasF,ArrayList<Categoria> lCategoriasM, int catF, int catM) {
		HashMap<Integer, Competidor> competidores;
		for(int i=0; i<catF;i++) {//Leer y Cargar categorias femeninas
			competidores=new HashMap<Integer, Competidor>();
			Categoria aux=new Categoria(i+1,leo.nextInt(),leo.nextInt(),'F',competidores);		
			lCategoriasF.add(aux);	
			leo.nextLine();
		}
		
		for(int i=0; i<catM;i++) {//Leer y Cargar categorias masculinas
			competidores=new HashMap<Integer, Competidor>();
			Categoria aux=new Categoria(i+1,leo.nextInt(),leo.nextInt(),'M',competidores);	
			lCategoriasM.add(aux);	
			leo.nextLine();
		}
	}
	
	public void escribirArchivo(ArrayList<Categoria> lCategoriasF , ArrayList<Categoria> lCategoriasM) {
		PrintWriter escribo=new PrintWriter(System.out);
		try{
			escribo=new PrintWriter(new File("Carrera.out"));
	
			for(Categoria c: lCategoriasF) {
				System.out.println(c.getGenero()+" fem");
				for(int i=c.getGanador(); i<3;i++) {
					c.setPodio(c.getPodio()+" 0"); //En caso de que no haya 3 ganadores se rellena con  0
					c.setGanador(c.getGanador()+1);
					System.out.println("femeninos: "+c.getPodio());
				}
				escribo.println(c.getPodio());		
			}
				
			for(Categoria c: lCategoriasM) {
				System.out.println(c.getGenero()+" masc");
				for(int i=c.getGanador(); i<3;i++) {
					c.setPodio(c.getPodio()+" 0"); //En caso de que no haya 3 ganadores se rellena con  0
					c.setGanador(c.getGanador()+1);
					System.out.println("masculinos: "+c.getPodio());
				}
				escribo.println(c.getPodio());	
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
			escribo=new PrintWriter(new File("Carrera.in"));
			
			escribo.println("10 1 1 6");
			escribo.println("10 80");
			escribo.println("10 80");
			escribo.println("15 F");
			escribo.println("16 F");
			escribo.println("17 F");
			escribo.println("25 M");
			escribo.println("23 M");
			escribo.println("24 M");
			escribo.println("25 M");
			escribo.println("23 M");
			escribo.println("24 M"); 
			escribo.println("17 F");
			escribo.println("3");
			escribo.println("1");
			escribo.println("10");
			escribo.println("4");
			escribo.println("9");
			escribo.println("7");
			
			
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
			escribo=new PrintWriter(new File("Carrera.in"));
			char gen='F';
			escribo.println("1000000 36 36 1000000");
			for(int j=0; j<2; j++) {
				for(int i=0; i<70; i+=2) {
					escribo.println((i+10)+" "+(i+11));
				}
				escribo.println("80 80");
			}
			
			for(int i=0; i<1000000;i++) {
				escribo.println((int)((Math.random()*70)+10)+" "+gen);
				if(i==500000) gen='M';
			}
			
			for(int i=0; i<1000000;i++) {
				escribo.println(i+1);
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