package com.example.mainactivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class ComparendoController {
    private BaseDatos bd;
    private Context c;
    public ComparendoController(Context c) {
        this.bd = new BaseDatos(c,1);
        this.c = c;
    }
    public void agregarComparendo(Comparendo e) {
        try {

            ContentValues valores = new ContentValues();
            valores.put(DefBD.col_codigo, e.getCodigo());
            valores.put(DefBD.col_placa, e.getPlaca());
            valores.put(DefBD.col_marca, e.getMarca());
            valores.put(DefBD.col_color, e.getColor());

            if (!buscarComparendo(e)) {
                SQLiteDatabase sql = bd.getWritableDatabase();
                long id = sql.insert(DefBD.tabla_comparendo, null, valores);
                Toast.makeText(c, "Comparendo registrado", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(c, "Comparendo ya existe", Toast.LENGTH_LONG).show();
            }
        }        catch(Exception ex){
            Toast.makeText(c, "Error agregando Comparendo " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public boolean buscarComparendo(Comparendo e){
        String args[] = new String[] {e.getCodigo()};
        String[] columnas = {DefBD.col_codigo,DefBD.col_placa, DefBD.col_color};
        String[] orden = { DefBD.col_marca};
        String col[] = new String[] {DefBD.col_codigo,DefBD.col_placa, DefBD.col_color, DefBD.col_marca};
        SQLiteDatabase sql1 = bd.getReadableDatabase();

        Cursor c = sql1.query(DefBD.tabla_comparendo,null,"codigo=?",args,null,null,null);
        if (c.getCount()>0){
            bd.close();
            return true;
        }
        else{
            bd.close();
            return false;
        }
    }

    public boolean buscarComparendo(String cod){
        String args[] = new String[] {cod};
        String[] columnas = {DefBD.col_codigo,DefBD.col_placa, DefBD.col_color};
        String[] orden = { DefBD.col_marca};
        String col[] = new String[] {DefBD.col_codigo,DefBD.col_placa, DefBD.col_color, DefBD.col_marca};
        SQLiteDatabase sql1 = bd.getReadableDatabase();

        Cursor c = sql1.query(DefBD.tabla_comparendo,null,"codigo=?",args,null,null,null);
        if (c.getCount()>0){
            bd.close();
            return true;
        }
        else{
            bd.close();
            return false;
        }
    }

    public Cursor buscarComparendoPorPlaca(String placa) {
        try {
            SQLiteDatabase sql = bd.getReadableDatabase();
            String[] args = {placa};
            return sql.query(DefBD.tabla_comparendo, null, "placa=?", args, null, null, null);
        } catch (Exception ex) {
            Toast.makeText(c, "Error buscando por placa: " + ex.getMessage(), Toast.LENGTH_LONG).show();
            return null;
        }
    }

    public Cursor allComparendo(){
        try{
            SQLiteDatabase sql = bd.getReadableDatabase();
            Cursor c = sql.query(DefBD.tabla_comparendo,null,null,null,null,null,null);
            return c;
        }
        catch (Exception ex){
            Toast.makeText(c, "Error consulta comparendos " + ex.getMessage(), Toast.LENGTH_LONG).show();
            return null;
        }
    }

    public Cursor allComparendo2(){
        try{
            SQLiteDatabase sql = bd.getReadableDatabase();
            Cursor cur = sql.rawQuery("select codigo as _id , placa, color, marca from comparendo order by " + DefBD.col_codigo, null);
            return cur;
        }
        catch (Exception ex){
            Toast.makeText(c, "Error consulta Comparendos " + ex.getMessage(), Toast.LENGTH_LONG).show();
            return null;
        }
    }

    public void eliminarComparendo(String cod){
        try{

            String[] args = {cod};
            if (!buscarComparendo(cod)) {
                Toast.makeText(c, "Codigo no existe", Toast.LENGTH_LONG).show();
            }
            else {
                SQLiteDatabase sql = bd.getWritableDatabase();
                sql.delete(DefBD.tabla_comparendo, "codigo=?", args);
                Toast.makeText(c, "Comparendo eliminado", Toast.LENGTH_LONG).show();
            }
        }
        catch (Exception ex){
            Toast.makeText(c, "Error eliminar comparendo " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void actualizarComparendo(Comparendo e){
        try{
            SQLiteDatabase sql = bd.getReadableDatabase();
            String[] args = {e.getCodigo()};
            ContentValues valores = new ContentValues();
            valores.put(DefBD.col_placa, e.getPlaca());
            valores.put(DefBD.col_color, e.getColor());
            valores.put(DefBD.col_marca, e.getMarca());
            sql.update(DefBD.tabla_comparendo,valores,"codigo=?",args);
            Toast.makeText(c, "Comparendo actualizado", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex){
            Toast.makeText(c, "Error actualizar Comparendo " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
