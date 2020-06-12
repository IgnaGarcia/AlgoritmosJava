import java.util.ArrayList;


public class GrafoDirigido extends Grafo {
	
	public GrafoDirigido(int[][] matriz){
		this.setMatrizAdyacencia(matriz);
		this.calcListaDeNodos();
		this.calcListaDeArcos();
		this.setCantidadDeNodos(this.getListaNodos().size());
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
						if(distancias.get(ad.getNodo().getIndice())>ad.getArco().getCosto()+distancias.get(nodo.getIndice())) {//comparo si el camino ofrecido es menor al establecido
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

	public void calcListaDeArcos() {
		Arco a;
		ArrayList<Arco> al=new ArrayList<Arco>();
		Adyacente ad;
		
		this.setListaArcos(al);
		
		for(int i=0; i<this.getMatrizAdyacencia().length;i++){
			for(int j=0; j<this.getMatrizAdyacencia().length;j++){
				if(this.getMatrizAdyacencia()[i][j]!=0){
					a=new Arco(this.getMatrizAdyacencia()[i][j], this.getListaNodos().get(i), this.getListaNodos().get(j), 1);
					
					ad=new Adyacente(this.getListaNodos().get(j), a);
					this.getListaNodos().get(i).getListaAdyacentes().add(ad);
					
					this.getListaArcos().add(a);
				}
			}
		}
	}

	public String toString() {
		return "Nodos: "+this.getListaNodos()+" ; Arcos: "+this.getListaArcos();
	}
}
