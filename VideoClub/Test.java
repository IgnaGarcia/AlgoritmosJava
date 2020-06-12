package VideoClub;

public class Test {
	
	public static int ContarSerie(Serie[] s){
		int Entregados=0;
		
		for(int i=0;i<s.length;i++){
			if(s[i].estaEntregado()) Entregados++;	
		}
		return Entregados;
	}
	
	public static int ContarVJ(VideoJuego[] v){
		int Entregados=0;
		
		for(int i=0;i<v.length;i++){
			if(v[i].estaEntregado()) Entregados++;	
		}
		return Entregados;
	}
	
	public static void main(String[] args) {
		
		Serie[] s=new Serie[5];
		s[0]=new Serie();
		s[1]=new Serie();
		s[1].entregar();
		
		s[2]=new Serie();
		s[3]=new Serie();
		s[3].entregar();
		
		s[4]=new Serie();
		
		System.out.println(ContarSerie(s));
		
		for(int i=0;i<s.length;i++){
			s[i].devolver();
		}
		
		System.out.println(ContarSerie(s));
				
		VideoJuego[] v=new VideoJuego[5];
		v[0]=new VideoJuego();
		v[0].entregar();
		
		v[1]=new VideoJuego();
		v[2]=new VideoJuego();
		v[3]=new VideoJuego();
		v[3].entregar();
		
		v[4]=new VideoJuego();
		v[4].entregar();
		
		System.out.println(ContarVJ(v));
		
		for(int i=0;i<v.length;i++){
			v[i].devolver();
		}
		System.out.println(ContarVJ(v));
		
	}
}
