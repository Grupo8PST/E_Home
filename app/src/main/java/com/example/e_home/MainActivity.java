package com.example.e_home;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    EditText usuario, contra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = (EditText) findViewById(R.id.etus);
        contra = (EditText) findViewById(R.id.etcon);

    }

    public void iniciarse(View view) {
        Intent i = new Intent(this, MainActivity4.class);
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getReadableDatabase();
        String urio = usuario.getText().toString();
        String ctra = contra.getText().toString();
        String contra_ingresada=" ";
        try {

            Cursor fila = bd.rawQuery("select * from usuarios where usuario =" + "\""+ urio + "\""+" and contrasena="+ "\""+ ctra+ "\"", null);
            if (fila.moveToFirst()) {
                startActivity(i);
            }
            else
                Toast.makeText(this, "Datos incorrectos",
                        Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this, "Error",
                    Toast.LENGTH_SHORT).show();
        }

        bd.close();

    }

    public void registrarse(View view) {
        Intent i2 = new Intent(this, MainActivity3.class);
        startActivity(i2);
    }


}