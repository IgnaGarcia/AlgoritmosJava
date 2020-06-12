public interface Cola<T>{
	public void    encolar(T dato);
	public void    desencolar();
	public      T  primero();
	public boolean esVacia();
	public void    vaciar();
}
