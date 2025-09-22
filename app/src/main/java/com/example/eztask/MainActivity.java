package com.example.eztask;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Mantener padding para edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Referencias a vistas (ids deben existir en activity_main.xml)
        EditText etUser = findViewById(R.id.etUser);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String user = etUser.getText().toString().trim();
            String pass = etPassword.getText().toString().trim();

            // Validaciones mínimas (no vacíos)
            if (TextUtils.isEmpty(user)) {
                etUser.setError("Ingresa usuario o correo");
                etUser.requestFocus();
                return;
            }
            if (TextUtils.isEmpty(pass)) {
                etPassword.setError("Ingresa la contraseña");
                etPassword.requestFocus();
                return;
            }

            // Login abierto: si no están vacíos, continuar
            Intent intent = new Intent(MainActivity.this, TaskMenuActivity.class);
            intent.putExtra("username", user); // enviamos el nombre del usuario
            startActivity(intent);
        });
    }
}
