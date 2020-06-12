3) Crear una clase llamada Serie, con las características titulo, numero de temporadas, entregado, genero y creador. Por defecto, tendrá tres temporadas y entregado será falso.
Se deben implementar tres constructores: uno por defecto, otro con título y creador, y otro con todos los atributos excepto entregado.
Crear una clase Videojuego, con las características titulo, horas estimadas, entregado, genero y compania. Por defecto, tendrá diez horas estimadas y entregado será falso.
Se deben implementar tres constructores: uno por defecto, otro con título y horas estimadas, y otro con todos los atributos excepto entregado.
Luego crear una interfaz Entregable, la cual contendrá los métodos:
- entregar() que cambia el atributo entregado a verdadero
- devolver() que cambia el atributo entregado a falso
- estaEntregado() que devuelve el estado del atributo entregado
Las series y los videojuegos implementarán dicha interfaz.
Por último, en la función principal, crear dos vectores de 5 elementos, uno de series y otro de videojuegos. Entregar algunos videojuegos y algunas series. Contar cuantas series y videojuegos hay entregados, e informar por pantalla. Luego, devolverlos.
