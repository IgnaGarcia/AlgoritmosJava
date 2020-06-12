import java.util.ArrayList;
import java.util.Stack;

public class EjTarzan {
		
	public Arco[] pseudoDijkstra(int inicial, Grafo g){	
		ArrayList<Integer> distancias=new ArrayList<Integer>(g.getCantidadDeNodos());
		Arco[] arcoMin=new Arco[g.getCantidadDeNodos()];
		
		ArrayList<Integer> indicesTachados=new ArrayList<Integer>(g.getCantidadDeNodos());
		Camino dijkstra=new Camino();
		g.setDijkstra(dijkstra);
		Nodo auxiliar=new Nodo(g.getListaNodos().get(inicial));

		for(int i=0;i<g.getCantidadDeNodos();i++) {//Cargar vector de distancias
			if(i==inicial) {
				distancias.add(0);
				arcoMin[i]=null;
			}
			else {
				distancias.add(Integer.MAX_VALUE);
				arcoMin[i]=null;
			}
		}
		g.getDijkstra().getListaNodosTomados().add(auxiliar);//Cargarlo en el camino
		
		for(int j=0; j<g.getListaNodos().size(); j++){//para todo nodo enlistado
			ArrayList<Nodo> indicesNuevos=new ArrayList<Nodo>();
			
			for(Nodo nodo:g.getDijkstra().getListaNodosTomados()) {//para todo nodo del camino generado	
				if(!indicesTachados.contains(nodo.getIndice()) && nodo.getIndice()!=g.getCantidadDeNodos()-1) {//siempre que el nodo no haya sido calculado antes
					
					for(Adyacente ad: nodo.getListaAdyacentes()) {	//para cada adyacente
						if(distancias.get(ad.getNodo().getIndice())>Math.abs(ad.getArco().getCosto()-distancias.get(nodo.getIndice()))) {
							//comparo si el camino ofrecido es menor al establecido
							
							if(ad.getArco().getNodo1().getIndice()==nodo.getIndice()) {
								distancias.set(ad.getNodo().getIndice(), ad.getArco().getCosto()+distancias.get(nodo.getIndice()));	
								arcoMin[ad.getNodo().getIndice()]=ad.getArco();//se carga el nuevo camino
								if(!g.getDijkstra().getListaNodosTomados().contains(ad.getNodo()))indicesNuevos.add(ad.getNodo());
								//se guarda para calcular los adyacentes de este nuevo punto
							}	
						}
					}
					indicesTachados.add(nodo.getIndice());
				}
			}
			g.getDijkstra().getListaNodosTomados().addAll(indicesNuevos);
		}
		return arcoMin;	
	}
	
	public Stack<String> obtenerSalida(Arco[] arcoMin, ArrayList<int[]> puntos) {// se calculan los puntos tomados desde el final hasta el principal, apilandolos
		boolean condicion=true;
		int nodoABuscar= puntos.size()-1;
		Stack<String> salida=new Stack<String>();
		
		if(arcoMin[nodoABuscar]!=null) {// siempre que se haya encontrado un arco que llegue al nodo final
			salida.push(puntos.get(nodoABuscar)[0]+" "+puntos.get(nodoABuscar)[1]);// se apila el punto final
			while(condicion){
				nodoABuscar=arcoMin[nodoABuscar].getNodo1().getIndice();//se obtiene el nodo que conecta con el nodo anterior
				salida.push(puntos.get(nodoABuscar)[0]+" "+puntos.get(nodoABuscar)[1]);//se apila el punto que conecta con el punto anterior
				if(nodoABuscar==0) condicion=false; // si el punto es el inicial rompe el ciclo
			}
		}
		else salida.clear();// se vacia la pila si no se encontro camino, asi despues escribe que NO HAY RUTA
		return salida;
	}
	
	public int[][] cargarMatriz(ArrayList<int[]> puntos) {
		int i=0,j;
		int[][] matrizAd=null;
		matrizAd=new int[puntos.size()][puntos.size()];
		//matriz del tamanio de los futuros nodos
		for(int[] a: puntos) {
			j=0;
			for(int[] b: puntos) {
				if(!(a[0]==b[0] && a[1]==b[1])) {
					// si no es el mismo punto 	
					if(Math.abs(a[0]-b[0])<=50 && Math.abs(a[1]-b[1])<=50) {
						// si la diferencia entre puntos en ambos planos sea entre -50 y 50
						if(Math.abs(puntos.get(puntos.size()-1)[0]-b[0])+Math.abs(puntos.get(puntos.size()-1)[1]-b[1])<Math.abs(puntos.get(puntos.size()-1)[0]-a[0])+Math.abs(puntos.get(puntos.size()-1)[1]-a[1])) {
							//si el nodo al que voy me acerca al nodo final. Math abs para calculara a partir del modulo y no del numero
							matrizAd[i][j]=(a[0]-b[0])+(a[1]-b[1])+1;
							//cargo la distancia entre el nodo al que voy y el nodo final
						}	
					}
				}j++;	
			}i++;
		}return matrizAd;
	}
	
	public static void main(String[] args) {
		EjTarzan ejecutor=new EjTarzan();
		Archivero miArchivero=new Archivero();
		long TInicio,TFin;
		
		TInicio = System.currentTimeMillis();
		//Se toma el tiempo
		
		miArchivero.escribirArchivoTarzanIn();
		//carga para estres test
		
		ArrayList<int[]> puntos= new ArrayList<int[]>(miArchivero.leerArchivoTarzan()); 
		// lee el archivo y carga el retorno en una lista

		GrafoNoDirigido g=new GrafoNoDirigido(ejecutor.cargarMatriz(puntos));
		// crea el crafo cargando una matriz de adyacencias
	

		miArchivero.escribirArchivoTarzan(ejecutor.obtenerSalida(ejecutor.pseudoDijkstra(g.getListaNodos().get(0).getIndice(), g),puntos));
		// manda a escribir el archivo con el recorrido calculado
		
		TFin = System.currentTimeMillis();
		System.out.println("Tiempo de ejecucion(mseg): "+(TFin-TInicio));
		// y se muestra el tiempo del algoritmo
	}
}
