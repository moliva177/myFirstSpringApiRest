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


# Spring Boot API - P06: Player Controller

## 1. Creo mi controlador con los Endpoints que necesito
> Los endpoints retornan ResponseEntity<T> que es un objeto con todo lo necesario para un objeto de respuesta.

## Anotaciones
### @PathVariable
> Utilizada para vincular variables de una URL con los parámetros de un método en un controlador. Permite acceder a
> valores dinámicos en la URL de una solicitud.

### @AutoWired
> Utilizada para realizar la inyeccion de dependencias en Spring. Se aplica a campos, constructores o métodos Setter y
> permite que Spring resuelva e inyecte las dependencias necesarias automáticamente.


# Spring Boot API - P07: Player Service

## 1. Creo el paquete config con la clase MapperConfig
> Sirve para mapear las entidades a los modelos

## 2. Creo una Interfaz Servicio
> Creo la interfaz con en contrato que tendrán los servicios que la implementen

## 3. Creo la implementación del servicio dentro del paquete service.impl

## Anotaciones
### @Configuration
> Esta anotación se utiliza para marcar una clase de configuración en Spring. Indica que la clase contiene métodos que
> definen la configuración de la aplicación, como la creación de beans y la configuración de componentes.

### @Bean
> Esta anotación se utiliza para marcar que un método en una clase de configuración de Spring debe ser tratado como un
> bean y gestionado por el contenedor de Spring.

### @Service
> Esta anotación se utiliza para marcar una clase como un servicio de negocio.
> Indica que la clase contiene la lógica de negocio de la aplicación y se utiliza para
> separar las responsabilidades de la capa de presentación y la capa de acceso a
> datos.


# Spring Boot API - P09: Validations

## Anotaciones:

### @NotNull

### @Email


# Spring Boot API - P10: Posting Player

## 1. Agrego el contrato en la interfaz.

## 2. Implemento el método en el servicio.

## 3. Creo el endpoint en el controlador.

## Anotaciones:

### @PostMapping
> Esta anotación combina las anotaciones @RequestMapping y
> @RequestMethod.POST. Se utiliza para mapear una solicitud HTTP POST a un
> método específico en un controlador.

### @RequestBody
> Esta anotación se utiliza para vincular el cuerpo de una solicitud HTTP con un
> objeto en un método de un controlador. Permite recibir y procesar datos enviados en
> el cuerpo de la solicitud, como en una solicitud POST o PUT.

### @Valid
> Se utiliza en parámetros de métodos o argumentos de constructores para
> activar la validación de datos según las anotaciones de validación de Spring, como
> @NotNull, @Size, etc.


# Spring Boot API - P11: Exception Handler

## 1. Creo la clase ErrorApi dentro del paquete dtos.common

## 2. Creo la clase ControllerExceptionHandler dentro del paquete controllers

## Anotaciones:

### @ControllerAdvice
> Verifica la ejecución de los controladores

### @ExceptionHandler


# Spring Boot API - P12: Custom Annotation

## 1. Agrego el paquete utils.validations.password
> Aquí dentro creo una interfaz de tipo annotation y su implementation con las validaciones necesarias.

## 2. Agrego la anotación a la propiedad


# Spring Boot API - P18: DataJpaTest

## Anotaciones:

### @DataJpaTest
> Esta anotación se utiliza para las pruebas de integración
que involucran repositorios de Spring Data JPA. Configura un entorno de
prueba específico para las operaciones de persistencia de datos.

### @SpringBootTest
> Esta anotación se utiliza para cargar y configurar el
contexto de Spring Boot durante las pruebas de integración. Carga todas
las configuraciones de la aplicación y permite acceder a los beans
administrados por Spring en las pruebas.