package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EdicionActivity extends AppCompatActivity {

    EditText codigo, placa, color, marca;
    Button actualizar, eliminar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicion);
        Intent i = getIntent();
        String cod = i.getStringExtra("codigo");
        String pla = i.getStringExtra("placa");
        String col = i.getStringExtra("color");
        String marc = i.getStringExtra("marca");

        codigo = findViewById(R.id.edtCod);
        placa = findViewById(R.id.edtPla);
        marca = findViewById(R.id.edtMarca);
        color = findViewById(R.id.edtColor);
        actualizar = findViewById(R.id.btnActualizar);
        eliminar = findViewById(R.id.btnEliminar);

        codigo.setText(cod);
        codigo.setEnabled(false);
        placa.setText(pla);
        color.setText(col);
        marca.setText(marc);
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(EdicionActivity.this);
                builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ComparendoController ec = new ComparendoController(getApplication());
                        ec.eliminarComparendo(codigo.getText().toString());
                        Intent i = new Intent(getApplicationContext(),ListadoActivity.class);
                        startActivity(i);
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
                builder.setMessage("Esta seguro de Eliminar el registro?")
                        .setTitle("PARQUEADERO");
                builder.show();
            }
        });
        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Comparendo e = new Comparendo(codigo.getText().toString(),placa.getText().toString(),color.getText().toString(),marca.getText().toString());
                ComparendoController ec = new ComparendoController(getApplication());
                ec.actualizarComparendo(e);
                Intent i = new Intent(getApplicationContext(),ListadoActivity.class);
                startActivity(i);
            }
        });
    }
}
