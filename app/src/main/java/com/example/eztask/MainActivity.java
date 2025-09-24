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

            // Validar campo usuario
            if (TextUtils.isEmpty(user) || user.equalsIgnoreCase("ingresa usuario")) {
                etUser.setError("Usuario inválido");
                etUser.requestFocus();
                return;
            }

            // Validar campo contraseña
            if (TextUtils.isEmpty(pass)) {
                etPassword.setError("Ingresa la contraseña");
                etPassword.requestFocus();
                return;
            }

            // si los campos son válidos, continuar
            Intent intent = new Intent(MainActivity.this, TaskMenuActivity.class);
            intent.putExtra("username", user); // enviamos el nombre del usuario
            startActivity(intent);

            // Mensaje de bienvenida
            Toast.makeText(this, "Bienvenido " + user, Toast.LENGTH_SHORT).show();
        });
    }
}
