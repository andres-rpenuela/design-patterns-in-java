### 🏗️ Patrón de Diseño: Builder

El **patrón Builder** es un patrón de diseño creacional que permite construir objetos complejos paso a paso. Este patrón separa la construcción de un objeto de su representación, permitiendo crear diferentes representaciones del mismo objeto utilizando el mismo proceso de construcción.

---

### **Estructura del Patrón Builder**

1. **Producto (Product)**: El objeto complejo que se desea construir.
2. **Builder**: Interfaz que define los pasos para construir las partes del producto.
3. **ConcreteBuilder**: Implementación concreta del Builder que construye y ensambla las partes del producto.
4. **Director** *(opcional)*: Clase que controla el proceso de construcción utilizando el Builder.
5. **Cliente (Client)**: Solicita la construcción del producto.

---

### **Diagrama UML**

```plaintext
+-------------------+
|     Director      |
+-------------------+
| - builder: Builder|
+-------------------+
| + construir()     |
+-------------------+
         |
         v
+-------------------+       +-------------------+
|     Builder       |<------+  ConcreteBuilder  |
+-------------------+       +-------------------+
| + construirParteA |       | + construirParteA |
| + construirParteB |       | + construirParteB |
| + obtenerProducto |       | + obtenerProducto |
+-------------------+       +-------------------+
         ^
         |
+-------------------+
|     Producto      |
+-------------------+
| + parteA          |
| + parteB          |
+-------------------+
```

---

### **Notas Clave**

- **Director**: Es opcional, pero útil para encapsular la lógica de construcción y reutilizar procesos.
- **Builder**: Define los pasos de construcción, pero no implementa la lógica.
- **ConcreteBuilder**: Implementa los pasos definidos en el Builder.
- **Producto**: Es el resultado final del proceso de construcción.

---

### **Ventajas**

1. **Separación de construcción y representación**: Permite crear diferentes representaciones del mismo objeto.
2. **Control paso a paso**: Ideal para construir objetos complejos.
3. **Reutilización**: El Director puede reutilizar el mismo proceso de construcción con diferentes Builders.

---

### **Desventajas**

1. **Complejidad adicional**: Introduce más clases y puede ser excesivo para objetos simples.
2. **Dependencia del Director**: Si se usa, el cliente depende de esta clase para construir el objeto.