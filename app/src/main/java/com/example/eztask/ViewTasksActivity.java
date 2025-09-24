package com.example.eztask;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ViewTasksActivity extends AppCompatActivity {

    private ArrayAdapter<String> adapter;
    private final ArrayList<String> display = new ArrayList<>();
    private ListView lvTasks;
    private Button btnBack;

    private String starsAsText(int stars) {
        return " ⭐" + stars;
    }

    private String formatDate(long millis) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
        return sdf.format(millis);
    }


    private void rebuildDisplay() {
        display.clear();
        for (Task t : AddTaskActivity.taskList) {
            display.add(t.name + starsAsText(t.stars));
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tasks);

        lvTasks = findViewById(R.id.lvTasks);
        btnBack = findViewById(R.id.btnBack);

        // Adaptador de cadenas
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, display);
        lvTasks.setAdapter(adapter);

        // Cargar  el contenido
        rebuildDisplay();

        // T
        lvTasks.setOnItemClickListener((parent, view, position, id) -> {
            // Seguridad  si la lista cambió de tamaño
            if (position < 0 || position >= AddTaskActivity.taskList.size()) return;

            Task t = AddTaskActivity.taskList.get(position);
            String descShown = (t.description == null || t.description.trim().isEmpty())
                    ? "No se ingresaron detalles"
                    : t.description.trim();

            new AlertDialog.Builder(this)
                    .setTitle(t.name + starsAsText(t.stars))
                    .setMessage(
                            "Descripción:\n" + descShown +
                                    "\n\nFecha de creación:\n" + formatDate(t.createdAt)
                    )
                    .setPositiveButton("OK", null)
                    .show();
        });

        // Long press: marcar como como lista
        lvTasks.setOnItemLongClickListener((parent, view, position, id) -> {
            if (position < 0 || position >= AddTaskActivity.taskList.size()) return true;

            Task t = AddTaskActivity.taskList.get(position);
            new AlertDialog.Builder(this)
                    .setTitle("¿Tarea lista?")
                    .setMessage("Completarás la siguiente tarea:\n\n• " + t.name + starsAsText(t.stars))
                    .setPositiveButton("completar", (d, w) -> {
                        AddTaskActivity.taskList.remove(position);
                        rebuildDisplay();
                    })
                    .setNegativeButton("Cancelar", null)
                    .show();
            return true;
        });

        btnBack.setOnClickListener(v -> finish());
    }

    @Override
    protected void onResume() {
        super.onResume();
        rebuildDisplay();
    }
}
