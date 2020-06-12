import java.util.ArrayList;
import java.util.PriorityQueue;

public class EjMetro {
	public static int pseudoKruskal(GrafoNoDirigido metro) {
		Camino cKruskal=new Camino();
		PriorityQueue<Arco> colaArcos=new PriorityQueue<Arco>(metro.getListaArcos());
		metro.setKruskal(cKruskal);
		Arco arcoAux;
		ArrayList<ArrayList<Integer>> subArboles=new ArrayList<ArrayList<Integer>>();

		int minPuentes=0;
		
		for(int j=0; j<metro.getListaNodos().size(); j++){//para todo nodo enlistado
			arcoAux = colaArcos.remove();// se desencola y se guarda en auxiliar
			if(!metro.hayCiclo(subArboles,arcoAux)) {//controla que no se hagan ciclos
				metro.getKruskal().setCosto(metro.getKruskal().getCosto()+arcoAux.getCosto());
				metro.getKruskal().getListaArcosTomados().add(arcoAux);//se guardan los datos en el camino
				
				if(!metro.getKruskal().getListaNodosTomados().contains(arcoAux.getNodo1())) metro.getKruskal().getListaNodosTomados().add(arcoAux.getNodo1());
				if(!metro.getKruskal().getListaNodosTomados().contains(arcoAux.getNodo2())) metro.getKruskal().getListaNodosTomados().add(arcoAux.getNodo2());
				
				if(arcoAux.getCosto()==10) minPuentes++;//acumulo cantidad de puentes
				
				boolean condicion=false;
				if(!subArboles.isEmpty()) {
					for(ArrayList<Integer> c: subArboles) {
						if(c.contains(arcoAux.getNodo1().getIndice()) || c.contains(arcoAux.getNodo2().getIndice())) {//compruebo si hay un sub arbol al cual
							if(c.contains(arcoAux.getNodo1().getIndice())) c.add(arcoAux.getNodo2().getIndice());//se le tenga que sumar un nodo
							if(c.contains(arcoAux.getNodo2().getIndice())) c.add(arcoAux.getNodo1().getIndice());
							
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
		return minPuentes;
	}
	
	public static void main(String[] args) {
		Archivero gestor= new Archivero();
		GrafoNoDirigido metro=new GrafoNoDirigido(gestor.leerArchivoMetro());
		
		gestor.escribirArchivoMetro(pseudoKruskal(metro));
	}
}
