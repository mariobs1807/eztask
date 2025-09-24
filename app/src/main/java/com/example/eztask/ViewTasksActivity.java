package com.example.eztask;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ViewTasksActivity extends AppCompatActivity {

    private ArrayAdapter<String> adapter;
    private ListView lvTasks;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tasks);

        // Referencias
        lvTasks = findViewById(R.id.lvTasks);
        btnBack = findViewById(R.id.btnBack);

        // Adaptador con la lista en memoria
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                AddTaskActivity.taskList
        );
        lvTasks.setAdapter(adapter);

        // Long press: marcar como "lista" (eliminar)
        lvTasks.setOnItemLongClickListener((parent, view, position, id) -> {
            String tarea = AddTaskActivity.taskList.get(position);

            new AlertDialog.Builder(this)
                    .setTitle("¿Tarea lista?")
                    .setMessage("Marcar como completada y eliminar:\n\n• " + tarea)
                    .setPositiveButton("Sí, completar", (d, w) -> {
                        AddTaskActivity.taskList.remove(position);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(this, "Tarea completada ✔", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("Cancelar", null)
                    .show();

            return true; // consumimos el evento del long-press
        });

        // Botón Volver
        btnBack.setOnClickListener(v -> finish());
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (lvTasks.getAdapter() != null) {
            adapter.notifyDataSetChanged();
        }
    }
}
