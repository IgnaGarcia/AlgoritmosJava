package montañaComoTP1;

import java.util.ArrayList;

public class Carrito {
	private long xInicial;
	private long xRecorrida;
	private long velocidad;
	private long yFinal;
	
	public Carrito(long xInicial) {
		this.setxInicial(xInicial);
		this.setxRecorrida(0);
		this.setVelocidad(0);
		this.setyFinal(0);
	}
	
	public Carrito() {
		this(0);
	}
	
	public void calcularVelocidad(long d) {
		this.setVelocidad(this.getVelocidad()+d);
	}
	
	public void recorrerX(long xRecorrida) {
		this.setxRecorrida(xRecorrida+this.getxRecorrida());
	}
	
	public void hacerRecorrido(ArrayList<Obstaculo> lObstaculos) {
		int j=0;
		long obsAnter=0;
		
		for(Obstaculo obsActual: lObstaculos) { //Avanzar por cada obstaculo
			if(j==0) { //Primer obstaculo
				obsAnter=obsActual.getxPosicion()-this.getxInicial(); // Calculo en que parte de la picada empiezo y guardo 
				j++;
			}
			else if(j%2==0) {
				j++;
				obsAnter=this.recorrerCima(obsAnter,obsActual); //Obstaculos cima
			}

			else {
				j++;
				obsAnter=this.recorrerValle(obsAnter,obsActual);//Obstaculos valle
			}
		}
	}
	
	public long recorrerCima(long obsAnter, Obstaculo obsActual) {
		if(this.getVelocidad()<obsActual.getxPosicion()-obsAnter) { //Verificar si no puede llegar a la cima
			this.recorrerX(this.getVelocidad()); //Aumentar acumulador de X
			this.setyFinal(this.getVelocidad()+obsAnter); //Avanzar dependiendo la velocidad
		}
		else { 
			this.recorrerX(obsActual.getxPosicion()-obsAnter); //Aumentar acumulador de X
			this.calcularVelocidad(obsAnter-obsActual.getxPosicion()); //Disminuir velocidad por escalada hecha.
			obsAnter=obsActual.getxPosicion(); //Actualizar obstaculo anterior
		}	
		return obsAnter;
	}
	
	public long recorrerValle(long obsAnter, Obstaculo obsActual) {
		this.recorrerX(obsAnter-obsActual.getxPosicion()); //Aumentar acumulador de X
		this.calcularVelocidad(obsAnter-obsActual.getxPosicion()-1); //Aumentar velocidad por descenso hecho, menos 1 por llegar al valle.
		return obsAnter=obsActual.getxPosicion(); //Actualizar obstaculo anterior
	}
	
	public long getxInicial() {
		return xInicial;
	}
	public void setxInicial(long xInicial) {
		this.xInicial = xInicial;
	}
	
	public long getxRecorrida() {
		return xRecorrida;
	}
	public void setxRecorrida(long xRecorrida) {
		this.xRecorrida = xRecorrida;
	}
	
	public long getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(long velocidad) {
		this.velocidad = velocidad;
	}
	
	public long getyFinal() {
		return yFinal;
	}
	public void setyFinal(long yFinal) {
		this.yFinal = yFinal;
	}
}
