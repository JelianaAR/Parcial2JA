package com.example.mainactivity;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class ComparendoCursorAdapter extends CursorAdapter {
    public ComparendoCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.fila_comparendo,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView cod = view.findViewById(R.id.txtcodigo);
        TextView pla = view.findViewById(R.id.txtplaca);
        TextView col = view.findViewById(R.id.txtcolor);
        TextView marc = view.findViewById(R.id.txtmarca);

        String codigo = cursor.getString(0);
        String placa = cursor.getString(1);
        String color = cursor.getString(2);
        String marca = cursor.getString(3);

        cod.setText(codigo);
        pla.setText(placa);
        col.setText(color);
        marc.setText(marca);
    }
}