package com.example.e_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Registro extends AppCompatActivity {

    Bundle bundle;
    EditText usr;
    EditText pass;
    EditText email;
    EditText confpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        bundle = getIntent().getExtras();
        usr = (EditText) findViewById(R.id.editTextPersonName);
        pass = (EditText) findViewById(R.id.editTextTextPassword);
        email = (EditText) findViewById(R.id.editTextEmailAddress);
        confpass = (EditText) findViewById(R.id.editTextTextPassword2);
    }

    public void registrar(View view) {
        if (usr.getText().toString().isEmpty()
                || pass.getText().toString().isEmpty()
                || email.getText().toString().isEmpty()
                || confpass.getText().toString().isEmpty()) return;
        Intent i = new Intent(this, PowerActivity.class );
        i.putExtra("direccion", usr.getText().toString());
        startActivity(i);
    }
}