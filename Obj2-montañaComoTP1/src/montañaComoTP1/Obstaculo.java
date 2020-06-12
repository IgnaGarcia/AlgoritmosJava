package montañaComoTP1;

public class Obstaculo {
	private long xPosicion;

	public Obstaculo(long xPosicion) {
		this.setxPosicion(xPosicion);
	}
	
	public Obstaculo() {
		this.setxPosicion(0);
	}
	
	public long getxPosicion() {
		return xPosicion;
	}
	public void setxPosicion(long xPosicion) {
		this.xPosicion = xPosicion;
	}
}
