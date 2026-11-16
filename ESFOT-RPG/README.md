ESFOT RPG 

1.- **Descripción del proyecto**

ESFOT RPG es un videojuego de rol desarrollado en Java mediante una aplicación de consola. Su objetivo es registrar 
diferentes tipos de personajes, consultar sus características, utilizar habilidades especiales y realizar combates por turnos.
El proyecto aplica los principios de Programación Orientada a Objetos (POO), principalmente herencia, 
encapsulamiento, polimorfismo, constructores, sobrescritura y sobrecarga de métodos.

###########################################################################################################################################################

**2.- Personajes del juego**

- Guerrero
- Mago
- Arquero
- Paladín

###########################################################################################################################################################

**3.- Funcionalidades**

El programa permite:

1. Crear un Guerrero.
2. Crear un Mago.
3. Crear un Arquero.
4. Crear un Paladín.
5. Mostrar todos los personajes registrados.
6. Buscar personajes por nombre.
7. Atacar a otro personaje.
8. Utilizar habilidades especiales.
9. Simular combates por turnos.
10. Mostrar los personajes que siguen vivos.
11. Salir del programa.

###########################################################################################################################################################

**4.- Instrucciones de ejecución**

1. Descargar o clonar el repositorio de GitHub.
2. Abrir el proyecto desde IntelliJ IDEA.
3. Comprobar que los paquetes y archivos Java estén organizados correctamente.
4. Abrir el archivo `Main.java`.
5. Ejecutar el método `main`.
6. Utilizar el menú de consola para interactuar con el juego.

###########################################################################################################################################################

**5.- Explicación de la herencia**

**Herencia simple**

Se aplica cuando una clase hereda directamente de otra.

**Herencia jerárquica**

Se presenta cuando varias clases heredan de una misma clase padre.

**Herencia multinivel**

Se presenta cuando una clase hereda de otra que también hereda de una clase anterior.

###########################################################################################################################################################

**6.- Preguntas de análisis**

**-1. ¿Dónde se aplica herencia simple en el proyecto?**

Se aplica cuando la clase Guerrero hereda directamente de Personaje mediante `extends`. 
De esta manera, Guerrero puede utilizar los atributos y métodos generales definidos en su clase padre y agregar sus propias características.

**-2. ¿Por qué Personaje → Guerrero → Paladin representa herencia multinivel?**

Porque existen varios niveles de herencia. Primero Guerrero hereda de Personaje y después Paladín hereda de Guerrero. 
Por lo tanto, Paladín recibe las características de ambas clases.

**-3. ¿Qué relación ejemplifica herencia jerárquica?**

La relación entre Personaje y sus clases hijas Guerrero, Mago y Arquero. Todas heredan de una misma clase padre, 
pero cada una tiene características y habilidades propias.

**-4. ¿Cuál es la diferencia entre sobrescritura y sobrecarga de atacar()?**

La sobrescritura ocurre cuando una clase hija modifica el comportamiento de un método heredado utilizando `@Override`.
La sobrecarga ocurre cuando existen varios métodos con el mismo nombre, pero con diferentes parámetros.
Por ejemplo, el proyecto contempla `atacar(Personaje enemigo)` y `atacar(Personaje enemigo, int bonificacion)`.

**-5. ¿Qué aporta super en constructores y métodos?**

`super` permite acceder a elementos de la clase padre.
En los constructores permite inicializar los atributos heredados mediante `super()`.
También permite reutilizar métodos de la clase padre, evitando repetir código. Por ejemplo, `super.mostrarInformacion()`.

**-6. ¿Por qué List<Personaje> admite guerreros, magos, arqueros y paladines?**

Porque todos los tipos de personajes pertenecen a la jerarquía de herencia de Personaje.
Por eso pueden almacenarse en una misma lista utilizando referencias de tipo Personaje. Esto permite aplicar polimorfismo.

**-7. ¿Qué versión de mostrarInformacion() se ejecuta al recorrer la lista y por qué?**

Se ejecuta la versión correspondiente al tipo real del objeto.
Esto sucede gracias al polimorfismo. Aunque la referencia sea de tipo Personaje, 
Java reconoce si el objeto es un Guerrero, Mago, Arquero o Paladín y ejecuta su método sobrescrito.

**-8. ¿Cuándo se necesita instanceof antes de hacer casting?**

Se utiliza cuando necesitamos comprobar el tipo real de un objeto antes de convertirlo a una clase específica.
Por ejemplo, para comprobar si un personaje es un Mago antes de convertirlo a Mago y utilizar su habilidad de lanzar hechizos.
Esto evita realizar conversiones incorrectas.

**-9. ¿Qué ventaja aporta HashMap para localizar un personaje por nombre?**

HashMap permite relacionar una clave con un objeto.
En este proyecto, el nombre del personaje funciona como clave y el objeto Personaje como valor.
Esto facilita localizar personajes directamente mediante `get(nombre)` sin recorrer toda la lista.
También permite comprobar nombres duplicados mediante `containsKey()`.

**-10. ¿Cómo se protege la consistencia de los atributos mediante encapsulamiento?**

Los atributos se declaran privados para impedir que sean modificados directamente desde otras clases.
Para acceder a ellos se utilizan getters y setters. Los setters incorporan validaciones que permiten evitar valores incorrectos, 
como una vida superior a la vida máxima o cantidades negativas de recursos.





