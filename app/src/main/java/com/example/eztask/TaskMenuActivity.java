package com.example.eztask;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TaskMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_menu);

        // Recuperar el nombre del usuario que viene desde MainActivity
        String username = getIntent().getStringExtra("username");
        if (username != null && !username.isEmpty()) {
            Toast.makeText(this, "Bienvenido " + username, Toast.LENGTH_SHORT).show();
        }

        // Referencias a los botones del menú (ya los tienes en el XML)
        Button btnAddTask = findViewById(R.id.btnAddTask);
        Button btnViewTasks = findViewById(R.id.btnViewTasks);

        // ✅ Abrir pantalla para Agregar Tarea
        btnAddTask.setOnClickListener(v -> {
            Intent intent = new Intent(TaskMenuActivity.this, AddTaskActivity.class);
            startActivity(intent);
        });

        // (Por ahora, Ver Tareas queda pendiente. Lo conectaremos luego)
        btnViewTasks.setOnClickListener(v -> {
            Toast.makeText(this, "Abrir pantalla para Ver Tareas", Toast.LENGTH_SHORT).show();
            // Más adelante: startActivity(new Intent(TaskMenuActivity.this, ViewTasksActivity.class));
        });
    }
}
