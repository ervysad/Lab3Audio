/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author ERVYSAD
 */
import java.util.ArrayList;
import java.util.List;


public class Producto {
    private String nombre;
    private double precio;
    

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public  void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public  void setPrecio(double precio){
        this.precio = precio;
    }

}
