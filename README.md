# Prueba Tecnica Spring Boot
## API REST para la gestion de una universidad

---

### :pushpin: Objetivo
El objetivo de esta prueba es evaluar conocomientos en **Java + Spring Boot**, incluyendo el desarrollo de una 
**API RESTful completa** que implemente operaciones **CRUD** con **JPA**, relaciones entre entidades, control de 
errores y excepciones, uso de DTOs, buenas practicas REST y programación funcional (uso de lamddas y streams).

### :books: Entidades Principales

- Universidad (**University**)
- Estudiante (**Student**)
- Curso (**Course**)

### :mortar_board: Relaciones

- Una **universidad** puede tener muchos **cursos**
- Un **curso** tiene muchos **estudiantes**
- Un mismo **estudiante** puede estar en muchos **cursos**

### :white_check_mark: Requisito Técnico 

- Utiliza **Spring Boot con JPA** para manejo de bases de datos.
- Base de datos relacional (por ejemplo **MySQL**)
- Exponer endpoints RESTful para realizar **CRUDS (GET, POST, PUT, DELETE** o los métodos que se consideren necesarios)
- Utilizar **DTOs** para separar modelos de dominio y representación externa.
- Manejo adecuado de errore con **RsponseEntity**, **código HTTP** correctos (status code) y mensajes claros.
- Uso de **lambdas o streams** en al menos una operación del backend.
- Organización modular del proyecto (service, repository, controller)

