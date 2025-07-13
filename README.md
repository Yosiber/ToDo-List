# Gestor de Tareas (ToDO List con Usuarios)

## Descripción:
Una API REST donde los usuarios pueden registrarse y gestionar sus propias tareas (crear, leer, actualizar y eliminar).

## Funcionalidades
#### 📌 Para Usuarios:
- Registro

- Obtener todos los usuarios

- Buscar por ID

- Eliminar usuario

- Campos mínimos: Nombre, correo, auditoria de tiempo

#### 📌 Para Tareas:
- Crear tarea (vinculada a un usuario)

- Listar tareas por usuario

- Actualizar estado (completada o no)

- Eliminar tarea

- Buscar tareas próximas a vencer (filtro por fecha)

- Campos mínimos: Nombre, descripción, auditoria de tiempos, usuario, fecha de expiración, estado de la tarea.

## Tips de buenas prácticas

- El nombre de las clases deben comenzar en mayúscula.
- El nombre de los métodos deben comenzar en minúscula, Ejemplo: executeCase. No separar por _.
- Nombre de las variables aplica de igual forma que el nombre de los métodos.
- Si la variable es un final static, el nombre debe ser en mayúscula y separado con _, ejemplo: FORMATO_HORA.
- Evitar duplicación de código, para esto puede crear un método aparte y llamarlo.
- En lo posible usar un mapper.
- Puede usar enums cuando son varias opciones
- Para el servicio, establecer un contrato y su implementación

- Hacer un buen commit, se le añade un sufijo (feat, fix, test, chore, docs, styles, refactor, entre otros), y luego una breve descripción general de los cambios. Si quiere añadir más información, hagalo aparte en el mismo commit.
- Ejemplo: git commit -m "sufijo: descripción corta" -m "descripción con más detalles"
- Eliminar importaciones no usadas
- Evitar llamar como excepción a RunTime, puedes llamar a otra Exception o crear una propia (esta se puede extender el RunTimeException)