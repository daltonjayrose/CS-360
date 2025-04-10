package com.example.daltonrose_cs360;

import android.content.Intent;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private UserDatabase userDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.editTextText);
        passwordEditText = findViewById(R.id.editTextTextPassword);
        loginButton = findViewById(R.id.button);

        userDatabase = new UserDatabase(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin();
            }
        });
    }

    private void handleLogin() {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            Toast.makeText(Login.this, "Please enter a username and password.", Toast.LENGTH_SHORT).show();
            return;
        }

        Cursor userCursor = userDatabase.getUser(username);
        if (userCursor.moveToFirst()) {
            String storedPassword = userCursor.getString(userCursor.getColumnIndexOrThrow("password"));
            if (storedPassword.equals(password)) {
                Toast.makeText(Login.this, "Login successful.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(Login.this, "Incorrect password.", Toast.LENGTH_SHORT).show();
            }
        } else {
            userDatabase.addUser(username, password);
            Toast.makeText(Login.this, "Account created.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
        }
        userCursor.close();
    }
}
