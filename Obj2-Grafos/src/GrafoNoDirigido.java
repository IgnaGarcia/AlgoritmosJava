import java.util.ArrayList;
import java.util.PriorityQueue;

public class GrafoNoDirigido extends Grafo{
	private Camino prim;
	private Camino kruskal;

	public GrafoNoDirigido(int[][] matriz){
		this.setMatrizAdyacencia(matriz);
		this.calcListaDeNodos();
		this.calcListaDeArcos();
		this.setCantidadDeNodos(this.getListaNodos().size());
	}

	public void calcPrim(){
		Camino cPrim=new Camino();
		this.setPrim(cPrim);
		Adyacente adMin=new Adyacente();
		Nodo aux;
		ArrayList<Integer> indicesTachados=new ArrayList<Integer>();
		
		this.getPrim().getListaNodosTomados().add(this.getListaNodos().get(0)); //agarro primer nodo
		indicesTachados.add(0);
		
		for(int j=0; j<this.getListaNodos().size(); j++){//para todo nodo enlistado
			Integer auxMin=Integer.MAX_VALUE;
			
			for(int k=0; k<this.getPrim().getListaNodosTomados().size(); k++) {//para todo nodo del camino generado
				aux= new Nodo(this.getPrim().getListaNodosTomados().get(k));//guardo el nodo tomado
				
				for(int i=0; i<aux.getListaAdyacentes().size(); i++){ //busco su menor adyacente
					
					if(aux.getListaAdyacentes().get(i).getArco().getCosto()<auxMin && !indicesTachados.contains(aux.getListaAdyacentes().get(i).getNodo().getIndice())) {
						//si es menor y no provoca ciclo
							auxMin=aux.getListaAdyacentes().get(i).getArco().getCosto();// guardar como aux
							adMin=new Adyacente(aux.getListaAdyacentes().get(i).getNodo(),aux.getListaAdyacentes().get(i).getArco());
					}	
				}
			}
			if(!indicesTachados.contains(adMin.getNodo().getIndice())){
				indicesTachados.add(adMin.getNodo().getIndice());
				this.getPrim().setCosto(this.getPrim().getCosto()+adMin.getArco().getCosto());
				this.getPrim().getListaArcosTomados().add(adMin.getArco());//agregar al camino
				this.getPrim().getListaNodosTomados().add(adMin.getNodo());	
			}	
		}	
	}
	
	public void calcKruskal(){
		Camino cKruskal=new Camino();
		PriorityQueue<Arco> colaArcos=new PriorityQueue<Arco>(this.getListaArcos());
		this.setKruskal(cKruskal);
		Arco arcoAux;
		ArrayList<ArrayList<Integer>> subArboles=new ArrayList<ArrayList<Integer>>();
		
		for(int j=0; j<this.getListaNodos().size(); j++){//para todo nodo enlistado
			arcoAux = colaArcos.remove();// se desencola y se guarda en auxiliar
			if(!this.hayCiclo(subArboles,arcoAux)) {//controla que no se hagan ciclos
				this.getKruskal().setCosto(this.getKruskal().getCosto()+arcoAux.getCosto());
				this.getKruskal().getListaArcosTomados().add(arcoAux);//se guardan los datos en el camino
				
				if(!this.getKruskal().getListaNodosTomados().contains(arcoAux.getNodo1())) this.getKruskal().getListaNodosTomados().add(arcoAux.getNodo1());
				if(!this.getKruskal().getListaNodosTomados().contains(arcoAux.getNodo2())) this.getKruskal().getListaNodosTomados().add(arcoAux.getNodo2());
				
				boolean condicion=false;
				if(!subArboles.isEmpty()) {
					for(ArrayList<Integer> c: subArboles) {
						if(c.contains(arcoAux.getNodo1().getIndice()) || c.contains(arcoAux.getNodo2().getIndice())) {
							if(c.contains(arcoAux.getNodo1().getIndice())) c.add(arcoAux.getNodo2().getIndice());//compruebo si hay un sub arbol al cual
							if(c.contains(arcoAux.getNodo2().getIndice())) c.add(arcoAux.getNodo1().getIndice());//se le tenga que sumar un nodo
							
							condicion=true;
							break;
						}
						else condicion=false;
					}
				}
				if(!condicion) {
					ArrayList<Integer> aux= new ArrayList<Integer>();//creo sub arboles para controlar los ciclos
					aux.add(arcoAux.getNodo1().getIndice());
					aux.add(arcoAux.getNodo2().getIndice());
					
					subArboles.add(aux);
				}
			}
		}	
	}
	
	public void calcDijkstra(int inicial){	
		ArrayList<Integer> distancias=new ArrayList<Integer>(this.getCantidadDeNodos());
		ArrayList<Arco> arcoMin=new ArrayList<Arco>(this.getCantidadDeNodos());
		
		ArrayList<Integer> indicesTachados=new ArrayList<Integer>(this.getCantidadDeNodos());
		Camino dijkstra=new Camino();
		this.setDijkstra(dijkstra);
		Nodo auxiliar=new Nodo(this.getListaNodos().get(inicial));

		for(int i=0;i<this.getCantidadDeNodos();i++) {//Cargar vector de distancias
			if(i==inicial) {
				distancias.add(0);
				arcoMin.add(null);
			}
			else {
				distancias.add(Integer.MAX_VALUE);
				arcoMin.add(null);
			}
		}
		this.getDijkstra().getListaNodosTomados().add(auxiliar);//Cargarlo en el camino
		
		for(int j=0; j<this.getListaNodos().size(); j++){//para todo nodo enlistado
			ArrayList<Nodo> indicesNuevos=new ArrayList<Nodo>();
			
			for(Nodo nodo:this.getDijkstra().getListaNodosTomados()) {//para todo nodo del camino generado	
				if(!indicesTachados.contains(nodo.getIndice())) {//siempre que el nodo no haya sido calculado antes
					for(Adyacente ad: nodo.getListaAdyacentes()) {	//para cada adyacente
						if(distancias.get(ad.getNodo().getIndice())>ad.getArco().getCosto()+distancias.get(nodo.getIndice())) {
							//comparo si el camino ofrecido es menor al establecido
							distancias.set(ad.getNodo().getIndice(), ad.getArco().getCosto()+distancias.get(nodo.getIndice()));	
							arcoMin.set(ad.getNodo().getIndice(), ad.getArco());
							if(!this.getDijkstra().getListaNodosTomados().contains(ad.getNodo()))indicesNuevos.add(ad.getNodo());
						}
					}
					indicesTachados.add(nodo.getIndice());
				}
			}
			this.getDijkstra().getListaNodosTomados().addAll(indicesNuevos);
		}	
		this.getDijkstra().getListaArcosTomados().addAll(arcoMin);
		System.out.println("\nCosto minimo a cada nodo: "+distancias);
	}
	
	public boolean hayCiclo(ArrayList<ArrayList<Integer>> subArboles, Arco arcoAux) {
		boolean condicional=false;
		for(ArrayList<Integer> c: subArboles) {
			if(c.contains(arcoAux.getNodo1().getIndice()) && c.contains(arcoAux.getNodo2().getIndice())) {//compruebo que ambos nodos no 
				condicional=true;																		//pertenezcan a un mismo subarbol
				break;
			}
		}
		return condicional;
	}
	
	public void calcListaDeArcos() {
		Arco a;
		Adyacente ad;
		ArrayList<Arco> al=new ArrayList<Arco>();
		this.setListaArcos(al);
		int indice=0;
		
		for(int i=0; i<this.getMatrizAdyacencia().length;i++){
			for(int j=0; j<this.getMatrizAdyacencia().length;j++){		
				if(this.getMatrizAdyacencia()[i][j]!=0) {
					a=new Arco(this.getMatrizAdyacencia()[i][j], this.getListaNodos().get(i), this.getListaNodos().get(j));
					a.setIndice(indice);
					this.getListaArcos().add(a);
					
					ad=new Adyacente(this.getListaNodos().get(j), a);
					this.getListaNodos().get(i).getListaAdyacentes().add(ad);
					
					indice++;
				}	
			}
		}
	}
	
	public void colorearGrafo() {
		ArrayList<Integer> coloresAd;
		
		for(Nodo n1: this.getListaNodos()){
			if(n1.getIndice()==0) n1.setColor(1);
			else{
				coloresAd=new ArrayList<Integer>();
				
				for(Adyacente ad1: n1.getListaAdyacentes()){
					coloresAd.add(ad1.getNodo().getColor());
				}
				
				boolean condicion=true;
				int i=1;
				while(condicion){
					if(coloresAd.contains(i)) i++;
					else{
						n1.setColor(i);
						condicion=false;
					}
				}
			}
		}	
		
		for(Nodo n: this.getListaNodos()){
			for(Adyacente a: n.getListaAdyacentes()){
				if(n.getColor()==a.getNodo().getColor()) {
					System.out.println("Mal Coloreado");
					break;
				}
			}
		}
	}

	public String toString() {
		return "Nodos: "+this.getListaNodos()+" ; Arcos: "+this.getListaArcos();
	}
	
	public Camino getPrim() {
		return prim;
	}
	public void setPrim(Camino prim) {
		this.prim = prim;
	}
	public Camino getKruskal() {
		return kruskal;
	}
	public void setKruskal(Camino kruskal) {
		this.kruskal = kruskal;
	}
}
