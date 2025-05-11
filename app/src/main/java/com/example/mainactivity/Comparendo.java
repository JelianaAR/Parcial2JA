package com.example.mainactivity;

public class Comparendo {

    private String codigo;
    private String placa;
    private String marca;
    private String color;


    public Comparendo(String codigo, String placa, String marca, String color) {
        this.codigo = codigo;
        this.placa = placa;
        this.marca = marca;
        this.color = color;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Comparendo{" +
                "codigo='" + codigo + '\'' +
                ", placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}