EzTask 📱

Evaluación N°1 – Programación Android

📌 Descripción

EzTask es una aplicación Android desarrollada en Java como parte de la Evaluación N°1 del curso de Programación Android.
La app implementa un flujo completo de login → menú principal → agregar tarea → ver tareas, cumpliendo los criterios de la rúbrica solicitada.

✅ Funcionalidades
Login (MainActivity)

Campos: usuario y contraseña.

Validación: no permite continuar si algún campo está vacío o si el usuario no ingresa un nombre real.

Al ingresar, se envía el nombre del usuario al menú.

Menú principal (TaskMenuActivity)

Botón Agregar Tarea.

Botón Ver Tareas.

Mensaje de bienvenida con el nombre del usuario autenticado.

Agregar Tarea (AddTaskActivity)

Campo nombre de la tarea.

RatingBar para prioridad (estrellas).

Validación: si el nombre está vacío, se muestra error y no se guarda.

Al guardar, la tarea se almacena en memoria (en una lista compartida) y se vuelve al menú.

Ver Tareas (ViewTasksActivity)

Listado deslizable de tareas guardadas.

Botón Volver que retorna al menú.

Refresco automático del listado al volver a esta pantalla.

ℹ️ Nota: Las tareas se guardan en memoria (viven mientras la app esté abierta). No hay persistencia al cerrar la app.

🛠️ Tecnologías y configuración

Lenguaje: Java

IDE: Android Studio (Giraffe/Iguala o superior)

Gradle wrapper incluido

Mínimo SDK: API 21 (Android 5.0)

Arquitectura: Activities + Intents

UI creada con Palette (arrastrar/soltar) y ajustes puntuales en XML



📂 Estructura 
app/src/main/java/com/example/eztask/
├── MainActivity.java          // Login
├── TaskMenuActivity.java      // Menú principal
├── AddTaskActivity.java       // Crear tarea (nombre + estrellas)
└── ViewTasksActivity.java     // Listado de tareas + botón Volver


Recursos principales:

app/src/main/res/layout/
├── activity_main.xml
├── activity_task_menu.xml
├── activity_add_task.xml
└── activity_view_tasks.xml

🧪 Comportamiento esperado (flujo)

Login: ingresar usuario y contraseña → validación.

Menú: ver mensaje “Bienvenido {usuario}”.

Agregar Tarea: escribir nombre + (opcional) estrellas → Guardar.

Ver Tareas: listado de tareas guardadas → Volver regresa al menú.

📸 Capturas (opcional)

Puedes agregar imágenes del flujo en esta sección:

docs/login.png

docs/menu.png

docs/add_task.png

docs/view_tasks.png

📝 Observaciones

El almacenamiento de tareas es volátil (en memoria).

Si se requiere persistencia entre sesiones, puede añadirse SharedPreferences o Room en una versión posterior.

👨‍💻 Proyecto desarrollado como evidencia práctica para la Evaluación N°1 de Programación Android.
