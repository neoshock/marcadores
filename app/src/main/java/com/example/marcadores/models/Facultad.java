package com.example.marcadores.models;

public class Facultad {
    private  String nombre, decano, direccion, telefono, img;
    private double lat, alt;

    public Facultad(String nombre, String decano, String direccion, String telefono, String img) {
        this.nombre = nombre;
        this.decano = decano;
        this.direccion = direccion;
        this.telefono = telefono;
        this.img = img;
    }

    public Facultad(String nombre, String decano, String direccion, String telefono, String img, double lat, double alt) {
        this.nombre = nombre;
        this.decano = decano;
        this.direccion = direccion;
        this.telefono = telefono;
        this.img = img;
        this.lat = lat;
        this.alt = alt;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDecano() {
        return decano;
    }

    public void setDecano(String decano) {
        this.decano = decano;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getAlt() {
        return alt;
    }

    public void setAlt(double alt) {
        this.alt = alt;
    }

    @Override
    public String toString() {
        return String.format("%1$s,%2$s,%3$s,%4$s,%5$s", nombre, decano,direccion,telefono,img);
    }
}
