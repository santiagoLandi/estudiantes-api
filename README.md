# 📘 Estudiantes API

API REST desarrollada en Java con Spring Boot que permite gestionar estudiantes, realizar operaciones CRUD y aplicar filtros por nombre, ciudad o email. Está diseñada como ejercicio de práctica con base de datos en memoria (H2) y validación de datos.

---

## ⚙️ Tecnologías utilizadas

- Java 21
- Spring Boot 3.4.5
- Spring Data JPA
- Maven
- H2 Database (en memoria)
- MapStruct
- Jakarta Bean Validation
- Postman para pruebas

---

# 📘 EndPoints

  Crear estudiante
- POST /estudiante
  Body Ejemplo:
- {
  "nombre": "Martín",
  "apellido": "Pérez",
  "dni": 12345678,
  "email": "martin.perez@gmail.com",
  "ciudad": "Mendoza"
  }


  Listar todos los estudiantes
- GET /estudiante/

  Buscar estudiante por ID
- GET /estudiante/{id}

  Actualizar estudiante por ID
- PUT /estudiante/{id}
- {
  "nombre": "Martina",
  "apellido": "Gómez",
  "dni": 87654321,
  "email": "martina.gomez@gmail.com",
  "ciudad": "Buenos Aires"
  }

  Eliminar estudiante por ID
- DELETE /estudiante/{id}

  Buscar estudiantes por nombre
- GET /estudiante/nombre/{nombre}
  Ejemplo: Martin
- GET /estudiante/nombre/Martin

  Buscar estudiantes por ciudad
- GET /estudiante/ciudad/{ciudad}

  Buscar estudiante por email
- GET /estudiante/email/{email}


❗ Manejo de errores
  Validaciones gestionadas con Bean Validation (anotaciones como @NotBlank, @Email, etc).

  Errores centralizados con @ControllerAdvice y mensajes personalizados para:

  Validación fallida

  Ciudad sin estudiantes

  Nombre sin estudiantes

  Email inexistente

  ✍️ Autor
  Desarrollado por Santiago Landi como práctica backend con Java y Spring Boot.


