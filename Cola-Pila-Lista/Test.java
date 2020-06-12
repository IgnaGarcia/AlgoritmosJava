public class Test {
	public static void main(String[] args) {
		
		/*Lista<String> l=new Lista<String>();
		
		Nodo<String> n=new Nodo<String>("Lucas");
		Nodo<String> n2=new Nodo<String>("Nacho");
		Nodo<String> n3=new Nodo<String>("Mati");
		Nodo<String> n4=new Nodo<String>("Alex");
		Nodo<String> n5=new Nodo<String>("Juan");
		
		l.insertarInicio(n);
		l.insertarInicio(n2);
		l.insertarInicio(n3);
		l.insertarInicio(n4);
		l.insertarInicio(n5);
		System.out.println("ELIMINAR");
		l.eliminarFinal();
		l.eliminarFinal();
		l.eliminarFinal();
		l.eliminarFinal();
		l.eliminarFinal();
		l.eliminarFinal();
		l.eliminarFinal();
		l.eliminarFinal();
		l.eliminarFinal();
		System.out.println("FIN");
		
		PilaDinamica<String> p=new PilaDinamica<String>();
		p.apilar("Hola");
		p.apilar("Soy");
		p.apilar("Nacho");
		p.apilar("Todo");
		p.apilar("Esta");
		p.apilar("Mal");
		System.out.println(p.cima());
		System.out.println("ELIMINAR");
		System.out.println(p.esVacia());
		p.desapilar();
		p.desapilar();
		p.desapilar();
		p.desapilar();
		p.vaciar();
		p.desapilar();
		System.out.println("ELIMININADO");
		System.out.println(p.esVacia());
		System.out.println("FIN");*/
		
		ColaDinamica<String> c=new ColaDinamica<String>();
		c.encolar("Hola");
		c.encolar("La");
		c.encolar("Cola");
		c.encolar("Esta");
		c.encolar("Bien");
		System.out.println(c.primero());
		System.out.println("ELIMINAR");
		System.out.println(c.esVacia());
		c.desencolar();
		c.desencolar();
		c.desencolar();
		c.vaciar();
		c.desencolar();
		System.out.println("ELIMININADO");
		System.out.println(c.esVacia());
		System.out.println("FIN");
		
		
	}
}