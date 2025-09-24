package com.example.eztask;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddTaskActivity extends AppCompatActivity {

    // Lista simple en memoria (vive mientras la app no se cierre)
    public static final ArrayList<String> taskList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        EditText etTaskName = findViewById(R.id.etTaskName);
        RatingBar rbPriority = findViewById(R.id.rbPriority);
        Button btnSaveTask = findViewById(R.id.btnSaveTask);

        btnSaveTask.setOnClickListener(v -> {
            String name = etTaskName.getText().toString().trim();
            int stars = (int) rbPriority.getRating();

            // ✅ Validación: que el campo no esté vacío
            if (name.isEmpty()) {
                etTaskName.setError("Ingresa el nombre de la tarea");
                etTaskName.requestFocus();
                return; // no guarda
            }

            // Guardamos como texto simple: "Nombre ⭐x"
            String item = name + " ⭐" + stars;
            taskList.add(item);

            Toast.makeText(this, "Tarea guardada", Toast.LENGTH_SHORT).show();
            finish(); // volver al menú
        });
    }
}
