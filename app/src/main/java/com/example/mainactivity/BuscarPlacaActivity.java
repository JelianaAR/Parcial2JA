package com.example.mainactivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BuscarPlacaActivity extends AppCompatActivity {

    EditText edtPlacaBuscar;
    Button btnBuscarPlaca;
    TextView txtResultado;
    ComparendoController ComparendoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscarplaca);

        edtPlacaBuscar =findViewById(R.id.edtPlacaBuscar);
        btnBuscarPlaca = findViewById(R.id.btnBuscarPlaca);
        txtResultado = findViewById(R.id.txtResultado);
        ComparendoController = new ComparendoController(this);

        btnBuscarPlaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String placa = edtPlacaBuscar.getText().toString().trim();
                if (placa.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Ingrese una placa", Toast.LENGTH_SHORT).show();
                    return;
                }

                Cursor c = null;
                try {
                    c = ComparendoController.buscarComparendoPorPlaca(placa);
                    if (c != null && c.moveToFirst()) {
                        String codigo = c.getString(c.getColumnIndexOrThrow("codigo"));
                        String color = c.getString(c.getColumnIndexOrThrow("color"));
                        String marca = c.getString(c.getColumnIndexOrThrow("marca"));

                        txtResultado.setText("Código: " + codigo + "\nPlaca: " + placa + "\nColor: " + color + "\nMarca: " + marca);
                    } else {
                        txtResultado.setText("No se encontró ningún carro con la placa: " + placa);
                    }
                } catch (Exception ex) {
                    txtResultado.setText("Error buscando: " + ex.getMessage());
                    ex.printStackTrace();
                } finally {
                    if (c != null) {
                        c.close();
                    }
                }
            }
        });
    }
}