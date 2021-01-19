package com.example.e_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    EditText nombres, apellidos, correo, usuario, contra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        nombres = (EditText) findViewById(R.id.etnom);
        apellidos = (EditText) findViewById(R.id.etap);
        correo = (EditText) findViewById(R.id.etco);
        usuario = (EditText) findViewById(R.id.etu);
        contra = (EditText) findViewById(R.id.etc);
    }

    public void registro(View view) {


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);

        String nom = nombres.getText().toString();
        String ape = apellidos.getText().toString();
        String corr = correo.getText().toString();
        String usuar = usuario.getText().toString();
        String cont = contra.getText().toString();

        if(nom.isEmpty()||ape.isEmpty()||corr.isEmpty()||usuar.isEmpty()||cont.isEmpty()){
            Toast.makeText(this, "Datos Incompletos",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        SQLiteDatabase bd = admin.getWritableDatabase();

        bd.execSQL("insert into usuarios (usuario,nombre,apellido,correo,contrasena) values ('"+usuar+"','"+nom+"','"+ape+"','"+corr+"','"+cont+"')");
        bd.close();
        nombres.setText("");
        apellidos.setText("");
        correo.setText("");
        usuario.setText("");
        contra.setText("");
        Toast.makeText(this, "Te has registrado",
                Toast.LENGTH_SHORT).show();

    }
    public void volver(View view) {

        finish();
    }
}