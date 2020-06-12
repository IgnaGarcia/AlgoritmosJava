import java.util.*;


public class MainTest {

	public static void main(String[] args) {	
		
		Alumno a1=new Alumno("zz", "bbb", "111", "444", "123", "30/12/1998", "2013", 3.8f);
		//System.out.println(a1.toString());
		
		Adscripto ad1=new Adscripto("dd", "aba", "222", "333", "321", "10/10/1998", "2014", 4.0f, 2, 1000.0f);
		//System.out.println(ad1.toString());
		Adscripto ad2=new Adscripto("aa", "ccd", "222", "333", "321", "10/10/1998", "2014", 5.0f, 1, 5000.0f);
		Adscripto ad3=new Adscripto("aa", "ccc", "222", "333", "321", "10/10/1998", "2014", 5.0f, 3, 5000.0f);
		Adscripto ad4=new Adscripto("bb", "bba", "222", "333", "321", "10/10/1998", "2014", 9.0f, 0, 5000.0f);
		Adscripto ad5=new Adscripto("bb", "aab", "222", "333", "321", "10/10/1998", "2014", 6.0f, 4, 5000.0f);
		Adscripto ad6=new Adscripto("aa", "ccc", "222", "333", "321", "10/10/1998", "2014", 3.5f, 10, 5000.0f);
		Adscripto ad7=new Adscripto("yy", "ddd", "222", "333", "321", "10/10/1998", "2014", 1.0f, 2, 5000.0f);

		
		Docente d1=new Docente("yy", "jjj", "777", "666", "789", "1/1/1998","205154",21,8000.0f);
		//System.out.println(d1.toString());
		Docente d2=new Docente("hh", "kkk", "777", "666", "789", "1/1/1998","205154",10,5000.0f);
		Docente d3=new Docente("hh", "lll", "777", "666", "789", "1/1/1998","205154",11,5000.0f);
		Docente d4=new Docente("uu", "uuu", "777", "666", "789", "1/1/1998","205154",15,5000.0f);
		Docente d5=new Docente("oo", "iii", "777", "666", "789", "1/1/1998","205154",16,5000.0f);
		Docente d6=new Docente("pp", "jjj", "777", "666", "789", "1/1/1998","205154",20,5000.0f);
		Docente d7=new Docente("pp", "xxx", "777", "666", "789", "1/1/1998","205154",21,5000.0f);
		Docente d8=new Docente("ww", "jjj", "777", "666", "789", "1/1/1998","205154",31,5000.0f);
		Docente d9=new Docente("ee", "jjj", "777", "666", "789", "1/1/1998","205154",1,5000.0f);
		
		
		ArrayList <Alumno> lProm=new ArrayList<Alumno>();
		lProm.add(a1);
		lProm.add(ad1);
		lProm.add(ad2);
		lProm.add(ad3);
		lProm.add(ad4);
		lProm.add(ad5);
		lProm.add(ad6);
		lProm.add(ad7);
		
		ordenarAlums(lProm);
		
		
		ArrayList <Docente> lSueldoD=new ArrayList<Docente>();
		lSueldoD.add(d1);
		lSueldoD.add(d2);
		lSueldoD.add(d3);
		lSueldoD.add(d4);
		lSueldoD.add(d5);
		lSueldoD.add(d6);
		lSueldoD.add(d7);
		lSueldoD.add(d8);
		lSueldoD.add(d9);
		
		ArrayList <Adscripto> lSueldoA=new ArrayList<Adscripto>();
		lSueldoA.add(ad1);
		lSueldoA.add(ad2);
		lSueldoA.add(ad3);
		lSueldoA.add(ad4);
		lSueldoA.add(ad5);
		lSueldoA.add(ad6);
		lSueldoA.add(ad7);		
		
		ordenarRemuns(lSueldoA,lSueldoD);
		
		
		ArrayList <Persona> lApel=new ArrayList<Persona>();
		lApel.add(a1);
		lApel.add(ad1);
		lApel.add(ad2);
		lApel.add(ad3);
		lApel.add(ad4);
		lApel.add(ad5);
		lApel.add(ad6);
		lApel.add(ad7);
		lApel.add(d1);
		lApel.add(d2);
		lApel.add(d3);
		lApel.add(d4);
		lApel.add(d5);
		lApel.add(d6);
		lApel.add(d7);
		lApel.add(d8);
		lApel.add(d9);
		
		
		ordenarApel(lApel);
	}

	private static void ordenarApel(ArrayList<Persona> lApel) {
		System.out.println("----------DESORDENADA----------");
		showList(lApel, 2);
		
		Collections.sort(lApel);
		
		System.out.println("----------ORDENADA----------");
		showList(lApel, 2);	
	}

	private static void ordenarRemuns(ArrayList<Adscripto> lSueldoA, ArrayList<Docente> lSueldoD) {
		System.out.println("----------DESORDENADA----------");
		System.out.println("--DOCENTES--");
		showList(lSueldoD, 1);
		System.out.println("--ADSCRIPTOS--");
		showList(lSueldoA, 1);
		
		Docente dOrdenador=new Docente();
		Collections.sort(lSueldoD, dOrdenador);
		
		Adscripto aOrdenador=new Adscripto();
		Collections.sort(lSueldoA, aOrdenador);	
		
		System.out.println("----------ORDENADA----------");
		System.out.println("--DOCENTES--");
		showList(lSueldoD, 1);
		System.out.println("--ADSCRIPTOS--");
		showList(lSueldoA, 1);
		
	}

	private static void ordenarAlums(ArrayList<Alumno> lProm) {
		System.out.println("----------DESORDENADA----------");
		showList(lProm, 0);
		
		Alumno alOrdenador=new Alumno();
		Collections.sort(lProm, alOrdenador);
		
		System.out.println("----------ORDENADA----------");
		showList(lProm, 0);		
	}

	public static void showList(ArrayList p, int x) {
		for(int i=0;i<p.size();i++) {
            if(x==0)System.out.println(((Alumno) p.get(i)).getPromGeneral());
            else if(x==1) {
            	Adscripto a=new Adscripto();
            	Docente d=new Docente();
            	if(p.get(i).getClass()==a.getClass()) System.out.println(((Adscripto) p.get(i)).getSueldoBruto());
            	if(p.get(i).getClass()==d.getClass())System.out.println(((Docente) p.get(i)).getSueldoBruto());
            }
            else if(x==2)System.out.println(((Persona) p.get(i)).getApellido()+" "+((Persona) p.get(i)).getNombre());
            else System.out.println(p.get(i));
        }
	}
}
	
