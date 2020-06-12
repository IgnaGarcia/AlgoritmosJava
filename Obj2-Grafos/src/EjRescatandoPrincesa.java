import java.util.ArrayList;

public class EjRescatandoPrincesa {
	private int nodoPrincipe;
	private int nodoPrincesa;
	private ArrayList<Integer> nodosDragon;
	
	private String camino(GrafoNoDirigido mapa) {
		String solucion="";
		Camino rescate=new Camino();
		Nodo aux=null;
		Arco auxi=null;
		ArrayList<Integer> nodosTomados=new ArrayList<Integer>();
		
		if(mapa.getListaNodos().get(this.getNodoPrincesa()).getListaAdyacentes().isEmpty()){
			solucion="No hay camino";
		}
		else{
			nodosTomados.addAll(this.getNodosDragon());//marco como tomados los nodos de dragones
			nodosTomados.add(this.getNodoPrincipe());//marco como tomado el nodo inicial
			
			rescate.getListaNodosTomados().add(mapa.getListaNodos().get(this.getNodoPrincipe()));
			
			for(int i=0; i<mapa.getCantidadDeNodos(); i++){//para todos los nodos enlistados
				for(Nodo n: rescate.getListaNodosTomados()){//para los nodos tomados
					auxi=null;
					aux=null;
					for(Adyacente ad: n.getListaAdyacentes()){	//para cada adyacente del nodo
						if(!nodosTomados.contains(ad.getNodo().getIndice()) &&  (auxi==null || ad.getArco().getCosto()<auxi.getCosto())){
							auxi=new Arco(ad.getArco().getCosto(), ad.getArco().getNodo1(), ad.getArco().getNodo2());
							aux=new Nodo(ad.getNodo());
						}
					}
				}
				if(aux!=null && auxi!=null){//agrega los nodos y arcos tomados
					rescate.getListaNodosTomados().add(aux);
					nodosTomados.add(aux.getIndice());
					rescate.getListaArcosTomados().add(auxi);
					
					/*ArrayList<Integer> nodosNuevos=new ArrayList<Integer>();
					ArrayList<Integer> nodosViejos=new ArrayList<Integer>();
					
					for(int j=0;j<this.getNodosDragon().size();j++){//el dragon avanza o no 
						Nodo avanceDragon=new Nodo(mapa.getListaNodos().get(this.getNodosDragon().get(j)));
						
						for(Adyacente ad: avanceDragon.getListaAdyacentes()){
							if(Math.random()*10>=7){
								if(auxi.getCosto()<=ad.getArco().getCosto()){
									nodosTomados.add(ad.getNodo().getIndice());
									nodosNuevos.add(ad.getNodo().getIndice());
									nodosViejos.add(avanceDragon.getIndice());
									break;
								}
							}
						}
					}
					this.getNodosDragon().removeAll(nodosViejos);
					this.getNodosDragon().addAll(nodosNuevos);//cambio los nodos dragon*/
				}
			}
			if(rescate.getListaNodosTomados().contains(mapa.getListaNodos().get(this.getNodoPrincesa()))){
				for(Nodo n: rescate.getListaNodosTomados()) solucion=""+n.getIndice();
			}
			else solucion="Interceptado";
		}
		System.out.println(rescate.getListaNodosTomados());
		return solucion;
	}
	
	public EjRescatandoPrincesa(){
		this.setNodoPrincesa(0);
		this.setNodoPrincipe(0);
		ArrayList<Integer> aux= new ArrayList<Integer>();
		this.setNodosDragon(aux);
	}
	public int getNodoPrincipe() {
		return nodoPrincipe;
	}
	public void setNodoPrincipe(int nodoPrincipe) {
		this.nodoPrincipe = nodoPrincipe;
	}
	public int getNodoPrincesa() {
		return nodoPrincesa;
	}
	public void setNodoPrincesa(int nodoPrincesa) {
		this.nodoPrincesa = nodoPrincesa;
	}
	public ArrayList<Integer> getNodosDragon() {
		return nodosDragon;
	}
	public void setNodosDragon(ArrayList<Integer> nodosDragon) {
		this.nodosDragon = nodosDragon;
	}
	
	public static void main(String[] args){
		EjRescatandoPrincesa aux= new EjRescatandoPrincesa();
		Archivero miArchivero=new Archivero();
		
		GrafoNoDirigido mapa=new GrafoNoDirigido(miArchivero.leerArchivoPrincesa(aux));

		miArchivero.escribirArchivoPrincesa(aux.camino(mapa));
	}
}
