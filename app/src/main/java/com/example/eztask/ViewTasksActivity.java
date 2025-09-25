package com.example.eztask;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class ViewTasksActivity extends AppCompatActivity {

    private ArrayAdapter<Task> adapter;
    private ListView lvTasks;
    private Button btnBack;

    //
    private String starsIcons(int stars) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stars; i++) {
            sb.append("⭐");
        }
        return sb.toString();
    }

    // Formato de fecha
    private String formatDate(long millis) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
        return sdf.format(millis);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tasks);

        lvTasks = findViewById(R.id.lvTasks);
        btnBack = findViewById(R.id.btnBack);

        // Adaptador personalizado para item_task.xml
        adapter = new ArrayAdapter<Task>(this, R.layout.item_task, AddTaskActivity.taskList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = getLayoutInflater().inflate(R.layout.item_task, parent, false);
                }

                Task t = getItem(position);

                TextView tvName = convertView.findViewById(R.id.tvTaskName);
                TextView tvStars = convertView.findViewById(R.id.tvTaskStars);

                tvName.setText(t.name);
                tvStars.setText(starsIcons(t.stars)); // para mostrar las estrellas a la derecha en la lista

                return convertView;
            }
        };
        lvTasks.setAdapter(adapter);

        // Tap corto: ver detalles
        lvTasks.setOnItemClickListener((parent, view, position, id) -> {
            if (position < 0 || position >= AddTaskActivity.taskList.size()) return;
            Task t = AddTaskActivity.taskList.get(position);

            String descShown = (t.description == null || t.description.trim().isEmpty())
                    ? "No se ingresarón detalles"
                    : t.description.trim();

            new AlertDialog.Builder(this)
                    .setTitle(t.name)
                    .setMessage(
                            "Descripción:\n" + descShown +
                                    "\n\nNivel de importancia:\n" + starsIcons(t.stars) +
                                    "\n\nFecha de creación:\n" + formatDate(t.createdAt)
                    )
                    .setPositiveButton("OK", null)
                    .show();
        });

        // Tap largo: marcar como completada
        lvTasks.setOnItemLongClickListener((parent, view, position, id) -> {
            if (position < 0 || position >= AddTaskActivity.taskList.size()) return true;
            Task t = AddTaskActivity.taskList.get(position);

            new AlertDialog.Builder(this)
                    .setTitle("¿Tarea lista?")
                    .setMessage("Completarás la siguiente tarea:\n\n• " + t.name + " " + starsIcons(t.stars))
                    .setPositiveButton("Sí, completar", (d, w) -> {
                        AddTaskActivity.taskList.remove(position);
                        adapter.notifyDataSetChanged();
                    })
                    .setNegativeButton("Cancelar", null)
                    .show();
            return true;
        });

        // Botón volver
        btnBack.setOnClickListener(v -> finish());
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}
