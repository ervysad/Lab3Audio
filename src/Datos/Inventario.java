/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ERVYSAD
 */
public class Inventario {
    
    private List<Producto> listProducto;

    public Inventario() {
        listProducto = new ArrayList();
    }

    public List<Producto> getListProducto() {
        return listProducto;
    }

    public void setListProducto(List<Producto> listProducto) {
        this.listProducto = listProducto;
    }
    
    public void agregarProducto(Producto producto){
        listProducto.add(producto);
    }
    
    public void borrarProducto(Producto producto){
        listProducto.remove(producto);
    }
    
}
