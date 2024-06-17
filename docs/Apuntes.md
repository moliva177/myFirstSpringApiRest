# Spring Boot API - P00: Initializr

> [Spring starter web](https://start.spring.io/)

## Group que utilizamos
> ar.edu.utn.frc.tup.lciii


# Spring Boot API - P02: Ping Controller

## Anotaciones:
### @Controller
> Se utuliza par amarcar una clase como un controlador web en una aplicación Spring MVC. Indica que la clase es
> responsable de manejar las solicitudes HTTP y de devolver las respuestas adecuadas.

### @RestController
> Esta anotación es similar a @Controller, pero se utiliza específicamente para controladores RESTful. Combina la
> anotación @Controller y @ResponseBody, lo que significa que los métodos en un controlador anotado con @RestContrller
> devuelven directamente los datos en lugar de ser resueltos a través de una vista.

### @RequestMapping
> Se utiliza para mapear las solicitudes HTTP a métodos específicos en los controladores. Permite definir las URL y los
> métodos HTTP (GET, POST, PUT, DELETE, etc.) que un controlador debe manejar.

### @GetMapping
> Esta anotación combina las anotaciones @RequestMapping y @RequestMethod.GET. Se utuliza para mapear una solicitud
> HTTP GET a un método específico en un controlador.


# Spring Boot API - P05: Model-Entity

## 1. Codificar los models
> Objetos que estamos reprecentando

## 2. Codificar los entities
> Son las reprecentaciones de nuestras tablas en la BBDD

## 3. Creamos las intefaces repositories
> Las encargadas de dialogar con la BBDD

## Anotaciones:
### @Entity
> Esta anotación se utiliza para marcar una clase como una entidad de la BBDD. Cada entidad representa una tabla en la
> BBDD y cada instancia de la entidad representa una fila en esa tabla.

### @Table
> Esta anotación se utiliza para especificar el nombre de la tabla asociada a una entidad. Puede utlizarse para
> personalizar el nombre de la tabla y sus columnas, así como para establecer restricciones adicionales.

### @Id
> Esta anotación se utiliza para marcar una propiedad de una entidad como la clave primaria de la talba. Generalmente,
> se utiliza en combinación con la anotación @GeneratedValue para indicar que el valor de la clave primaria será
> generado automáticamente por la BBDD.

### @Column
> Esta anotación se utiliza para mapear una propiedad de una entidad a una columna en la tabla de la BBDD. Puede
> utilizarse para personalizar el nombre de la columna, su tipo de datos y otras características, como la longitud
> o si es nullable.

### @Repository
> Esta anotación se utiliza para marcar una clase como un componente de accesi a datis, Indica que la clase se encarga
> de interactuar con una case de datos o un origen de datos.
