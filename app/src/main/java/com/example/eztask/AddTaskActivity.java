package com.example.eztask;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddTaskActivity extends AppCompatActivity {


    public static final ArrayList<Task> taskList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        EditText etTaskName = findViewById(R.id.etTaskName);  // "Nombre de la Tarea"
        EditText etTaskDesc = findViewById(R.id.etDescription);  // "Descripción"
        RatingBar rbPriority = findViewById(R.id.rbPriority);
        Button btnSaveTask = findViewById(R.id.btnSaveTask);

        btnSaveTask.setOnClickListener(v -> {
            String name = etTaskName.getText().toString().trim();
            String desc = etTaskDesc != null ? etTaskDesc.getText().toString().trim() : "";
            int stars = Math.round(rbPriority.getRating());

            if (name.isEmpty()) {
                etTaskName.setError("Ingresa un nombre para la tarea");
                etTaskName.requestFocus();
                return;
            }

            // Guardar como  Task (con fecha/hora actual)
            Task t = new Task(name, desc, stars, System.currentTimeMillis());
            taskList.add(t);

            finish();
        });
    }
}
