package com.example.e_home;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText usr;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usr = (EditText) findViewById(R.id.editText);
        pass = (EditText) findViewById(R.id.editTextPassword);
    }

    public void login(View view) {
        if (usr.getText().toString().isEmpty() || pass.getText().toString().isEmpty()) return;
        Intent i = new Intent(this, PowerActivity.class );
        i.putExtra("direccion", usr.getText().toString());
        startActivity(i);
    }

    public void registrar(View view) {
        Intent i = new Intent(this, Registro.class );
        if (!usr.getText().toString().isEmpty()) {
            i.putExtra("nomUsuario", usr.getText().toString());
        }
        if (!pass.getText().toString().isEmpty()) {
            i.putExtra("pswd", pass.getText().toString());
        }
        startActivity(i);
    }

}