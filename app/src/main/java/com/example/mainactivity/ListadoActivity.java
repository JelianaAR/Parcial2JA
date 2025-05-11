package com.example.mainactivity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListadoActivity extends AppCompatActivity {

    ListView listado;
    ComparendoController ComparendoController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        listado = findViewById(R.id.lstlistado);
        ComparendoController = new ComparendoController(this);
        Cursor c = ComparendoController.allComparendo2();
        ComparendoCursorAdapter ecursor = new ComparendoCursorAdapter(this,c,false);
        listado.setAdapter(ecursor);
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView cod = view.findViewById(R.id.txtcodigo);
                TextView placa = view.findViewById(R.id.txtplaca);
                TextView color = view.findViewById(R.id.txtcolor);
                TextView marca = view.findViewById(R.id.txtmarca);
                Toast.makeText(getApplicationContext(),cod.getText().toString() + "," + placa.getText().toString()
                        + "," + color.getText().toString() + "," + marca.getText().toString(),Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), EdicionActivity.class);
                i.putExtra("codigo", cod.getText().toString());
                i.putExtra("placa", placa.getText().toString());
                i.putExtra("color", color.getText().toString());
                i.putExtra("marca", marca.getText().toString());
                startActivity(i);
            }
        });
    }
}