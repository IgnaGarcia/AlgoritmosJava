public class Main {
	public static void main(String[] args) {
		
		int[][] matrizDeAdy=new int[6][6];
		
		matrizDeAdy[0][0]=0;
		matrizDeAdy[0][1]=1;
		matrizDeAdy[0][2]=0;
		matrizDeAdy[0][3]=0;
		matrizDeAdy[0][4]=0;
		matrizDeAdy[0][5]=1;
		
		matrizDeAdy[1][0]=0;
		matrizDeAdy[1][1]=0;
		matrizDeAdy[1][2]=0;
		matrizDeAdy[1][3]=2;
		matrizDeAdy[1][4]=2;
		matrizDeAdy[1][5]=2;
		
		matrizDeAdy[2][0]=0;
		matrizDeAdy[2][1]=0;
		matrizDeAdy[2][2]=0;
		matrizDeAdy[2][3]=4;
		matrizDeAdy[2][4]=0;
		matrizDeAdy[2][5]=3;
		
		matrizDeAdy[3][0]=0;
		matrizDeAdy[3][1]=0;
		matrizDeAdy[3][2]=0;
		matrizDeAdy[3][3]=0;
		matrizDeAdy[3][4]=3;
		matrizDeAdy[3][5]=0;
		
		matrizDeAdy[4][0]=0;
		matrizDeAdy[4][1]=0;
		matrizDeAdy[4][2]=0;
		matrizDeAdy[4][3]=0;
		matrizDeAdy[4][4]=0;
		matrizDeAdy[4][5]=0;
		
		matrizDeAdy[5][0]=0;
		matrizDeAdy[5][1]=0;
		matrizDeAdy[5][2]=0;
		matrizDeAdy[5][3]=0;
		matrizDeAdy[5][4]=0;
		matrizDeAdy[5][5]=0;
		
		/*matrizDeAdy[0][0]=0;
		matrizDeAdy[0][1]=1;
		matrizDeAdy[0][2]=10;
		matrizDeAdy[0][3]=0;
		matrizDeAdy[0][4]=0;
		matrizDeAdy[0][5]=0;
		
		matrizDeAdy[1][0]=1;
		matrizDeAdy[1][1]=0;
		matrizDeAdy[1][2]=1;
		matrizDeAdy[1][3]=0;
		matrizDeAdy[1][4]=0;
		matrizDeAdy[1][5]=0;
		
		matrizDeAdy[2][0]=0;
		matrizDeAdy[2][1]=0;
		matrizDeAdy[2][2]=0;
		matrizDeAdy[2][3]=10;
		matrizDeAdy[2][4]=0;
		matrizDeAdy[2][5]=0;
		
		matrizDeAdy[3][0]=0;
		matrizDeAdy[3][1]=0;
		matrizDeAdy[3][2]=0;
		matrizDeAdy[3][3]=0;
		matrizDeAdy[3][4]=1;
		matrizDeAdy[3][5]=10;
		
		matrizDeAdy[4][0]=0;
		matrizDeAdy[4][1]=0;
		matrizDeAdy[4][2]=0;
		matrizDeAdy[4][3]=0;
		matrizDeAdy[4][4]=0;
		matrizDeAdy[4][5]=10;
		
		matrizDeAdy[5][0]=0;
		matrizDeAdy[5][1]=0;
		matrizDeAdy[5][2]=0;
		matrizDeAdy[5][3]=0;
		matrizDeAdy[5][4]=0;
		matrizDeAdy[5][5]=0;*/
		
		GrafoNoDirigido probar=new GrafoNoDirigido(matrizDeAdy);
		
		/*probar.calcPrim();
		
		System.out.println("\nCamino de Prim: "+probar.getPrim());
		
		probar.calcKruskal();
		
		System.out.println("\nCamino de Kruskal: "+probar.getKruskal());
		
		probar.calcDijkstra(0);
		
		System.out.println("\nCamino de Dijkstra: "+probar.getDijkstra());
		
		GrafoDirigido probar1=new GrafoDirigido(matrizDeAdy);
		
		probar1.calcDijkstra(1);
		
		System.out.println("\nCamino de Dijkstra en dirigido: "+probar1.getDijkstra());*/
		
		probar.colorearGrafo();
		
		System.out.println(probar);
		
		for(Nodo n: probar.getListaNodos()){
			System.out.println("Nodo: "+n.getIndice()+" Color: "+n.getColor());
		}
	}

}
