# 🏗️ Patrón de diseño: Abstract Factory

> Patrón creacional que permite crear familias de objetos relacionados sin especificar sus clases concretas. Ideal cuando el sistema debe ser independiente de cómo se crean, componen y representan sus objetos.

> Evolución del Patrón Factory.

```
                   🏭 Fábrica Abstracta
               /                           \
      🟠 Fábrica Esférica          🔺 Fábrica Piramidal
         /       \                        /       \
  ⚽️ Objeto A   🪐 Objeto B     🔻 Objeto C   🔺 Objeto D
```

---

### 🎨 Analogía creativa

Ejemplo: 

```
                         🏭 Fábrica Abstracta
                         /                   \
       🟠 Fábrica Esférica                🔺 Fábrica Piramidal
              /       \                         /       \
     ⚽️ Objeto A   🪐 Objeto B          🔻 Objeto C   🔺 Objeto D
```

- **Fábrica Esférica**: produce objetos redondeados, suaves, como `Ball`, `Planet`
- **Fábrica Piramidal**: produce objetos angulares, sólidos, como `Cone`, `Pyramid`

---

### 🧱 Estructura UML típica

| Componente               | Rol en el patrón                          |
|--------------------------|-------------------------------------------|
| `AbstractFactory`        | Interfaz que define métodos de creación   |
| `ConcreteFactoryA`       | Implementa la creación de objetos tipo A  |
| `ConcreteFactoryB`       | Implementa la creación de objetos tipo B  |
| `AbstractProductA/B`     | Interfaces para productos relacionados    |
| `ProductA1`, `ProductA`  | Implementaciones concretas              |
| `ProductB1`, `ProductB2` | Implementaciones concretas              |

![img.png](imgs/01-uml.png)
---

### 🧾 Ejemplo en Java

```java
public interface ShapeFactory {
    Shape createShapeA();
    Shape createShapeB();
}

public class SphericalFactory implements ShapeFactory {
    public Shape createShapeA() { return new Ball(); }
    public Shape createShapeB() { return new Planet(); }
}

public class PyramidalFactory implements ShapeFactory {
    public Shape createShapeA() { return new Cone(); }
    public Shape createShapeB() { return new Pyramid(); }
}
```
> Nota: Esto se podría simpliciar, indicando la forma a crear en el factory, y tener un método con argument en lugar de dos, como se hace en el ejemplo de `insurance/riks`
> Esto permite:
> - Menos métodos en la interfaz
> - Más flexible para añadir nuevos tipos
> - Permite usar enums o constantes para mayor seguridad
> ```java
>  public interface ShapeFactory {
>       Shape createShape(String type);
>  }
> 
>  public class SphericalFactory  implements ShapeFactory {
>      public Shape createShape(String type) {
>          return switch (type.toLowerCase()) {
>              case "a" -> new Ball();
>              case "b" -> new Planet();
>              default: throw new IllegalArgumentException("Tipo desconocido: " + type);
>          };
>      }
>  }
> 
>  public class PyramidalFactory implements ShapeFactory {
>      public Shape createShape(String type) {
>          return switch (type.toLowerCase()) {
>              case "a" -> new Cone();
>              case "b" -> new Pyramid();
>              default: throw new IllegalArgumentException("Tipo desconocido: " + type);
>          };
>      }
>  }
>  //...
> ShapeFactory factory = new SphericalFactory();
> Shape shape1 = factory.createShape("a"); // Ball
> Shape shape2 = factory.createShape("b");
> 
> ShapeFactory factory2 = new PyramidalFactory();
> Shape shape3 = factory2.createShape("a"); // Cone
> Shape shape4 = factory2.createShape("b"); // Pyramid
> ```

---

## 🧭 ¿Cuándo aplicar el patrón Abstract Factory?

### ✅ Casos técnicos

- 🔗 **Consistencia entre objetos**  
  Cuando necesitas que los objetos creados **combinen entre sí** o compartan un estilo, comportamiento o configuración.  
  _Ejemplo_: Componentes de UI para Windows, Mac, Linux.

- 🔄 **Desacoplar la lógica de creación**  
  El cliente no debe saber qué clase concreta está usando. Solo necesita la interfaz.  
  _Ejemplo_: Un sistema de seguros que crea riesgos sin conocer sus clases concretas.

- 📦 **Extensibilidad sin modificar código existente**  
  Puedes añadir nuevas variantes de productos (nuevas familias) sin tocar el código cliente.  
  _Ejemplo_: Añadir estilo “Minimalista” a la tienda de muebles sin cambiar `FurnitureApp`.

---

## 🧩 Casos de dominio

### 🏗️ 1. Sistemas que requieren productos independientes de su creación

> “En aquellos sistemas que necesitan productos independientes de la forma en que se crean y agrupan.”

- **Motivo**: Separar el _qué_ del _cómo_.
- **Ejemplo**: Un sistema de construcción de vehículos que puede armar coches, motos o camiones, sin acoplarse a cómo se ensamblan.

---

### 🧬 2. Sistemas configurados por familias de productos que pueden evolucionar

> “Sistemas configurados en función de familias de productos que pueden evolucionar.”

- **Motivo**: Permitir que las familias crezcan sin romper la arquitectura.
- **Ejemplo**: Un sistema de seguros que tiene riesgos de vida, hogar, coche, caución… y puede añadir nuevos tipos sin modificar el núcleo.

---

## 🧠 ¿Por qué no usar simplemente Factory Method?

- Abstract Factory **agrupa múltiples Factory Methods** bajo una misma interfaz.
- Es ideal cuando los productos **están relacionados entre sí** y deben **coexistir coherentemente**.

---

## 🛋️ Problema que resuelve el patrón Abstract Factory

### 🎯 **Necesidad**

Crear **familias de objetos relacionados** (como muebles) que **combinen entre sí**, sin acoplar el código a clases concretas.

---

### 🧩 Contexto del ejemplo

Supón que tienes una tienda virtual que vende:

- **Sillas**
- **Sofás**
- **Mesillas**

Cada uno disponible en **varias variantes de estilo**:

| Estilo       | Silla           | Sofá            | Mesilla         |
|--------------|------------------|------------------|------------------|
| Moderna      | `ModernChair`    | `ModernSofa`     | `ModernTable`    |
| Victoriana   | `VictorianChair` | `VictorianSofa`  | `VictorianTable` |
| ArtDecó      | `ArtDecoChair`   | `ArtDecoSofa`    | `ArtDecoTable`   |

---

### ❌ Problema sin Abstract Factory

Si creas cada mueble por separado, podrías terminar con una mezcla incoherente como:

```java
Chair chair = new VictorianChair();
Sofa sofa = new ModernSofa();
Table table = new ArtDecoTable();
```

Esto rompe la **consistencia visual** y la **coherencia de estilo**.

---

### ✅ Solución con Abstract Factory

Usas una **fábrica abstracta** que garantiza que todos los muebles creados pertenecen a la misma familia:

```java
FurnitureFactory factory = new VictorianFurnitureFactory();

Chair chair = factory.createChair();
Sofa sofa = factory.createSofa();
Table table = factory.createTable();
```

Ahora todos los muebles combinan: estilo Victoriano 🎩.

---

### 🧠 Beneficios

- **Consistencia**: todos los productos creados por una fábrica combinan entre sí.
- **Desacoplamiento**: el cliente no necesita conocer las clases concretas.
- **Escalabilidad**: puedes añadir nuevas familias (ej. Minimalista, Futurista) sin modificar el código existente.

---

### 🛠️ ¿Cómo se ve la estructura?

```java
public interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
    Table createTable();
}

public class ModernFurnitureFactory implements FurnitureFactory {
    public Chair createChair() { return new ModernChair(); }
    public Sofa createSofa()   { return new ModernSofa(); }
    public Table createTable() { return new ModernTable(); }
}
```

## Anexo: 🧠 Esquema conceptual del patrón Abstract Factory
![img.png](imgs/02-structure.png)


| Elemento clave                  | Rol en el patrón | Ejemplo en tienda de muebles |
|--------------------------------|------------------|------------------------------|
| **1. Productos Abstractos**     | Interfaces base para cada tipo de producto | `Chair`, `Sofa`, `Table` |
| **2. Productos Concretos**      | Implementaciones específicas por variante | `ModernChair`, `VictorianSofa`, etc. |
| **3. Fábrica Abstracta**        | Interfaz que declara métodos para crear productos | `FurnitureFactory` con `createChair()`, `createSofa()`... |
| **4. Fábricas Concretas**       | Implementan la fábrica abstracta para una variante | `ModernFurnitureFactory`, `VictorianFurnitureFactory` |
| **5. Cliente desacoplado**      | Usa productos abstractos sin conocer su variante | `FurnitureApp` que recibe una `FurnitureFactory` |

---

## Bibliografía

[refactoring.guru](https://refactoring.guru/es/design-patterns/abstract-factory)
