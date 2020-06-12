public interface Pila <T>{
	
   public boolean esVacia();
   public void    apilar(T x);
   public void    desapilar();
   public Object  cima();
   public void    vaciar();
}
