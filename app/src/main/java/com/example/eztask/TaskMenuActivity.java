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

        // Saludo inicial (solo una vez al entrar)
        String username = getIntent().getStringExtra("username");
        if (username != null && !username.isEmpty()) {
            Toast.makeText(this, "Bienvenido " + username, Toast.LENGTH_SHORT).show();
        }

        Button btnAddTask = findViewById(R.id.btnAddTask);
        Button btnViewTasks = findViewById(R.id.btnViewTasks);

        btnAddTask.setOnClickListener(v ->
                startActivity(new Intent(TaskMenuActivity.this, AddTaskActivity.class)));

        btnViewTasks.setOnClickListener(v ->
                startActivity(new Intent(TaskMenuActivity.this, ViewTasksActivity.class)));
    }
}
