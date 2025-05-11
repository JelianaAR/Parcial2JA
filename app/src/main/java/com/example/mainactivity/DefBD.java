package com.example.mainactivity;


public class DefBD {

    public static final String nameDb = "Fotomulta";
    public static final String tabla_comparendo = "comparendo";
    public static final String col_codigo = "codigo";
    public static final String col_placa = "placa";
    public static final String col_marca = "marca";
    public static final String col_color = "color";

    public static final String create_tabla_comparendo = "CREATE TABLE IF NOT EXISTS " + DefBD.tabla_comparendo + " ( " +
            DefBD.col_codigo + " text primary key," +
            DefBD.col_placa + " text," +
            DefBD.col_color + " text," +
            DefBD.col_marca + " text" +
            ");";


}
