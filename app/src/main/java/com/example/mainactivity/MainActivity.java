package com.example.mainactivity;

import android.os.Bundle;
import android.content.Intent;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Comparendo e;
    ComparendoController ec;
    EditText codigo, placa, color, marca;
    Button agregar, cancelar, mostrar, buscarPla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        codigo = findViewById(R.id.edtcodigo);
        placa = findViewById(R.id.edtplaca);
        color = findViewById(R.id.edtcolor);
        marca = findViewById(R.id.edtmarca);

        agregar = findViewById(R.id.btnguardar);
        cancelar = findViewById(R.id.btncancelar);
        mostrar = findViewById(R.id.btnlistado);
        buscarPla = findViewById(R.id.btnBuscarPla);

        agregar.setOnClickListener(this);
        mostrar.setOnClickListener(this);
        cancelar.setOnClickListener(this);
        buscarPla.setOnClickListener(this);

        ec = new ComparendoController(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnguardar) {
            if (TextUtils.isEmpty(codigo.getText().toString()) || TextUtils.isEmpty(placa.getText().toString()) ||
                    TextUtils.isEmpty(color.getText().toString()) || TextUtils.isEmpty(marca.getText().toString())) {
                Toast.makeText(this, "Los datos no pueden ser vacíos", Toast.LENGTH_LONG).show();
            } else {
                e = new Comparendo(codigo.getText().toString(), placa.getText().toString(),
                        color.getText().toString(), marca.getText().toString());
                if (ec.buscarComparendo(e)) {
                    Toast.makeText(this, "Código ya existe", Toast.LENGTH_LONG).show();
                } else {
                    ec.agregarComparendo(e);
                }
            }
        }

        if (v.getId() == R.id.btnlistado) {
            Intent i = new Intent(this, ListadoActivity.class);
            startActivity(i);
        }

        if (v.getId() == R.id.btncancelar) {
            codigo.setText("");
            color.setText("");
            marca.setText("");
            placa.setText("");
        }

        if (v.getId() == R.id.btnBuscarPla) {
            Toast.makeText(this, "Buscando", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, BuscarPlacaActivity.class);
            startActivity(intent);
        }
    }
}