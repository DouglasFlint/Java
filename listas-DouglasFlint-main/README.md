## Listas

El objetivo de esta práctica es que el alumno pueda reafirmar sus conocimientos en el tema de creación de objetos, al implementar la estructura de datos Lista y usarla para crear una pequeña aplicación capaz de manejar peliculas.

Una Lista es una estructura de datos parecida a un arreglo, con la diferencia en que ésta es de longitud dinámica, al no tener que definir en su creación la cantidad de elementos que guadará, sino que más bien puede ir creando localidades a convencia. 

Una de las formas más habituales de implementar una lista es usando un objeto auxiliar llamado Nodo, que es el responsable de guardar el objeto deseado asi como la referencia hacia el Nodo siquiente, haciendo una especie de cadena. La clase Lista usará la referencia del primer elemento desde la cual podrá buscar, eliminar y agregar nuevos elementos. La recomendación principal siempre será: Nunca pierdas la cabeza.


## Ejercicios
1. Implementa la clase **Nodo.java**, la cuál guarda un objeto y una referencia hacia el Nodo siguiente.
2. Crea la clase **Lista.java** que implemente la interfaz **Listable.java**. En esta se describen todos los métodos mínimos necesarios que debes incluir y desarrollar en tu clase Lista.
3. Completa la clase **Pelicula.java** que representa una Película. Los atributos mínimos necesarios son el nombre y la categoría. Puedes incluir más atributos si lo consideras pertinente. 
4. Ejecuta la clase principal con Ant. Verás un pequeño menu, en el cuál podrás agregar, eliminar, buscar e imprimir todo el catálogo de películas. Prueba con algunas ejemplos para cerciorarte que tu clase lista funciona correctamente. Eres libre de modificar esta clase a tu convencia, agregando más opciones o modificando las existentes. No elimines opciones.
5. Haz commit y sube tus cambios al repositorio.