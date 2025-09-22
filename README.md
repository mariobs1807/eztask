# EzTask 📱  
**Evaluación N°1 – Programación Android**

## 📌 Descripción
EzTask es una aplicación Android desarrollada en **Java** como parte de la **Evaluación N°1 del curso de Programación Android**.  
El objetivo es implementar una app de gestión de tareas con login básico y navegación entre pantallas, cumpliendo los criterios de la rúbrica.

## ✅ Funcionalidades actuales
- **Pantalla de Login (MainActivity)**  
  - Campos de usuario y contraseña.  
  - Validación de campos vacíos.  
  - Botón *Ingresar* que permite acceder al menú principal.  

- **Pantalla de Menú (TaskMenuActivity)**  
  - Botón *Agregar Tarea*.  
  - Botón *Ver Tareas*.  
  - Muestra un mensaje de bienvenida con el nombre del usuario que inició sesión.  

## 🚧 Próximos pasos
- **AddTaskActivity:** formulario para crear tareas con nombre y prioridad (estrellas).  
- **ViewTasksActivity:** lista de tareas creadas con opción de volver al menú.  
- Manejo de tareas en memoria y posteriormente persistencia con `SharedPreferences`.

## 🛠️ Tecnologías
- Lenguaje: **Java**  
- IDE: **Android Studio**  
- Minimum SDK: **API 21 (Android 5.0)**  
- Arquitectura: Activities + Intents  

## 📂 Estructura inicial del proyecto
app/src/main/java/com/example/eztask/
│
├── MainActivity.java # Login
├── TaskMenuActivity.java # Menú principal
├── AddTaskActivity.java # 
└── ViewTasksActivity.java # 



## 🎯 Objetivo de la evaluación
- Distinguir los elementos fundamentales de la programación en Android.  
- Crear interfaces de usuario con el editor gráfico (Palette).  
- Implementar navegación entre Activities con Intents.  
- Cumplir con los requisitos establecidos en la rúbrica de la Evaluación N°1.  

---
👨‍💻 Proyecto desarrollado como evidencia práctica para la **Evaluación N°1 de Programación Android**.
