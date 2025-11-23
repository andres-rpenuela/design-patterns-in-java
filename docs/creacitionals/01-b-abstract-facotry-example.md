### Ejemplo`a_shapes` y el patrón Abstract Facotry


El proyecto implementa un sistema para crear diferentes tipos de formas geométricas (cilíndricas, cónicas y piramidales) utilizando el patrón **Abstract Factory**. Este patrón permite crear familias de objetos relacionados sin especificar sus clases concretas.

1. **Clases principales:**
   - **`ShapeFactory`**: Clase abstracta que define métodos para crear formas geométricas de diferentes familias.
   - **`ShapeFactoryProvider`**: Implementación concreta que actúa como una "fábrica de fábricas", delegando la creación de formas a las fábricas específicas.
   - **Fábricas específicas**:
     - `CylindricalShapeFactoryImpl`: Crea formas cilíndricas.
     - `ConicalShapeFactoryImpl`: Crea formas cónicas.
     - `PyramidalShapeFactoryImpl`: Crea formas piramidales.

2. **Uso del patrón Abstract Factory:**
   - El cliente (`MainShapeAbstractFactory`) interactúa únicamente con `ShapeFactory` y no necesita conocer las implementaciones concretas de las formas o fábricas.
   - Las fábricas específicas encapsulan la lógica de creación de cada familia de formas.


#### **Diagrama UML:**

```plaintext
+-------------------+                                                                                   
|   ShapeFactory    |<-------------------------------------------------------------------+            
|-------------------|                                                                    |
| +createCylindrical|                                                             +---------------------+
| +createConical    |                                                             | ShapeFactoryProvider| 
| +createPyramidal  |                                                             |---------------------|
+-------------------+                                                             | +getShape(type,...) | 
        ^                           ^                        ^                    +---------------------+
        |                           |                        |                            ^
+-------------------+       +-------------------+    +-------------------+                |                 
| CylindricalShape  |       | ConicalShape      |    | PyramidalShape    |                |                 
| Factory           |       | Factory           |    | Factory           |     +-------------------------+     
|-------------------|       |-------------------|    |-------------------|     | MainShapeAbstractFactory|
| +createCylinder   |       | +createConeShape  |    | +createSquarePyr  |     |-------------------------|     
| +createHollowCyl  |       | +createFrustrum   |    | +createTriangPyr  |     | +main(args: String[])   |
+-------------------+       +-------------------+    +-------------------+     +-------------------------+     
        ^                            ^                       ^                  
        |                            |                       |                  
+-------------------+       +-------------------+    +-------------------+      
| CylindricalShape  |       | ConicalShape      |    | PyramidalShape    |      
| FactoryImpl       |       | FactoryImpl       |    | FactoryImpl       |      
|-------------------|       |-------------------|    |-------------------|      
| (implementación)  |       | (implementación)  |    | (implementación)  |      
+-------------------+       +-------------------+    +-------------------+      

```
     
#### **¿Por qué se usa Abstract Factory?**

1. **Definición del patrón**:
   - Abstract Factory es un patrón de diseño creacional que proporciona una interfaz para crear familias de objetos relacionados o dependientes sin especificar sus clases concretas.

2. **Ventajas en este caso**:
   - **Independencia de implementación**: El cliente (`MainShapeAbstractFactory`) no necesita conocer las clases concretas de las formas o las fábricas.
   - **Extensibilidad**: Es fácil agregar nuevas familias de formas (por ejemplo, formas esféricas) creando una nueva fábrica específica.
   - **Organización**: Cada fábrica se encarga de una familia de formas, manteniendo el código modular y fácil de mantener.

3. **Fábrica de fábricas**:
   - `ShapeFactoryProvider` actúa como una fábrica central que selecciona y utiliza las fábricas específicas (`CylindricalShapeFactoryImpl`, `ConicalShapeFactoryImpl`, etc.), lo que simplifica la lógica para el cliente.