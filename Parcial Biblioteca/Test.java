import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		int autorC=0, libroC=0, revistaC=0;
		String[] publicacion=new String[6], autor=new String[4];
		
		Autor[] a=new Autor[4];
		Publicacion[] l= new Publicacion[10];
		
		PrintWriter p=null;	
		Scanner s=new Scanner(System.in);
		Scanner s1=new Scanner(System.in);
		
		try{
			p=new PrintWriter(new File("biblioteca.out"));
			s=new Scanner(new File("biblioteca.in"));
			s1=new Scanner(new File("autores.in"));
			
			autorC=s1.nextInt();
			s1.nextLine();
			
			for(int i=0; i<autorC; i++){
				autor=s1.nextLine().split(" ");
				a[i]=new Autor(autor[1], autor[2], autor[3]);
			}
			
			libroC=s.nextInt();
			s.nextLine();
			
			for(int i=0; i<libroC; i++){
				publicacion=s.nextLine().split(" ");
				l[i]=new Libro(Integer.parseInt(publicacion[4])-1,publicacion[3],Integer.parseInt(publicacion[2]),Dewey.Descripcion(publicacion[1]),esPrestado(publicacion[5]));
			}
		
			revistaC=s.nextInt();
			s.nextLine();

			for(int i=0; i<revistaC; i++){
				publicacion=s.nextLine().split(" ");
				l[i+libroC]=new Revista(Integer.parseInt(publicacion[4])-1,publicacion[3],Integer.parseInt(publicacion[2]),Integer.parseInt(publicacion[1]),publicacion[0],esPrestado(publicacion[5]));
			}
			
			p.println(revistaC+libroC);

			for(int i=0; i<(libroC+revistaC); i++){
				p.println(i+" "+l[i].getTitulo()+" "+a[l[i].getAutor()].getNombre()+" "+a[l[i].getAutor()].getApellido()+" "+l[i].isPrestado());
			}
		}
		catch(Exception e){	
			System.out.println(e.getMessage());
		}
		finally{
			if(s!=null) s.close();
			if(s1!=null) s.close();
			if(p!=null) p.close();
		}
	}

	private static boolean esPrestado(String x) {
		int n=Integer.parseInt(x);
		if(n==1)return true;
		else return false;
	}
}
