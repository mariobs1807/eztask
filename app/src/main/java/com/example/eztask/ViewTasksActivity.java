package com.example.eztask;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewTasksActivity extends AppCompatActivity {

    private ArrayAdapter<String> adapter;
    private ListView lvTasks;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tasks);

        // Referencias a vistas (IDs del XML: lvTasks y btnBack)
        lvTasks = findViewById(R.id.lvTasks);
        btnBack = findViewById(R.id.btnBack);

        // Adaptador que muestra lo guardado en AddTaskActivity.taskList (memoria)
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                AddTaskActivity.taskList
        );
        lvTasks.setAdapter(adapter);

        // Botón "Volver": cierra esta Activity y regresa al menú (TaskMenuActivity)
        btnBack.setOnClickListener(v -> finish());
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Si se agregaron nuevas tareas, refresca la lista
        if (lvTasks.getAdapter() != null) {
            adapter.notifyDataSetChanged();
        }
    }
}
