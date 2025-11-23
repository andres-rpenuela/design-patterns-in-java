# Notas sobre `@EqualsAndHashCode` en Lombok

## Diferencias entre configuraciones

### Configuración 1: `exclude`
```java
@EqualsAndHashCode(callSuper = true, exclude = { "password", "updateAt" })
```
- **Descripción**: Excluye los campos `password` y `updateAt` de la comparación.
- **Comportamiento**: Todos los demás campos (como `email`, `nickname`, etc.) se consideran automáticamente para los métodos `equals` y `hashCode`.
- **Resultado**: Dos objetos son iguales si todos los campos restantes coinciden.



### Configuración 2: `onlyExplicitlyIncluded`
```java
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@EqualsAndHashCode.Include
private String email;

@EqualsAndHashCode.Include
private String nickname;
```
- **Descripción**: Solo los campos marcados con `@EqualsAndHashCode.Include` (`email` y `nickname`) se consideran para los métodos `equals` y `hashCode`.
- **Comportamiento**: Los demás campos (como `password` y `updateAt`) se ignoran completamente.
- **Resultado**: Dos objetos son iguales si **al menos uno** de los campos `email` o `nickname` coincide.


## Diferencia clave
- **Configuración 1**: Requiere que todos los campos relevantes coincidan.
- **Configuración 2**: Permite que los objetos sean iguales si tienen el mismo `email` o el mismo `nickname`, es decir, basta con que uno de los campos coincida.

## Posible confusión

```java
@Data
@Builder
@EqualsAndHashCode(exclude = { "lastName", "phoneNumber", "birthDate"}, onlyExplicitlyIncluded = true)
public abstract class Person {
    private String name;
    private String lastName;
    private TYPE_IDENTIFICATION typeIdentification;
    @EqualsAndHashCode.Include
    private String identificationNumber;
    private String phoneNumber;
    private LocalDate birthDate;
}
```

El campo `name` no está incluido explícitamente con `@EqualsAndHashCode.Include` ni está en la lista de exclusión (`exclude`). Sin embargo, debido a que se está utilizando `onlyExplicitlyIncluded = true`, **el campo `name` no será considerado** en los métodos `equals` y `hashCode`.

Por tanto:

- **`name` no afecta la comparación de igualdad** entre dos objetos de la clase `Person`.
- Solo el campo `identificationNumber` será utilizado para determinar si dos objetos son iguales.

Y dos objetos de la clase Person serán considerados iguales si tienen el mismo valor en el campo identificationNumber, independientemente de los valores de los demás campos. Esto puedo conllevar a un error, si se piensa que person también esta incluido en el equal y hashcode.

---

# Notas sobre `@Builder` y `@SuperBuilder` en Lombok

## `@Builder`
- **Descripción**: Genera un patrón de diseño *Builder* para la clase, permitiendo construir objetos de manera fluida y legible.
- **Uso**: Se utiliza en clases simples o finales.
- **Características**:
    - Crea un método estático `builder()` para iniciar la construcción del objeto.
    - Permite establecer valores para los campos de la clase mediante métodos encadenados.
    - Genera un método `build()` para crear la instancia final del objeto.
- **Limitaciones**:
    - No soporta herencia directamente.
    - No puede ser utilizado en clases que extienden otras clases.

### Ejemplo:
```java
@Data
@Builder
public class User {
    private String name;
    private String email;
}
```

**Uso**:
```java
User user = User.builder()
                .name("Andrés")
                .email("andres@example.com")
                .build();
```

## `@SuperBuilder`
- **Descripción**: Extiende las capacidades de `@Builder` para soportar herencia.
- **Uso**: Se utiliza en clases que forman parte de una jerarquía de herencia.
- **Características**:
    - Genera un método `builder()` en la clase base y en las subclases.
    - Permite construir objetos de subclases incluyendo los campos de la clase base.
    - Requiere que las clases base y derivadas estén anotadas con `@SuperBuilder`.
- **Limitaciones**:
    - No puede ser utilizado en clases finales.
    - Requiere que las clases base tengan un constructor sin argumentos o un constructor protegido.

### Ejemplo:
```java
@Data
@SuperBuilder
public class Person {
    private String name;
    private String lastName;
}

@Data
@SuperBuilder
public class User extends Person {
    private String email;
}
```

**Uso**:
```java
User user = User.builder()
                .name("Andrés")
                .lastName("Penuela")
                .email("andres@example.com")
                .build();
```
## ¿Se puede usar en clases Abstractas?
Sí, tanto `@Builder` como `@SuperBuilder` pueden usarse en clases abstractas, pero con algunas consideraciones:

1. **`@Builder`**:
    - Aunque se puede usar en clases abstractas, no generará un método `builder()` directamente para instanciar la clase abstracta, ya que no se pueden crear instancias de clases abstractas.
    - Sin embargo, las subclases concretas pueden heredar el comportamiento del *builder*.

2. **`@SuperBuilder`**:
    - Es más adecuado para clases abstractas en jerarquías de herencia.
    - Genera un *builder* para las subclases concretas, permitiendo incluir los campos de la clase abstracta en el proceso de construcción.

### Ejemplo con `@SuperBuilder` en una clase abstracta

```java
@Data
@SuperBuilder
public abstract class Person {
    private String name;
    private String lastName;
}

@Data
@SuperBuilder
public class User extends Person {
    private String email;
}
```

**Uso**:
```java
User user = User.builder()
                .name("Andrés")
                .lastName("Penuela")
                .email("andres@example.com")
                .build();
```

En este caso, `@SuperBuilder` permite construir un objeto `User` incluyendo los campos de la clase abstracta `Person`.

## Diferencias clave
| **Aspecto**         | **@Builder**                  | **@SuperBuilder**              |
|----------------------|-------------------------------|---------------------------------|
| **Herencia**         | No soporta herencia.         | Soporta herencia.              |
| **Jerarquía**        | Solo para clases simples.     | Para clases base y derivadas.  |
| **Compatibilidad**   | Clases finales o simples.     | Clases no finales.             |

--- 