
# Patrón Factory

El **Factory Pattern** encapsula la lógica de creación de objetos, evitando que el código cliente tenga que conocer los detalles de instanciación.


## Descripción

El **Patrón Factory**:
* Es un patrón de diseño creacional.
* Proporciona una interfaz para crear objetos en una superclase.
* Las subclases puede alterar el tipo de objetos que se crearán. 
* El cliente no necesita conocer las clases concretas que se están instanciando.

## Estructura del Patrón

1. **Producto (Product)**: Define la interfaz común para los objetos que la fábrica creará.
2. **Producto Concreto (ConcreteProduct)**: Implementa la interfaz del producto.
3. **Creador (Creator)**: Declara el método de fábrica que devuelve objetos del tipo `Product`.
4. **Creador Concreto (ConcreteCreator)**: Sobrescribe el método de fábrica para devolver instancias de `ConcreteProduct`.

---

## Diagrama UML
Diagrama UML, con una representación más clara de las dependencias e implementaciones:

```plaintext
                +-------------------+
                |     Product       |<-------------+
                +-------------------+              |
                | + operation()     |              |
                +-------------------+              |
                    ^       ^                      |
                    |       |                      |
+-------------------+       +-------------------+  |
| ConcreteProductA  |       | ConcreteProductB  |  |
+-------------------+       +-------------------+  |
| + operation()     |       | + operation()     |  |
+-------------------+       +-------------------+  |
                                                   |
+--------------------+                             |
|  FactoryProduct    |------------------------------+
+--------------------+
| + createProductA() |
| + createProductB() |
+--------------------+

```

## Ejemplo de Implementación

### 1. Interfaz Producto

```java
public abstract class Product {
    // ...
}
```

### 2. Productos Concretos

```java
public class ConcreteProductA extends Product {
    //...
}

public class ConcreteProductB extends Product {
    //..
}
```

### 3. Creador

```java
public abstract class FactoryProduct {
    public abstract Product createProductA();
    public abstract Product createProductB();
}
```

### 4. Creadores Concretos

```java
public class FactoryProductImp extends FactoryProduct {
    @Override
    public Product createProductA() {
        return new ConcreteProductA();
    }
    @Override
    public Product createProductB() {
        return new ConcreteProductB();
    }
}
```

### 5. Cliente

```java
public class FactoryPatternDemo {
    public static void main(String[] args) {
        Product factory =  new FactoryProduct();
        Product productA = factory.createProdcutA();
        Product productB = factory.createProdcutB();
    }
}
```

## Ventajas

- **Desacoplamiento**: El cliente no necesita conocer las clases concretas.
- **Extensibilidad**: Es fácil agregar nuevos productos sin modificar el código existente.

## Desventajas

- **Complejidad**: Puede aumentar la complejidad del código debido a la creación de múltiples clases.
```